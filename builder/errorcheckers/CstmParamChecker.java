package builder.errorcheckers;

import java.util.List;

import builder.CstmBuildChecker;
import builder.CstmErrorRepo;
import model.CUSTOMParser.ArgsContext;
import model.CUSTOMParser.ExpressionContext;
import console.Console;
import semantics.representations.CstmFunction;

public class CstmParamChecker implements CstmErrCheckerInterface{
	private CstmFunction function;
	private List<ExpressionContext> expressionCtxList;
	private int lineNumber;
	
	public CstmParamChecker(CstmFunction func, ArgsContext expressionCtxList) {
		this.function = func;

		if(expressionCtxList != null) {
			this.expressionCtxList = expressionCtxList.argList().expression();
		}
		
		this.lineNumber = expressionCtxList.getStart().getLine();
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
