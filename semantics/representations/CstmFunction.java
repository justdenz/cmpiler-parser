package semantics.representations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import builder.errorcheckers.CstmTypeChecker;
import console.Console;
import execution.commands.CommandInterface;
import model.CUSTOMParser.ExpressionContext;
import semantics.representations.CstmValue.PrimitiveType;
import semantics.representations.CstmArray;
import semantics.symboltable.scopes.CstmLocalScope;
import semantics.utils.CstmKeywords;

/**
 * Represents the intermediate representation of a function
 */

public class CstmFunction {

    public enum FunctionType {
		INT_TYPE,
		BOOLEAN_TYPE,
		FLOAT_TYPE,
		STRING_TYPE,
		VOID_TYPE,
    }
    
    private String functionName;
	private List<CommandInterface> commandList; //the list of commands execution by the function
	private boolean calledReturned; // refers to the function returning a value back to main
    private CstmLocalScope functionScope; //refers to the scope of the function
	private LinkedHashMap<String, CstmValue> parameterValues;	//the list of parameters of the function
	private CstmValue returnValue; //the return value of the function. null if it's a void type
	private FunctionType returnType; //the return type of the function
    
    public CstmFunction() {
		this.commandList = new ArrayList<CommandInterface>();
		this.parameterValues = new LinkedHashMap<String,CstmValue>();
		this.functionScope = new CstmLocalScope();
		this.returnType = FunctionType.VOID_TYPE;
		this.calledReturned = false;
    }
    
    public void setFunctionLocalScope(CstmLocalScope localScope) {
		this.functionScope = localScope;
	}
	
	public CstmLocalScope getFunctionLocalScope() {
		return this.functionScope;
    }
    
    public void setReturnType(FunctionType functionType) {
		this.returnType = functionType;
		
		switch(this.returnType) {
			case BOOLEAN_TYPE: this.returnValue = new CstmValue(true, CstmKeywords.IS_BOOLEAN); break;
			case INT_TYPE: this.returnValue = new CstmValue(0, CstmKeywords.IS_INT); break;
			case FLOAT_TYPE: this.returnValue = new CstmValue(0, CstmKeywords.IS_FLOAT); break;
			case STRING_TYPE: this.returnValue = new CstmValue("", CstmKeywords.IS_STRING); break;
			default:break;	
		}
	}
	
	public void setReturnType(FunctionType functionType, boolean isArray) {
		this.returnType = functionType;

		if(isArray){
			CstmArray cstmArray = null;
			switch(this.returnType) {
				case BOOLEAN_TYPE: cstmArray = CstmArray.createArray(CstmKeywords.IS_BOOLEAN, null); break;
				case INT_TYPE: cstmArray = CstmArray.createArray(CstmKeywords.IS_INT, null); break;
				case FLOAT_TYPE: cstmArray = CstmArray.createArray(CstmKeywords.IS_FLOAT, null); break;
				case STRING_TYPE: cstmArray = CstmArray.createArray(CstmKeywords.IS_STRING, null); break;
				default:break;	
			}
			this.returnValue = new CstmValue(cstmArray, CstmKeywords.IS_ARRAY);
		}
    }
    
    public FunctionType getReturnType() {
		return this.returnType;
	}
	
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	
	public String getFunctionName() {
		return this.functionName;
    }
    
    public int getParameterCount() {
		return this.parameterValues.size();
	}
	
	public void addParameter(String identifierString, CstmValue cstmValue) {
		this.parameterValues.put(identifierString, cstmValue);
	}
	
    public CstmValue getParameter(String identifierString) {
		return this.parameterValues.get(identifierString);
	}

	public LinkedHashMap<String, CstmValue> getParameters(){
		return this.parameterValues;
	}
    
	public CstmValue getReturnValue() {
		if(this.returnType == FunctionType.VOID_TYPE) {
			return null;
		}
		else {
			return this.returnValue;
		}
	}

	public boolean getReturnStatus(){
		return this.calledReturned;
	}
	
	public void addCommand(CommandInterface command) {
		this.commandList.add(command);
		System.out.println("Added new command to " + this.functionName);
	}

	public List<CommandInterface> getCommands(){
		return this.commandList;
	}

}
