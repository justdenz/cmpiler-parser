package semantics.symboltable;

import java.util.ArrayList;
import java.util.HashMap;

import semantics.representations.CstmFunction;
import semantics.symboltable.scopes.CstmLocalScope;

public class GlobalScopeManager {
	
	private static GlobalScopeManager sharedInstance = null;
	
	public static GlobalScopeManager getInstance() {
		return sharedInstance;
	}
	
	private HashMap<String, CstmLocalScope> localScopes;
	private CstmLocalScope currentScope;
	private HashMap<String, CstmFunction> functions;
	
	private GlobalScopeManager() {
		this.localScopes = new HashMap<String, CstmLocalScope>();
	}
	
	public static void initialize() {
		sharedInstance = new GlobalScopeManager();
	}
	
	public static void reset() {
		sharedInstance.localScopes = new HashMap<String, CstmLocalScope>();
	}
	

	public HashMap<String, CstmLocalScope> getLocalScopes() {
		return this.localScopes;
	}

	public void addLocalScope(String identifier, CstmLocalScope newLocalScope){
		this.localScopes.put(identifier, newLocalScope);
	}

	public void addFunction(String identifier, CstmFunction function){
		this.functions.put(identifier, function);
	}

	public CstmFunction getFunction(String identifier){
		return this.functions.get(identifier);
	}

	public CstmLocalScope getCurrentScope(){
		return this.currentScope;
	}

	public void setCurrentScope(CstmLocalScope newCurrentScope){
		this.currentScope = newCurrentScope;
	}
}
