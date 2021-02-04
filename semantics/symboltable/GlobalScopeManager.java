package semantics.symboltable;

import java.util.HashMap;

import semantics.representations.CstmValue;
import semantics.representations.CstmFunction;
import semantics.symboltable.scopes.CstmLocalScope;

public class GlobalScopeManager {
	
	private static GlobalScopeManager sharedInstance = null;

	private CstmLocalScope currentScope;
	private HashMap<String, CstmFunction> functionMap;

	public static GlobalScopeManager getInstance() {
		if(sharedInstance == null){
			sharedInstance = new GlobalScopeManager();
		}
		return sharedInstance;
	}
	
	private GlobalScopeManager() {
		this.currentScope = null;
		this.functionMap = new HashMap<String, CstmFunction>();
	}
	
	public void setCurrentScope(CstmLocalScope newCurrentScope){
		this.currentScope = newCurrentScope;
	}

	public CstmLocalScope getCurrentScope(){
		return this.currentScope;
	}

	public void goToParentScope(){
		if(currentScope != null)
			currentScope = currentScope.getParent();
	}
	
	public void addFunction(String identifier, CstmFunction function){
		this.functionMap.put(identifier, function);
	}

	public CstmFunction getFunction(String identifier){
		if(this.functionMap.containsKey(identifier)){
			return this.functionMap.get(identifier);
		} else {
			return null;
		}
	}

	public HashMap<String, CstmFunction> getFunctions() {
		return this.functionMap;
	}

	public CstmValue searchScopedVariable(String identifier){
		CstmLocalScope localScope = this.currentScope;
		CstmValue cstmValue = null;

		while (localScope != null) {
			cstmValue = localScope.getVariable(identifier);

            if (cstmValue != null) {
                return cstmValue;
            } 

            localScope = localScope.getParent();
        }

        return cstmValue;
	}

	public void reset(){
		this.currentScope = null;
		this.functionMap = new HashMap<String, CstmFunction>();
	}
}
