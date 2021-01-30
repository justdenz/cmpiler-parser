package builder.errorcheckers;

import org.antlr.v4.runtime.Token;

import model.CUSTOMParser.FuncBlockContext;
import semantics.representations.CstmFunction;
import semantics.symboltable.GlobalScopeManager;

public class CstmMulFuncDecChecker implements CstmErrCheckerInterface {
    private FuncBlockContext funcBlockContext;
	private int lineNumber;
	
	public CstmMulFuncDecChecker(FuncBlockContext funcBlockContext) {
		this.funcBlockContext = funcBlockContext;
		
		Token firstToken = funcBlockContext.getStart();
		this.lineNumber = firstToken.getLine();
	}
	
	@Override
	public void verify() {
		this.verifyFunctionCall(this.funcBlockContext.IDENTIFIER().getText());
	}
	
	private void verifyFunctionCall(String identifierString) {
		CstmFunction cstmFunction = GlobalScopeManager.getInstance().getFunction(identifierString);
		if(cstmFunction != null) {
			//CstmBuildChecker.reportCustomError(CstmErrorRepo.MULTIPLE_FUNCTION, "", identifierString, this.lineNumber);
		}
	}
}
