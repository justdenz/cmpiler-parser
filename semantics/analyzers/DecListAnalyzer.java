package semantics.analyzers;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import console.Console;
import execution.ExecutionManager;
import execution.commands.VarInitCommand;
import builder.errorcheckers.CstmMulVarDecChecker;
import builder.errorcheckers.CstmTypeChecker;
import builder.errorcheckers.CstmUnDecChecker;
import model.CUSTOMParser.DeclarationContext;
import model.CUSTOMParser.ExpressionContext;
import model.CUSTOMParser.TypeSpecifierContext;
import model.CUSTOMParser.VariableDeclarationContext;
import model.CUSTOMParser.VariableDeclarationInitializeContext;
import model.CUSTOMParser.ArrayDeclarationContext;
import model.CUSTOMParser.ConstantContext;
import semantics.utils.CstmKeywords;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;
import semantics.representations.CstmArray;
import semantics.representations.CstmValue;

public class DecListAnalyzer implements ParseTreeListener{
	
	public DecListAnalyzer() {}
	
	public void analyze(DeclarationContext decListCtx) {
		ParseTreeWalker treeWalker = new ParseTreeWalker();
		treeWalker.walk(this, decListCtx);
	}

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		if(ctx instanceof DeclarationContext){
			DeclarationContext decCtx = (DeclarationContext) ctx;
			CstmValue cstmValue = null;
			// check muna if may multiple declaration ng var or array sa GlobalScopeManager within the current scope
			CstmMulVarDecChecker checker = new CstmMulVarDecChecker(decCtx);
			checker.verify();

			// check if variable declaration
			if(decCtx.variableDeclaration() != null){
				VariableDeclarationContext varDecCtx = decCtx.variableDeclaration();
				
				if(varDecCtx.typeSpecifier().Int() != null){
					cstmValue = new CstmValue(null, CstmKeywords.IS_INT);
				} else if(varDecCtx.typeSpecifier().Boolean() != null){
					cstmValue = new CstmValue(null, CstmKeywords.IS_BOOLEAN);
				} else if(varDecCtx.typeSpecifier().String() != null){
					cstmValue = new CstmValue(null, CstmKeywords.IS_STRING);
				} else if(varDecCtx.typeSpecifier().Float() != null){
					cstmValue = new CstmValue(null, CstmKeywords.IS_FLOAT);
				}

				// check if may constant declaration
				if(cstmValue != null && varDecCtx.ConstantKey() != null){
					cstmValue.markConstant();
				}

				// if may assignment of value, check if declared or compatible types
				if(varDecCtx.variableDeclarationInitialize().Assign() != null){
					CstmUnDecChecker undeclaredChecker = new CstmUnDecChecker(varDecCtx.variableDeclarationInitialize().simpleExpression());
					undeclaredChecker.verify();
					CstmTypeChecker typeChecker = new CstmTypeChecker(cstmValue, varDecCtx.variableDeclarationInitialize().simpleExpression());
					typeChecker.verify();

					VarInitCommand varInitCmd = new VarInitCommand(varDecCtx.variableDeclarationInitialize().IDENTIFIER(), varDecCtx.variableDeclarationInitialize().simpleExpression());
					ExecutionManager.getInstance().addCommand(varInitCmd);
				}

				CstmLocalScope currentScope = GlobalScopeManager.getInstance().getCurrentScope();
				currentScope.addVariable(varDecCtx.variableDeclarationInitialize().IDENTIFIER().getText(), cstmValue);
			}
			// check if array declaration
			else if(decCtx.arrayDeclaration() != null){
				ArrayDeclarationContext arrDecCtx = decCtx.arrayDeclaration();
				CstmArray cstmArray = null;

				if(arrDecCtx.arrayTypeSpecifier().typeSpecifier().Int() != null){
					cstmArray = CstmArray.createArray(CstmKeywords.IS_INT, arrDecCtx.arrayDeclarationInitialize().IDENTIFIER().getText());
				} else if(arrDecCtx.arrayTypeSpecifier().typeSpecifier().Boolean() != null){
					cstmArray = CstmArray.createArray(CstmKeywords.IS_BOOLEAN, arrDecCtx.arrayDeclarationInitialize().IDENTIFIER().getText());
				} else if(arrDecCtx.arrayTypeSpecifier().typeSpecifier().String() != null){
					cstmArray = CstmArray.createArray(CstmKeywords.IS_STRING, arrDecCtx.arrayDeclarationInitialize().IDENTIFIER().getText());
				} else if(arrDecCtx.arrayTypeSpecifier().typeSpecifier().Float() != null){
					cstmArray = CstmArray.createArray(CstmKeywords.IS_FLOAT, arrDecCtx.arrayDeclarationInitialize().IDENTIFIER().getText());
				}
	
				cstmValue = new CstmValue(cstmArray, CstmKeywords.IS_ARRAY);

				if(cstmValue != null && arrDecCtx.ConstantKey() != null){
					cstmValue.markConstant();
				}

				// if may assignment of array value, check if declared or compatible types
				if(arrDecCtx.arrayDeclarationInitialize().simpleExpression() != null){
					CstmUnDecChecker undeclaredChecker = new CstmUnDecChecker(arrDecCtx.arrayDeclarationInitialize().arrayExpression().simpleExpression());
					CstmTypeChecker typeChecker = new CstmTypeChecker(cstmValue, arrDecCtx.arrayDeclarationInitialize().arrayExpression().simpleExpression());
					undeclaredChecker.verify();
					typeChecker.verify();
				} else if(arrDecCtx.arrayDeclarationInitialize().arrayExpression() != null){
					// (arrVarType = create arrValueType) i-check if same type ba yung variable and value assigned
					TypeSpecifierContext arrVarType = arrDecCtx.arrayTypeSpecifier().typeSpecifier();
					TypeSpecifierContext arrValueType = arrDecCtx.arrayDeclarationInitialize().arrayExpression().typeSpecifier();

					if(arrVarType.Int() != null && arrValueType.Int() == null){
						Console.log(String.valueOf(arrDecCtx.getStart().getLine()) , "Found mismatch type for Integer Array");
					} else if(arrVarType.Boolean() != null && arrValueType.Boolean() == null){
						Console.log(String.valueOf(arrDecCtx.getStart().getLine()), "Found mismatch type for Boolean Array");
					} else if(arrVarType.String() != null && arrValueType.String() == null){
						Console.log(String.valueOf(arrDecCtx.getStart().getLine()), "Found mismatch type for String Array");
					} else if(arrVarType.Float() != null && arrValueType.Float() == null){
						Console.log(String.valueOf(arrDecCtx.getStart().getLine()), "Found mismatch type for Float Array");
					}

					CstmLocalScope currentScope = GlobalScopeManager.getInstance().getCurrentScope();
					currentScope.addVariable(arrDecCtx.arrayDeclarationInitialize().IDENTIFIER().getText(), cstmValue);
				}
			}
		}
		
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		
    }
	
	@Override
	public void visitTerminal(TerminalNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitErrorNode(ErrorNode node) {
		// TODO Auto-generated method stub
		
	}
}
