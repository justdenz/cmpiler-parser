package semantics.symboltable;

import java.util.HashMap;

import semantics.representations.CstmValue;
import semantics.representations.CstmFunction;
import semantics.symboltable.scopes.CstmLocalScope;

public class GlobalScopeManager {
	
	private static GlobalScopeManager sharedInstance = null;
	
	public static GlobalScopeManager getInstance() {
		return sharedInstance;
	}
	
	private CstmLocalScope currentScope;
	private HashMap<String, CstmFunction> functionMap;
	
	private GlobalScopeManager() {
		this.currentScope = null;
		this.functionMap = new HashMap<String, CstmFunction>();
	}
	
	public static void initialize() {
		sharedInstance = new GlobalScopeManager();
	}
	
	public static void reset() {
		sharedInstance.currentScope = null;
		sharedInstance.functionMap = new HashMap<String, CstmFunction>();
	}

	public CstmFunction getFunction(String identifier){
		return this.functionMap.get(identifier);
	}

	public HashMap<String, CstmFunction> getFunctions() {
		return this.functionMap;
	}

	public void addFunction(String identifier, CstmFunction function){
		this.functionMap.put(identifier, function);
	}

	public CstmLocalScope getCurrentScope(){
		return this.currentScope;
	}

	public void setCurrentScope(CstmLocalScope newCurrentScope){
		this.currentScope = newCurrentScope;
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
}
