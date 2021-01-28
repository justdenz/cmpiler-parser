package semantics.symboltable.scopes;

import java.util.HashMap;

import console.Console;
import semantics.representations.CstmValue;

/**
 * Represents a local scope, which is either a function, a code block or inside a certain loop/conditional statement.
 * This local scope starts as an empty representation of a class.
 * 
 * LocalScope can be viewed as a tree structure wherein it has a parent and children.
 */
public class CstmLocalScope {

    private CstmLocalScope parentScope;
	
	private HashMap<String, CstmValue> localVariables = null;
	
	public CstmLocalScope() {
		this.parentScope = null;
	}
	
	public CstmLocalScope(CstmLocalScope parentScope) {
		this.parentScope = parentScope;
	}
	
	/*
	 * Initialize the moment a variable is about to be placed.
	 */
	public void initializeLocalVariableMap() {
		if(this.localVariables == null) {
			this.localVariables = new HashMap<String, CstmValue>();
		}
	}
	
	public void setParent(CstmLocalScope parentScope) {
		this.parentScope = parentScope;
	}
	
	public boolean isParent() {
		return (this.parentScope == null);
	}
	
	public CstmLocalScope getParent() {
		return this.parentScope;
	}
	
	public CstmValue getVariable(String identifier) {
		return this.localVariables.get(identifier);
	}
	
	public void addVariable(String identifier, CstmValue cstmValue) {
		this.localVariables.put(identifier, cstmValue);
	}
}
