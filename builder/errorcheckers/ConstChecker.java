package builder.errorcheckers;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import builder.BuildChecker;
import builder.ErrorRepository;
import model.CUSTOMParser.ExpressionContext;
import semantics.representations.Value;
import semantics.representations.Function;
import semantics.representations.ValueSearcher;
import semantics.representations.Value.PrimitiveType;
import semantics.symboltable.scopes.ClassScope;
import builder.BuildChecker;
import builder.ErrorRepository;
import semantics.symboltable.SymbolTable;

public class ConstChecker implements ErrorCheckerInterface, ParseTreeListener{
	
	private ExpressionContext exprCtx;
	private int lineNumber;
	
	public ConstChecker(ExpressionContext exprCtx) {
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
			if(EvaluationCommand.isVariableOrConst(exprCtx)) {
				this.verifyVariableOrConst(exprCtx);
			}
		}
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		
	}
	
	private void verifyVariableOrConst(ExpressionContext varExprCtx) {
		Value value = null;
		
		if(ExecutionManager.getInstance().isInFunctionExecution()) {
			Function function = ExecutionManager.getInstance().getCurrentFunction();
			value = VariableSearcher.searchVariableInFunction(function, varExprCtx.mutable().IDENTIFIER().getText());
		}
		
		//if after function finding, mobi value is still null, search class
		if(value == null) {
			ClassScope classScope = SymbolTable.getInstance().getClassScope(ParserHandler.getInstance().getCurrentClassName());
			value = VariableSearcher.searchVariableInClassIncludingLocal(classScope, varExprCtx.primary().Identifier().getText());
		}
		
		if(value != null && value.isFinal()) {
			BuildChecker.reportCustomError(ErrorRepository.CONST_REASSIGNMENT, "", varExprCtx.getText(), this.lineNumber);
		}
	}
}
