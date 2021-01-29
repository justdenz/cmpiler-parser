package builder.errorcheckers;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import builder.CstmBuildChecker;
import builder.CstmErrorRepo;
import model.CUSTOMParser.MutableContext;
import model.CUSTOMParser.MutableContext;
import semantics.representations.CstmValue;
import semantics.representations.CstmFunction;
import semantics.representations.CstmValueSearcher;
import semantics.representations.CstmValue.PrimitiveType;
import builder.CstmBuildChecker;
import builder.CstmErrorRepo;
import semantics.symboltable.GlobalScopeManager;

public class CstmConstChecker implements CstmErrCheckerInterface, ParseTreeListener{
	
	private MutableContext mutableCtx;
	private int lineNumber;
	
	public CstmConstChecker(MutableContext mutableCtx) {
		this.mutableCtx = mutableCtx;
		Token firstToken = this.mutableCtx.getStart();
		this.lineNumber = firstToken.getLine();
	}
	
	@Override
	public void verify() {
		ParseTreeWalker treeWalker = new ParseTreeWalker();
		treeWalker.walk(this, this.mutableCtx);
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
		if(ctx instanceof MutableContext) {
			MutableContext mutableCtx = (MutableContext) ctx;
			this.verifyVariableOrConst(mutableCtx);
		}
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		
	}
	
	private void verifyVariableOrConst(MutableContext mutableCtx) {
		
	}
}
