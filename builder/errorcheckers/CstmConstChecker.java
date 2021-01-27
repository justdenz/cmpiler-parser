package builder.errorcheckers;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import builder.CstmBuildChecker;
import builder.CstmErrorRepo;
import model.CUSTOMParser.ExpressionContext;
import semantics.representations.CstmValue;
import semantics.representations.CstmFunction;
import semantics.representations.CstmValueSearcher;
import semantics.representations.CstmValue.PrimitiveType;
import semantics.symboltable.scopes.CstmClassScope;
import builder.CstmBuildChecker;
import builder.CstmErrorRepo;
import semantics.symboltable.CstmSymbolTable;

public class CstmConstChecker implements CstmErrCheckerInterface, ParseTreeListener{
	
	private ExpressionContext exprCtx;
	private int lineNumber;
	
	public CstmConstChecker(ExpressionContext exprCtx) {
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
		if(ctx instanceof ExpressionContext) {
			ExpressionContext exprCtx = (ExpressionContext) ctx;
			this.verifyVariableOrConst(exprCtx);
			// if(EvaluationCommand.isVariableOrConst(exprCtx)) {
			// 	this.verifyVariableOrConst(exprCtx);
			// }
		}
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		
	}
	
	private void verifyVariableOrConst(ExpressionContext varExprCtx) {
		CstmValue value = null;
		
		// if(ExecutionManager.getInstance().isInFunctionExecution()) {
		// 	Function function = ExecutionManager.getInstance().getCurrentFunction();
		// 	value = VariableSearcher.searchVariableInFunction(function, varExprCtx.mutable().IDENTIFIER().getText());
		// }
		
		// //if after function finding, mobi value is still null, search class
		// if(value == null) {
		// 	ClassScope classScope = SymbolTable.getInstance().getClassScope();
		// 	value = VariableSearcher.searchVariableInClassIncludingLocal(classScope, varExprCtx.mutable().IDENTIFIER().getText());
		// }
		
		if(value != null && value.isFinal()) {
			CstmBuildChecker.reportCustomError(CstmErrorRepo.CONST_REASSIGNMENT, "", varExprCtx.getText(), this.lineNumber);
		}
	}
}
