package builder.errorcheckers;

import org.antlr.v4.runtime.Token;

import builder.BuildChecker;
import builder.ErrorRepository;
import model.CUSTOMParser.MainBlockContext;
import semantics.representations.Function;
import semantics.symboltable.SymbolTable;
import semantics.symboltable.scopes.ClassScope;

public class MultipleFunctionDeclarationChecker implements ErrorCheckerInterface {
    private MainBlockContext mainBlockContext;
	private int lineNumber;
	
	public MultipleFunctionDeclarationChecker(MainBlockContext mainBlockContext) {
		this.mainBlockContext = mainBlockContext;
		
		Token firstToken = mainBlockContext.getStart();
		this.lineNumber = firstToken.getLine();
	}
	
	/* (non-Javadoc)
	 * @see com.neildg.mobiprog.builder.errorcheckers.IErrorChecker#verify()
	 */
	@Override
	public void verify() {
		this.verifyFunctionCall(this.mainBlockContext.Identifier().getText());
	}
	
	private void verifyFunctionCall(String identifierString) {

		ClassScope classScope = SymbolTable.getInstance().getClassScope();
		Function function = classScope.searchFunction(identifierString);
		
		if(function != null) {
			BuildChecker.reportCustomError(ErrorRepository.MULTIPLE_FUNCTION, "", identifierString, this.lineNumber);
		}
	}
}
