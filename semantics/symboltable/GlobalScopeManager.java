package semantics.symboltable;

import java.util.HashMap;

import semantics.representations.CstmValue;
import semantics.representations.CstmFunction;
import semantics.symboltable.scopes.CstmLocalScope;

public class GlobalScopeManager {
	
	private static GlobalScopeManager sharedInstance = null;

	private CstmLocalScope currentScope;
	private HashMap<String, CstmFunction> functionMap;
	private boolean isInFunction;
	private String currentFunctionName;

	public static GlobalScopeManager getInstance() {
		if(sharedInstance == null){
			System.out.println("Global Scope Manger initialzed 1st time!");
			sharedInstance = new GlobalScopeManager();
		}
		return sharedInstance;
	}
	
	private GlobalScopeManager() {
		this.currentScope = null;
		this.functionMap = new HashMap<String, CstmFunction>();
		this.isInFunction = false;
		this.currentFunctionName = null;
	}
	
	public void setCurrentScope(CstmLocalScope newCurrentScope){
		this.currentScope = newCurrentScope;
	}

	public void setCurrentFuncitonName(String name){
		this.currentFunctionName = name;
	}

	public void setIsInFunction(boolean value){
		this.isInFunction = value;	
	}

	public boolean getIsInFunction(){
		return this.isInFunction;
	}

	public String getCurrentFunctionName(){
		return this.currentFunctionName;
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
		return this.functionMap.get(identifier);
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
}
