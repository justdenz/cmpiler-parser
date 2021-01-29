package builder.errorcheckers;

import java.util.List;

import model.CUSTOMParser.ArgsContext;
import model.CUSTOMParser.SimpleExpressionContext;
import console.Console;
import semantics.representations.CstmFunction;

public class CstmParamChecker implements CstmErrCheckerInterface{
	private CstmFunction function;
	private List<SimpleExpressionContext> expressionCtxList;
	private int lineNumber;
	
	public CstmParamChecker(CstmFunction func, ArgsContext argsCtxList) {
		this.function = func;
		if(argsCtxList.simpleExpression() != null) {
			this.expressionCtxList = argsCtxList.simpleExpression();
		}
		this.lineNumber = argsCtxList.getStart().getLine();
	}
	
	@Override
	public void verify() {
		if(this.function == null) {
			return;
		}
		
		if(this.expressionCtxList == null && this.function.getParameterCount() != 0) {
			Console.log("In line " + this.lineNumber + " : Found paramater mismatch.");
		}
		else if(this.expressionCtxList != null && this.expressionCtxList.size() != this.function.getParameterCount()) {
			Console.log("In line " + this.lineNumber + " : Found paramater mismatch.");
		}
	}
}
