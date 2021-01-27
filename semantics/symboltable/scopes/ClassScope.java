package semantics.symboltable.scopes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import console.Console;
import semantics.representations.Function;
import semantics.representations.Value;
import semantics.representations.Value.PrimitiveType;
import semantics.utils.RecognizedKeywords;

/**
 * Represents a class scope with mappings of variables and functions
 *
 */
public class ClassScope implements ScopeInterface{
    private String className;
	
	private HashMap<String, Value> variables;
	private HashMap<String, Function> functions;
	
	private LocalScope parentLocalScope; //represents the parent local scope which is the local scope covered by the main() function. Other classes may not contain this.
	
	public ClassScope() {
		
		this.variables = new HashMap<String, Value>();
		this.functions = new HashMap<String, Function>();
	}
	

	/*
	 * Sets the parent local scope which is instantiated if this class contains a main function.
	 */
	public void setParentLocalScope(LocalScope localScope) {
		this.parentLocalScope = localScope;
	}
	
	@Override
	/* 
	 * A class scope is automatically the parent of local scopes.
	 * (non-Javadoc)
	 * @see com.neildg.mobiprog.semantics.symboltable.scopes.IScope#isParent()
	 */
	public boolean isParent(){
		return true;
	}
	
	/*
	 * Attempts to add an empty variable based from keywords
	 */
	public void addEmptyVariableFromKeywords(String primitiveTypeString, String identifierString) {
		//create empty value
		Value value = Value.createEmptyVariableFromKeywords(primitiveTypeString);
		
		this.variables.put(identifierString, value);
		Console.log("Created variable " +identifierString+ " type: " +value.getPrimitiveType());
	}
	
	/*
	 * Attempts to add an initialized variable value
	 */
	public void addInitializedVariableFromKeywords(String classModifierString, String primitiveTypeString, String identifierString, String valueString) {
		
		this.addEmptyVariableFromKeywords(primitiveTypeString, identifierString);

		Value value = this.variables.get(identifierString);
		value.setValue(valueString);
		Console.log("Updated variable " +identifierString+ " of type " +value.getPrimitiveType()+ " with value " +valueString);

	}
	
	public Value getVariable(String identifier) {
		return this.variables.get(identifier);
	}
	
	public void addValue(String identifier, Value value) {
		this.variables.put(identifier, value);
	}
	
	public Function getFunction(String identifier) {
		return this.functions.get(identifier);
	}

	public void addFunction(String identifer, Function function){
		this.functions.put(identifer, function);
	}
	
	public Function searchFunction(String identifier) {
		if(this.containsFunction(identifier)) {
			return this.functions.get(identifier);
		}
		else {
			Console.log(identifier + " is not found");
			return null;
		}
	}

	public boolean containsFunction(String identifier) {
		return this.functions.containsKey(identifier);
	}
	

	@Override
	/* Attempts to find a variable on the local scopes.
	 * (non-Javadoc)
	 * @see com.neildg.mobiprog.semantics.symboltable.scopes.IScope#getVariable(java.lang.String)
	 */
	public Value searchVariableIncludingLocal(String identifier) {
		Value value;
		value = LocalScopeCreator.searchVariableInLocalIterative(identifier, this.parentLocalScope);
		return value;
	}
	
	/*
	 * Resets all stored variables. This is called after the execution manager finishes
	 */
	public void resetValues() {
		Value[] values = this.variables.values().toArray(new Value[this.variables.size()]);
		
		for(int i = 0; i < values.length; i++) {
			values[i].reset();
		}
	}
}
