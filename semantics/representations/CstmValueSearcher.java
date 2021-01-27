package semantics.representations;

/**
 * A component that searches for the corresponding mobi value.
 * If it is in a function, it looks in the function parameters and local scope first before the global scope.
 */

public class CstmValueSearcher {
    public static CstmValue searchValue(String identifier) {
		
		CstmValue mobiValue = null;
		
		// if(FunctionTracker.getInstance().isInsideFunction()) {
		// 	Function function = FunctionTracker.getInstance().getLatestFunction();
			
		// 	if(function.hasParameter(identifier)) {
		// 		mobiValue =  function.getParameter(identifier);
		// 	}
		// 	else {
		// 		mobiValue = LocalScopeCreator.searchVariableInLocalIterative(identifier, function.getParentLocalScope());
		// 	}
		// }
		
		// if(mobiValue == null) {
		// 	ClassScope classScope = SymbolTableManager.getInstance().getClassScope(ParserHandler.getInstance().getCurrentClassName());
		// 	mobiValue = classScope.searchVariableIncludingLocal(identifier);
		// }
		
		return mobiValue;
		
	}
}
