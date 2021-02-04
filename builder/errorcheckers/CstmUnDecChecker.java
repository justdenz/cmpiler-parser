package builder.errorcheckers;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import model.CUSTOMParser.CallContext;
import model.CUSTOMParser.ExpressionContext;
import model.CUSTOMParser.MutableContext;
import model.CUSTOMParser.SimpleExpressionContext;
import console.Console;
import semantics.representations.CstmValue;
import semantics.representations.CstmFunction;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;

public class CstmUnDecChecker implements CstmErrCheckerInterface, ParseTreeListener{
    private SimpleExpressionContext exprCtx;
	private int lineNumber;
	
	public CstmUnDecChecker(SimpleExpressionContext exprCtx) {
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
	
	private void verifyVariable(ParserRuleContext ctx) {

		MutableContext mutableCtx = (MutableContext) ctx;
		CstmValue value = GlobalScopeManager.getInstance().searchScopedVariable(mutableCtx.IDENTIFIER().getText());
		
		if(value == null) {
			Console.log(String.valueOf(this.lineNumber) , "Variable not found.");
        }
	}

	private void verifyFunction(ParserRuleContext ctx) {

        CallContext callCtx = (CallContext) ctx;
		CstmFunction function = GlobalScopeManager.getInstance().getFunction(callCtx.IDENTIFIER().getText());
		
		if(function == null) {
			Console.log(String.valueOf(this.lineNumber) , "Function not found.");
		}
		else {
		}
	}
}
