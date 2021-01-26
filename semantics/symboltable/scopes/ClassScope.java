package semantics.symboltable.scopes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;


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
	
	private HashMap<String, Value> publicVariables;
	private HashMap<String, Value> privateVariables;
	
	private HashMap<String, Function> publicFunctions;
	private HashMap<String, Function> privateFunctions;
	
	private LocalScope parentLocalScope; //represents the parent local scope which is the local scope covered by the main() function. Other classes may not contain this.
	
	public ClassScope(String className) {
		this.className = className;
		
		this.publicVariables = new HashMap<String, Value>();
		this.privateVariables = new HashMap<String, Value>();
		
		this.publicFunctions = new HashMap<String, Function>();
		this.privateFunctions = new HashMap<String, Function>();
	}
	
	public String getClassName() {
		return this.className;
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
	// public void addEmptyVariableFromKeywords(String classModifierString, String primitiveTypeString, String identifierString) {
	// 	boolean isPublic = true;
		
	// 	if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.CLASS_MODIFIER_PRIVATE, classModifierString)) {
	// 		isPublic = false;
	// 	}
		
	// 	//create empty mobi value
	// 	Value mobiValue = Value.createEmptyVariableFromKeywords(primitiveTypeString);
		
	// 	if(isPublic) {
	// 		this.publicVariables.put(identifierString, mobiValue);
	// 		Console.log(LogType.DEBUG, "Created public variable " +identifierString+ " type: " +mobiValue.getPrimitiveType());
	// 	}
	// 	else {
	// 		this.privateVariables.put(identifierString, mobiValue);
	// 		Console.log(LogType.DEBUG, "Created private variable " +identifierString+ " type: " +mobiValue.getPrimitiveType());
	// 	}
	// }
	
	/*
	 * Attempts to add an initialized variable mobi value
	 */
	// public void addInitializedVariableFromKeywords(String classModifierString, String primitiveTypeString, String identifierString, String valueString) {
	// 	boolean isPublic = true;
		
	// 	if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.CLASS_MODIFIER_PRIVATE, classModifierString)) {
	// 		isPublic = false;
	// 	}
		
	// 	this.addEmptyVariableFromKeywords(classModifierString, primitiveTypeString, identifierString);
		
	// 	if(isPublic) {
	// 		Value mobiValue = this.publicVariables.get(identifierString);
	// 		mobiValue.setValue(valueString);
	// 		Console.log(LogType.DEBUG, "Updated public variable " +identifierString+ " of type " +mobiValue.getPrimitiveType()+ " with value " +valueString);
	// 	}
	// 	else {
	// 		Value mobiValue = this.privateVariables.get(identifierString);
	// 		mobiValue.setValue(valueString);
	// 		Console.log(LogType.DEBUG, "Updated private variable " +identifierString+ " of type " +mobiValue.getPrimitiveType()+ " with value " +valueString);
	// 	}
	// }
	
	public Value getPublicVariable(String identifier) {
		if(this.containsPublicVariable(identifier)) {
			return this.publicVariables.get(identifier);
		}
		else {
			System.out.println("Public " +identifier + " is not found.");
			return null;
		}
	}
	
	public Value getPrivateVariable(String identifier) {
		if(this.containsPrivateVariable(identifier)) {
			return this.privateVariables.get(identifier);
		}
		else {
			System.out.println("Private " +identifier + " is not found.");
			return null;
		}
	}
	
	// public void addMobiValue(String accessControlModifier, String identifier, Value mobiValue) {
	// 	boolean isPublic = true;
		
	// 	if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.CLASS_MODIFIER_PRIVATE, accessControlModifier)) {
	// 		isPublic = false;
	// 	}
		
	// 	if(isPublic){
	// 		this.publicVariables.put(identifier, mobiValue);
	// 	}
	// 	else {
	// 		this.privateVariables.put(identifier, mobiValue);
	// 	}	
	// }
	
	public Function getPublicFunction(String identifier) {
		if(this.containsPublicFunction(identifier)) {
			return this.publicFunctions.get(identifier);
		}
		else {
			System.out.println("Private " +identifier+ " function is not found.");
			return null;
		}
	}
	
	public Function getPrivateFunction(String identifier) {
		if(this.containsPublicFunction(identifier)) {
			return this.privateFunctions.get(identifier);
		}
		else {
			System.out.println("Public " +identifier+ " function is not found");
			return null;
		}
	}
	
	public Function searchFunction(String identifier) {
		if(this.containsPublicFunction(identifier)) {
			return this.publicFunctions.get(identifier);
		}
		else if(this.containsPrivateFunction(identifier)) {
			return this.privateFunctions.get(identifier);
		}
		else {
			System.out.println(identifier + " is not found in " +this.className);
			return null;
		}
	}
	
	public boolean containsPublicFunction(String identifier) {
		return this.publicFunctions.containsKey(identifier);
	}
	
	public boolean containsPrivateFunction(String identifier) {
		return this.privateFunctions.containsKey(identifier);
	}
	
	@Override
	/* Attempts to find a variable first in the private and public variable storage, then on the local scopes.
	 * (non-Javadoc)
	 * @see com.neildg.mobiprog.semantics.symboltable.scopes.IScope#getVariable(java.lang.String)
	 */
	public Value searchVariableIncludingLocal(String identifier) {
		Value value;
		if(this.containsPrivateVariable(identifier)) {
			value = this.getPrivateVariable(identifier);
		}
		else if(this.containsPublicVariable(identifier)) {
			value = this.getPublicVariable(identifier);
		}
		else {
			value = LocalScopeCreator.searchVariableInLocalIterative(identifier, this.parentLocalScope);
		}
		
		return value;
	}
	
	public Value searchVariable(String identifier) {
		Value value = null;
		if(this.containsPrivateVariable(identifier)) {
			value = this.getPrivateVariable(identifier);
		}
		else if(this.containsPublicVariable(identifier)) {
			value = this.getPublicVariable(identifier);
		}
		
		return value;
	}
	
	public boolean containsPublicVariable(String identifier) {
		return this.publicVariables.containsKey(identifier);
	}
	
	public boolean containsPrivateVariable(String identifier) {
		return this.privateVariables.containsKey(identifier);
	}
	
	/*
	 * Resets all stored variables. This is called after the execution manager finishes
	 */
	public void resetValues() {
		Value[] publicMobiValues = this.publicVariables.values().toArray(new Value[this.publicVariables.size()]);
		Value[] privateMobiValues = this.privateVariables.values().toArray(new Value[this.privateVariables.size()]);
		
		for(int i = 0; i < publicMobiValues.length; i++) {
			publicMobiValues[i].reset();
		}
		
		for(int i = 0; i < privateMobiValues.length; i++) {
			privateMobiValues[i].reset();
		}
	}
}
