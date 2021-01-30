package semantics.representations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import builder.errorcheckers.CstmTypeChecker;
import console.Console;
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
	//private List<ICommand> commandSequences; //the list of commands execution by the function
	
    private CstmLocalScope functionScope; //refers to the scope of the function

	private LinkedHashMap<String, CstmValue> parameterValues;	//the list of parameters of the function
	private CstmValue returnValue; //the return value of the function. null if it's a void type
	private FunctionType returnType = FunctionType.VOID_TYPE; //the return type of the function
    
    public CstmFunction() {
		//this.commandSequences = new ArrayList<ICommand>();
		this.parameterValues = new LinkedHashMap<String,CstmValue>();
		this.functionScope = new CstmLocalScope();
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
	
	// @Override
	// public void addCommand(ICommand command) {
	// 	this.commandSequences.add(command);
	// 	Console.log("Command added to " +this.functionName);
	// }
	
	// @Override
	// public void execute() {
	// 	ExecutionMonitor executionMonitor = ExecutionManager.getInstance().getExecutionMonitor();
	// 	FunctionTracker.getInstance().reportEnterFunction(this);
	// 	try {
	// 		for(ICommand command : this.commandSequences) {
	// 			executionMonitor.tryExecution();
	// 			command.execute();
	// 		}

	// 	} catch(InterruptedException e) {
	// 		Log.e(TAG, "Monitor block interrupted! " +e.getMessage());
	// 	}
		
	// 	FunctionTracker.getInstance().reportExitFunction();
	// }

	// @Override
	// public ControlTypeEnum getControlType() {
	// 	return ControlTypeEnum.FUNCTION_TYPE;
	// }

	public static FunctionType identifyFunctionType(String primitiveTypeString) {
		
		if(CstmKeywords.matchesKeyword(CstmKeywords.IS_BOOLEAN, primitiveTypeString)) {
			return FunctionType.BOOLEAN_TYPE;
		}
		else if(CstmKeywords.matchesKeyword(CstmKeywords.IS_FLOAT, primitiveTypeString)) {
			return FunctionType.FLOAT_TYPE;
		}
		else if(CstmKeywords.matchesKeyword(CstmKeywords.IS_INT, primitiveTypeString)) {
			return FunctionType.INT_TYPE;
		}
		else if(CstmKeywords.matchesKeyword(CstmKeywords.IS_STRING, primitiveTypeString)) {
			return FunctionType.STRING_TYPE;
		}
		
		return FunctionType.VOID_TYPE;
	}

}
