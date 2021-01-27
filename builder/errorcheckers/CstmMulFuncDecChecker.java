package builder.errorcheckers;

import org.antlr.v4.runtime.Token;

import builder.CstmBuildChecker;
import builder.CstmErrorRepo;
import model.CUSTOMParser.FuncBlockContext;
import semantics.representations.CstmFunction;
import semantics.symboltable.CstmSymbolTable;
import semantics.symboltable.scopes.CstmClassScope;

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

		CstmClassScope classScope = CstmSymbolTable.getInstance().getClassScope();
		CstmFunction function = classScope.searchFunction(identifierString);
		
		if(function != null) {
			CstmBuildChecker.reportCustomError(CstmErrorRepo.MULTIPLE_FUNCTION, "", identifierString, this.lineNumber);
		}
	}
}
