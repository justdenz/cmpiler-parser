package semantics.symboltable.scopes;

import java.util.HashMap;

import console.Console;
import semantics.representations.CstmFunction;
import semantics.representations.CstmValue;
import semantics.representations.CstmValue.PrimitiveType;
import semantics.utils.CstmRecognizedKeywords;

/**
 * Represents a class scope with mappings of cstmVariables and cstmFunctions
 *
 */
public class CstmClassScope implements CstmScopeInterface{

	private HashMap<String, CstmValue> cstmVariables;
	private HashMap<String, CstmFunction> cstmFunctions;
	
	private CstmLocalScope parentLocalScope; //represents the parent local scope which is the local scope covered by the main() function. Other classes may not contain this.
	
	public CstmClassScope() {
		this.cstmVariables = new HashMap<String, CstmValue>();
		this.cstmFunctions = new HashMap<String, CstmFunction>();
	}
	
	/*
	 * Sets the parent local scope which is instantiated if this class contains a main function.
	 */
	public void setParentLocalScope(CstmLocalScope localScope) {
		this.parentLocalScope = localScope;
	}
	
	@Override
	/* 
	 * A class scope is automatically the parent of local scopes.
	 */
	public boolean isParent(){
		return true;
	}
	
	/*
	 * Attempts to add an empty variable based from keywords
	 */
	public void addEmptyVariableFromKeywords(String primitiveTypeString, String identifierString) {
		//create empty cstmValue
		CstmValue cstmValue = CstmValue.createEmptyVariableFromKeywords(primitiveTypeString);
		
		this.cstmVariables.put(identifierString, cstmValue);
		Console.log("Created variable " +identifierString+ " type: " +cstmValue.getPrimitiveType());
	}
	
	/*
	 * Attempts to add an initialized variable cstmValue
	 */
	public void addInitializedVariableFromKeywords(String classModifierString, String primitiveTypeString, String identifierString, String valueString) {
		
		this.addEmptyVariableFromKeywords(primitiveTypeString, identifierString);

		CstmValue cstmValue = this.cstmVariables.get(identifierString);
		cstmValue.setValue(valueString);
		Console.log("Updated variable " +identifierString+ " of type " +cstmValue.getPrimitiveType()+ " with cstmValue " +valueString);

	}
	
	public CstmValue getVariable(String identifier) {
		return this.cstmVariables.get(identifier);
	}
	
	public void addValue(String identifier, CstmValue cstmValue) {
		this.cstmVariables.put(identifier, cstmValue);
	}
	
	public CstmFunction getFunction(String identifier) {
		return this.cstmFunctions.get(identifier);
	}

	public void addFunction(String identifer, CstmFunction function){
		this.cstmFunctions.put(identifer, function);
	}
	
	public CstmFunction searchFunction(String identifier) {
		if(this.containsFunction(identifier)) {
			return this.cstmFunctions.get(identifier);
		}
		else {
			Console.log(identifier + " is not found");
			return null;
		}
	}

	public boolean containsFunction(String identifier) {
		return this.cstmFunctions.containsKey(identifier);
	}
	

	@Override
	/* 
	 * Attempts to find a variable on the local scopes.
	 */
	public CstmValue searchVariableIncludingLocal(String identifier) {
		CstmValue cstmValue;
		cstmValue = CstmLocalScopeCreator.searchVariableInLocalIterative(identifier, this.parentLocalScope);
		return cstmValue;
	}
	
	/*
	 * Resets all stored cstmVariables. This is called after the execution manager finishes
	 */
	public void resetValues() {
		CstmValue[] values = this.cstmVariables.values().toArray(new CstmValue[this.cstmVariables.size()]);
		
		for(int i = 0; i < values.length; i++) {
			values[i].reset();
		}
	}
}
