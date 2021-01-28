package semantics.symboltable.scopes;

import java.util.ArrayList;
import java.util.HashMap;

import console.Console;
import semantics.representations.CstmFunction;
import semantics.representations.CstmValue;
import semantics.utils.CstmRecognizedKeywords;

/**
 * Represents a local scope, which is either a function, a code block or inside a certain loop/conditional statement.
 * This local scope starts as an empty representation of a class.
 * 
 * LocalScope can be viewed as a tree structure wherein it has a parent and children.
 */
public class CstmLocalScope implements CstmScopeInterface{

    private CstmScopeInterface parentScope;
	private ArrayList<CstmLocalScope> childScopeList = null;
	
	private HashMap<String, CstmValue> localVariables = null;
	
	public CstmLocalScope() {
		this.parentScope = null;
	}
	
	public CstmLocalScope(CstmScopeInterface parentScope) {
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
	
	/*
	 * Initialize the child list the moment a child scope is about to be placed
	 */
	public void initializeChildList() {
		if(this.childScopeList == null) {
			this.childScopeList = new ArrayList<CstmLocalScope>();
		}
	}
	
	public void setParent(CstmScopeInterface parentScope) {
		this.parentScope = parentScope;
	}
	
	public void addChild(CstmLocalScope localScope) {
		this.initializeChildList();
		
		this.childScopeList.add(localScope);
	}
	
	public boolean isParent() {
		return (this.parentScope == null);
	}
	
	public CstmScopeInterface getParent() {
		return this.parentScope;
	}
	
	public int getChildCount() {
		if(this.childScopeList != null)
			return this.childScopeList.size();
		else
			return 0;
	}
	
	public CstmLocalScope getChildAt(int index) {
		if(this.childScopeList != null)
			return this.childScopeList.get(index);
		else
			return null;
	}
	
	@Override
	public CstmValue searchVariableIncludingLocal(String identifier) {
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
		
		CstmValue cstmValue = CstmValue.createEmptyVariableFromKeywords(primitiveTypeString);
		this.localVariables.put(identifierString, cstmValue);
	}
	
	/*
	 * Adds an initialized variable based from keywords
	 */
	public void addInitializedVariableFromKeywords(String primitiveTypeString, String identifierString, String valueString) {
		this.initializeLocalVariableMap();
		
		this.addEmptyVariableFromKeywords(primitiveTypeString, identifierString);
		CstmValue cstmValue = this.localVariables.get(identifierString);
		cstmValue.setValue(valueString);
	}
	
	public void addValue(String identifier, CstmValue cstmValue) {
		this.initializeLocalVariableMap();
		this.localVariables.put(identifier, cstmValue);
	}
	
	/*
	 * Returns the depth of this local scope.
	 */
	public int getDepth() {
		int depthCount = -1;
		
		CstmLocalScope scope = (CstmLocalScope) this;
		
		while(scope != null) {
			depthCount++;
			
			CstmScopeInterface abstractScope = scope.getParent();
			
			// if(abstractScope instanceof CstmClassScope)
			// 	break;
			
			scope = (CstmLocalScope) abstractScope;
		}
		
		
		return depthCount;
	}
}
