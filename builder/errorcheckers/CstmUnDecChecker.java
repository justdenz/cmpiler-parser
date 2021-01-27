package builder.errorcheckers;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import builder.CstmBuildChecker;
import builder.CstmErrorRepo;
import model.CUSTOMParser.CallContext;
import model.CUSTOMParser.ExpressionContext;
import model.CUSTOMParser.MutableContext;
import console.Console;
import semantics.representations.CstmValue;
import semantics.representations.CstmFunction;
import semantics.symboltable.CstmSymbolTable;
import semantics.symboltable.scopes.CstmClassScope;
import semantics.symboltable.scopes.CstmLocalScopeCreator;

public class CstmUnDecChecker implements CstmErrCheckerInterface, ParseTreeListener{
    private ExpressionContext exprCtx;
	private int lineNumber;
	
	public CstmUnDecChecker(ExpressionContext exprCtx) {
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

		CstmClassScope classScope = CstmSymbolTable.getInstance().getClassScope();
		CstmFunction function = classScope.searchFunction(callCtx.IDENTIFIER().getText());
		
		if(function == null) {
			CstmBuildChecker.reportCustomError(CstmErrorRepo.UNDECLARED_FUNCTION, "Function not found", this.lineNumber);
		}
		else {
			Console.log("Function found: " +function.getFunctionName());
		}
	}
	
	private void verifyVariable(ParserRuleContext ctx) {

        MutableContext mutableCtx = (MutableContext) ctx;

        CstmClassScope classScope = CstmSymbolTable.getInstance().getClassScope();
		CstmValue value = classScope.getVariable(mutableCtx.IDENTIFIER().getText());
		
		if(value == null) {
			CstmBuildChecker.reportCustomError(CstmErrorRepo.UNDECLARED_VARIABLE, "Variable not found", this.lineNumber);
        } else {
			Console.log("Variable found: " +value.getValue().toString());
		}
	}
}
