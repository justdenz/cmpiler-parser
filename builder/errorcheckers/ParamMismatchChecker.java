package builder.errorcheckers;

import java.util.List;

import builder.BuildChecker;
import builder.ErrorRepository;
// import generatedexp.JavaParser.ArgumentsContext;
// import generatedexp.JavaParser.ExpressionContext;
// import ide.console.Console;
import semantics.representations.Function;

public class ParamMismatchChecker implements ErrorCheckerInterface{
  private Function function;
	private List<ExpressionContext> exprCtxList;
	private int lineNumber;
	
	public ParamMismatchChecker(Function func, ArgumentsContext argumentsCtx) {
		this.function = func;

		if(argumentsCtx.expressionList() != null) {
			this.exprCtxList = argumentsCtx.expressionList().expression();
		}
		
		this.lineNumber = argumentsCtx.getStart().getLine();
	}
	
	@Override
	public void verify() {
		if(this.function == null) {
			return;
		}
		
		if(this.exprCtxList == null && this.function.getParameterValueSize() != 0) {
			BuildChecker.reportCustomError(ErrorRepository.PARAMETER_COUNT_MISMATCH, "", this.function.getFunctionName(), this.lineNumber);
		}
		else if(this.exprCtxList != null && this.exprCtxList.size() != this.function.getParameterValueSize()) {
			BuildChecker.reportCustomError(ErrorRepository.PARAMETER_COUNT_MISMATCH, "", this.function.getFunctionName(), this.lineNumber);
		}
	}
}
