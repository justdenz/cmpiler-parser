package semantics.symboltable.scopes;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// import execution.ExecutionManager;
import console.Console;
import semantics.representations.CstmValue;

public class CstmLocalScopeCreator {
	
	private static CstmLocalScopeCreator sharedInstance = null;
	
	public static CstmLocalScopeCreator getInstance() {
		return sharedInstance;
	}
	
	private CstmLocalScope activeLocalScope = null;
	
	private CstmLocalScopeCreator() {
		
	}
	
	public static void initialize() {
		sharedInstance = new CstmLocalScopeCreator();
	}
	
	public static void reset() {
		sharedInstance.activeLocalScope = null;
	}
	
	/*
	 * Opens a new local scope instance. If the active local scope instance is null,
	 * it creates a new one and sets it as a parent. Otherwise, the active local scope is set as
	 * a parent of the new instance, then the new instance becomes the active local scope.
	 */
	public CstmLocalScope openLocalScope() {
		if(this.activeLocalScope == null) {
			this.activeLocalScope = new CstmLocalScope();
		}
		else {
			CstmLocalScope childLocalScope = new CstmLocalScope(); 
			childLocalScope.setParent(this.activeLocalScope);//point this current local scope as parent
			this.activeLocalScope.addChild(childLocalScope); //add the new scope as child for this current local scope
			this.activeLocalScope = childLocalScope; //change pointer to the child scope
		}
		
		return this.activeLocalScope;
	}
	
	public CstmLocalScope getActiveLocalScope() {
		return this.activeLocalScope;
	}
	
	/*
	 * Closes the active local scope which changes the pointer to the parent of the active local scope.
	 */
	public void closeLocalScope() {
		if(this.activeLocalScope.getParent() != null && this.activeLocalScope.getParent() instanceof CstmLocalScope) {
			this.activeLocalScope = (CstmLocalScope) this.activeLocalScope.getParent();
		}
		else if(this.activeLocalScope.getParent() == null) {
			Console.log("Cannot change parent. Current active local scope no longer has a parent.");
		}
		else {
			Console.log("Cannot change parent. Current active local scope's parent is now a class scope.");
		}
	}
	
	/*
	 * Searches for a local variable using an iterative depth-first search.
	 */
	public static CstmValue searchVariableInLocalIterative(String identifier, CstmLocalScope localScope) {
		
		if(localScope == null) {
			Console.log(identifier + " not found in any local scope!");
			return null;
		}
		
		Stack<CstmLocalScope> stack = new Stack<CstmLocalScope>();
		
		stack.push(localScope);
		
		List<CstmLocalScope> discoveredScopes = new ArrayList<CstmLocalScope>();
		CstmLocalScope scope;
		
		while(!stack.isEmpty()) {
			scope = stack.pop();
			
			if(scope.containsVariable(identifier)) {
				return scope.searchVariableIncludingLocal(identifier);
			}
			
			if(!discoveredScopes.contains(scope)) {
				discoveredScopes.add(scope);
				
				for(int i = 0; i < scope.getChildCount(); i++) {
					CstmLocalScope childScope = scope.getChildAt(i);
					stack.push(childScope);
				}
			}
		}
		
		Console.log(identifier + " not found in any local scope!");
		return null;
	}
}
