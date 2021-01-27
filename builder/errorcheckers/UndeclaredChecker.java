package builder.errorcheckers;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import builder.BuildChecker;
import builder.ErrorRepository;
import model.CUSTOMParser.CallContext;
import model.CUSTOMParser.ExpressionContext;
import model.CUSTOMParser.MutableContext;
import console.Console;
import semantics.representations.Value;
import semantics.representations.Function;
import semantics.symboltable.SymbolTable;
import semantics.symboltable.scopes.ClassScope;
import semantics.symboltable.scopes.LocalScopeCreator;

public class UndeclaredChecker implements ErrorCheckerInterface, ParseTreeListener{
    private ExpressionContext exprCtx;
	private int lineNumber;
	
	public UndeclaredChecker(ExpressionContext exprCtx) {
		this.exprCtx = exprCtx;
		
		Token firstToken = this.exprCtx.getStart();
		this.lineNumber = firstToken.getLine();
	}
	
	@Override
	public void verify() {
		ParseTreeWalker treeWalker = new ParseTreeWalker();
		treeWalker.walk(this, this.exprCtx);
	}

	@Override
	public void visitTerminal(TerminalNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitErrorNode(ErrorNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
        if(ctx instanceof MutableContext){
            this.verifyVariable(ctx);
        } else if (ctx instanceof CallContext){
            this.verifyFunction(ctx);
        }
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		
	}
	
	private void verifyFunction(ParserRuleContext ctx) {

        CallContext callCtx = (CallContext) ctx;

		ClassScope classScope = SymbolTable.getInstance().getClassScope();
		Function function = classScope.searchFunction(callCtx.IDENTIFIER().getText());
		
		if(function == null) {
			BuildChecker.reportCustomError(ErrorRepository.UNDECLARED_FUNCTION, "Function not found", this.lineNumber);
		}
		else {
			Console.log("Function found: " +function.getFunctionName());
		}
	}
	
	private void verifyVariable(ParserRuleContext ctx) {

        MutableContext mutableCtx = (MutableContext) ctx;

        ClassScope classScope = SymbolTable.getInstance().getClassScope();
		Value value = classScope.getVariable(mutableCtx.IDENTIFIER().getText());
		
		if(value == null) {
			BuildChecker.reportCustomError(ErrorRepository.UNDECLARED_VARIABLE, "Variable not found", this.lineNumber);
        } else {
			Console.log("Variable found: " +value.getValue().toString());
		}
	}
}
