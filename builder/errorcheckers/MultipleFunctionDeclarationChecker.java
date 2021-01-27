package builder.errorcheckers;

import org.antlr.v4.runtime.Token;

import builder.BuildChecker;
import builder.ErrorRepository;
import model.CUSTOMParser.FuncBlockContext;
import semantics.representations.Function;
import semantics.symboltable.SymbolTable;
import semantics.symboltable.scopes.ClassScope;

public class MultipleFunctionDeclarationChecker implements ErrorCheckerInterface {
    private FuncBlockContext funcBlockContext;
	private int lineNumber;
	
	public MultipleFunctionDeclarationChecker(FuncBlockContext funcBlockContext) {
		this.funcBlockContext = funcBlockContext;
		
		Token firstToken = funcBlockContext.getStart();
		this.lineNumber = firstToken.getLine();
	}
	
	@Override
	public void verify() {
		this.verifyFunctionCall(this.funcBlockContext.IDENTIFIER().getText());
	}
	
	private void verifyFunctionCall(String identifierString) {

		ClassScope classScope = SymbolTable.getInstance().getClassScope();
		Function function = classScope.searchFunction(identifierString);
		
		if(function != null) {
			BuildChecker.reportCustomError(ErrorRepository.MULTIPLE_FUNCTION, "", identifierString, this.lineNumber);
		}
	}
}
