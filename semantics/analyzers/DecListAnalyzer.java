package semantics.analyzers;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import console.Console;
import execution.ExecutionManager;
import execution.commands.ArrayCreateCommand;
import execution.commands.ArrayInitCommand;
import execution.commands.VarInitCommand;
import builder.errorcheckers.CstmMulVarDecChecker;
import builder.errorcheckers.CstmTypeChecker;
import builder.errorcheckers.CstmUnDecChecker;
import model.CUSTOMParser.DeclarationContext;
import model.CUSTOMParser.TypeSpecifierContext;
import model.CUSTOMParser.VariableDeclarationContext;
import model.CUSTOMParser.ArrayDeclarationContext;
import semantics.utils.CstmKeywords;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;
import semantics.representations.CstmArray;
import semantics.representations.CstmValue;
import semantics.representations.CstmValue.PrimitiveType;

public class DecListAnalyzer implements AnalyzerInterface, ParseTreeListener{

	private DeclarationContext decListCtx;
	
	public DecListAnalyzer(DeclarationContext decListCtx) {
		this.decListCtx = decListCtx;
	}
	
	@Override
	public void analyze() {
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

				if(arrDecCtx.arrayDeclarationInitialize().IDENTIFIER() != null){
					if(arrDecCtx.arrayTypeSpecifier().typeSpecifier().Int() != null){
						cstmArray = CstmArray.createArray(CstmKeywords.IS_INT, arrDecCtx.arrayDeclarationInitialize().IDENTIFIER().getText());
					} else if(arrDecCtx.arrayTypeSpecifier().typeSpecifier().Boolean() != null){
						cstmArray = CstmArray.createArray(CstmKeywords.IS_BOOLEAN, arrDecCtx.arrayDeclarationInitialize().IDENTIFIER().getText());
					} else if(arrDecCtx.arrayTypeSpecifier().typeSpecifier().String() != null){
						cstmArray = CstmArray.createArray(CstmKeywords.IS_STRING, arrDecCtx.arrayDeclarationInitialize().IDENTIFIER().getText());
					} else if(arrDecCtx.arrayTypeSpecifier().typeSpecifier().Float() != null){
						cstmArray = CstmArray.createArray(CstmKeywords.IS_FLOAT, arrDecCtx.arrayDeclarationInitialize().IDENTIFIER().getText());
					}
				}
				
				cstmValue = new CstmValue(cstmArray, CstmKeywords.IS_ARRAY);

				if(cstmValue != null && arrDecCtx.ConstantKey() != null){
					cstmValue.markConstant();
				}

				// if may assignment of array value to another array
				if(arrDecCtx.arrayDeclarationInitialize().mutable() != null){

					CstmValue currValue = GlobalScopeManager.getInstance().searchScopedVariable(arrDecCtx.arrayDeclarationInitialize().mutable().IDENTIFIER().getText());

					if (currValue != null) {
						if (currValue.getPrimitiveType() == PrimitiveType.ARRAY) {
							CstmArray leftArr = (CstmArray) cstmValue.getValue();
							CstmArray rightArr = (CstmArray) currValue.getValue();

							if(leftArr.getPrimitiveType() == PrimitiveType.INT && rightArr.getPrimitiveType() != PrimitiveType.INT) {
								Console.log(String.valueOf(arrDecCtx.arrayDeclarationInitialize().getStart().getLine()), "Found mismatch type for Integer Array.");
							}
							else if(leftArr.getPrimitiveType() == PrimitiveType.BOOLEAN && rightArr.getPrimitiveType() != PrimitiveType.BOOLEAN) {
								Console.log(String.valueOf(arrDecCtx.arrayDeclarationInitialize().getStart().getLine()), "Found mismatch type for Boolean Array.");
							}
							else if(leftArr.getPrimitiveType() == PrimitiveType.STRING && rightArr.getPrimitiveType() != PrimitiveType.STRING) {
								Console.log(String.valueOf(arrDecCtx.arrayDeclarationInitialize().getStart().getLine()), "Found mismatch type for String Array.");
							}
							else if(leftArr.getPrimitiveType() == PrimitiveType.FLOAT && rightArr.getPrimitiveType() != PrimitiveType.FLOAT) {
								Console.log(String.valueOf(arrDecCtx.arrayDeclarationInitialize().getStart().getLine()), "Found mismatch type for Float Array.");
							}
						} else {
							Console.log(String.valueOf(arrDecCtx.arrayDeclarationInitialize().getStart().getLine()), "Found an array type mismatch error.");
						}

						
						ArrayInitCommand arrayInitCommand = new ArrayInitCommand(arrDecCtx.arrayDeclarationInitialize().IDENTIFIER(), arrDecCtx.arrayDeclarationInitialize().mutable());
						ExecutionManager.getInstance().addCommand(arrayInitCommand);
					} else {
						Console.log(String.valueOf(String.valueOf(arrDecCtx.arrayDeclarationInitialize().getStart().getLine())), "Found an undeclared array value.");
					}
				} 
				// (arrVarType = create arrValueType) i-check if same type ba yung variable and value assigned
				else if(arrDecCtx.arrayDeclarationInitialize().arrayExpression() != null){
					
					TypeSpecifierContext arrVarType = arrDecCtx.arrayTypeSpecifier().typeSpecifier();
					TypeSpecifierContext arrValueType = arrDecCtx.arrayDeclarationInitialize().arrayExpression().typeSpecifier();

					if(arrVarType.Int() != null && arrValueType.Int() == null){
						Console.log(String.valueOf(arrDecCtx.getStart().getLine()) , "Found mismatch type for Integer Array");
					} 
					else if(arrVarType.Boolean() != null && arrValueType.Boolean() == null){
						Console.log(String.valueOf(arrDecCtx.getStart().getLine()), "Found mismatch type for Boolean Array");
					} 
					else if(arrVarType.String() != null && arrValueType.String() == null){
						Console.log(String.valueOf(arrDecCtx.getStart().getLine()), "Found mismatch type for String Array");
					} 
					else if(arrVarType.Float() != null && arrValueType.Float() == null){
						Console.log(String.valueOf(arrDecCtx.getStart().getLine()), "Found mismatch type for Float Array");
					}

					CstmValue tempEmptyIntVal = new CstmValue(null, CstmKeywords.IS_INT);
					CstmTypeChecker typeChecker = new CstmTypeChecker(tempEmptyIntVal, arrDecCtx.arrayDeclarationInitialize().arrayExpression().simpleExpression());
					typeChecker.verify();

					ArrayCreateCommand arrCreateCmd = new ArrayCreateCommand(cstmArray, arrDecCtx.arrayDeclarationInitialize().arrayExpression().simpleExpression());
					ExecutionManager.getInstance().addCommand(arrCreateCmd);
				}

				if(arrDecCtx.arrayDeclarationInitialize().IDENTIFIER() != null){
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
