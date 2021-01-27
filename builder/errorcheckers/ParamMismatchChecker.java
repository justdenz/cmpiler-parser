package builder.errorcheckers;

import java.util.List;

import builder.BuildChecker;
import builder.ErrorRepository;
import model.CUSTOMParser.ArgsContext;
import model.CUSTOMParser.ExpressionContext;
import console.Console;
import semantics.representations.Function;

public class ParamMismatchChecker implements ErrorCheckerInterface{
	private Function function;
	private List<ExpressionContext> expressionCtxList;
	private int lineNumber;
	
	public ParamMismatchChecker(Function func, ArgsContext expressionCtxList) {
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
		
		if(this.expressionCtxList == null && this.function.getParameterValueSize() != 0) {
			BuildChecker.reportCustomError(ErrorRepository.PARAMETER_COUNT_MISMATCH, "", this.function.getFunctionName(), this.lineNumber);
		}
		else if(this.expressionCtxList != null && this.expressionCtxList.size() != this.function.getParameterValueSize()) {
			BuildChecker.reportCustomError(ErrorRepository.PARAMETER_COUNT_MISMATCH, "", this.function.getFunctionName(), this.lineNumber);
		}
	}
}
