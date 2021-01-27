package semantics.symboltable.scopes;

import java.util.ArrayList;
import java.util.HashMap;

import console.Console;
import semantics.representations.Value;
import semantics.utils.RecognizedKeywords;

/**
 * Represents a local scope, which is either a function, a code block or inside a certain loop/conditional statement.
 * This local scope starts as an empty representation of a class.
 * 
 * LocalScope can be viewed as a tree structure wherein it has a parent and children.
 */
public class LocalScope implements ScopeInterface{

    private ScopeInterface parentScope;
	private ArrayList<LocalScope> childScopeList = null;
	
	private HashMap<String, Value> localVariables = null;
	
	public LocalScope() {
		this.parentScope = null;
	}
	
	public LocalScope(ScopeInterface parentScope) {
		this.parentScope = parentScope;
	}
	
	/*
	 * Initialize the moment a variable is about to be placed.
	 */
	public void initializeLocalVariableMap() {
		if(this.localVariables == null) {
			this.localVariables = new HashMap<String, Value>();
		}
	}
	
	/*
	 * Initialize the child list the moment a child scope is about to be placed
	 */
	public void initializeChildList() {
		if(this.childScopeList == null) {
			this.childScopeList = new ArrayList<LocalScope>();
		}
	}
	
	public void setParent(ScopeInterface parentScope) {
		this.parentScope = parentScope;
	}
	
	public void addChild(LocalScope localScope) {
		this.initializeChildList();
		
		this.childScopeList.add(localScope);
	}
	
	public boolean isParent() {
		return (this.parentScope == null);
	}
	
	public ScopeInterface getParent() {
		return this.parentScope;
	}
	
	public int getChildCount() {
		if(this.childScopeList != null)
			return this.childScopeList.size();
		else
			return 0;
	}
	
	public LocalScope getChildAt(int index) {
		if(this.childScopeList != null)
			return this.childScopeList.get(index);
		else
			return null;
	}
	
	@Override
	public Value searchVariableIncludingLocal(String identifier) {
		if(this.containsVariable(identifier)) {
			return this.localVariables.get(identifier);
		}
		else {
			Console.log(identifier + " not found!");
			return null;
		}
	}
	
	public boolean containsVariable(String identifier) {
		if(this.localVariables!= null && this.localVariables.containsKey(identifier)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/*
	 * Adds an empty variable based from keywords
	 */
	public void addEmptyVariableFromKeywords(String primitiveTypeString, String identifierString) {
		this.initializeLocalVariableMap();
		
		Value value = Value.createEmptyVariableFromKeywords(primitiveTypeString);
		this.localVariables.put(identifierString, value);
	}
	
	/*
	 * Adds an initialized variable based from keywords
	 */
	public void addInitializedVariableFromKeywords(String primitiveTypeString, String identifierString, String valueString) {
		this.initializeLocalVariableMap();
		
		this.addEmptyVariableFromKeywords(primitiveTypeString, identifierString);
		Value value = this.localVariables.get(identifierString);
		value.setValue(valueString);
	}
	
	public void addValue(String identifier, Value value) {
		this.initializeLocalVariableMap();
		this.localVariables.put(identifier, value);
	}
	
	/*
	 * Returns the depth of this local scope.
	 */
	public int getDepth() {
		int depthCount = -1;
		
		LocalScope scope = (LocalScope) this;
		
		while(scope != null) {
			depthCount++;
			
			ScopeInterface abstractScope = scope.getParent();
			
			if(abstractScope instanceof ClassScope)
				break;
			
			scope = (LocalScope) abstractScope;
		}
		
		
		return depthCount;
	}
}
