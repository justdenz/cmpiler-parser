package builder.errorcheckers;

import java.util.List;

import builder.CstmBuildChecker;
import builder.CstmErrorRepo;
import model.CUSTOMParser.ArgsContext;
import model.CUSTOMParser.ExpressionContext;
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
			this.expressionCtxList = expressionCtxList;
		}
		
		//this.lineNumber = expressionCtxList.getStart().getLine();
	}
	
	@Override
	public void verify() {
		if(this.function == null) {
			return;
		}
		
		if(this.expressionCtxList == null && this.function.getParameterCount() != 0) {
			CstmBuildChecker.reportCustomError(CstmErrorRepo.PARAMETER_COUNT_MISMATCH, "", this.function.getFunctionName(), this.lineNumber);
		}
		else if(this.expressionCtxList != null && this.expressionCtxList.size() != this.function.getParameterCount()) {
			CstmBuildChecker.reportCustomError(CstmErrorRepo.PARAMETER_COUNT_MISMATCH, "", this.function.getFunctionName(), this.lineNumber);
		}
	}
}
