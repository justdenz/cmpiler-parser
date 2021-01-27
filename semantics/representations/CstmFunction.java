package semantics.representations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import builder.errorcheckers.CstmTypeChecker;
import console.Console;
import model.CUSTOMParser.ExpressionContext;
import semantics.representations.CstmValue.PrimitiveType;
import semantics.symboltable.scopes.CstmClassScope;
import semantics.symboltable.scopes.CstmLocalScope;
import semantics.utils.CstmRecognizedKeywords;

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
	
    private CstmLocalScope parentLocalScope; //refers to the parent local scope of this function.

    private LinkedHashMap<String, CstmClassScope> parameterReferences; //the list of parameters accepted that follows the 'call-by-reference' standard.
	private LinkedHashMap<String, CstmValue> parameterValues;	//the list of parameters accepted that follows the 'call-by-value' standard.
	private CstmValue returnValue; //the return value of the function. null if it's a void type
	private FunctionType returnType = FunctionType.VOID_TYPE; //the return type of the function
    
    public CstmFunction() {
		//this.commandSequences = new ArrayList<ICommand>();
		this.parameterValues = new LinkedHashMap<String,CstmValue>();
		this.parameterReferences = new LinkedHashMap<String, CstmClassScope>();
    }
    
    public void setParentLocalScope(CstmLocalScope localScope) {
		this.parentLocalScope = localScope;
	}
	
	public CstmLocalScope getParentLocalScope() {
		return this.parentLocalScope;
    }
    
    public void setReturnType(FunctionType functionType) {
		this.returnType = functionType;
		
		//create an empty value as a return value
		switch(this.returnType) {
			case BOOLEAN_TYPE: this.returnValue = new CstmValue(true, PrimitiveType.BOOLEAN); break;
			case INT_TYPE: this.returnValue = new CstmValue(0, PrimitiveType.INT); break;
			case FLOAT_TYPE: this.returnValue = new CstmValue(0, PrimitiveType.FLOAT); break;
			case STRING_TYPE: this.returnValue = new CstmValue("", PrimitiveType.STRING); break;
			default:break;	
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
    
    /*
	 * Maps parameters by values, which means that the value is copied to its parameter listing
	 */
	public void mapParameterByValue(String... values) {
		for(int i = 0; i < values.length; i++) {
			CstmValue cstmValue = this.getParameterAt(i);
			cstmValue.setValue(values[i]);
		}
	}
	
	public void mapParameterByValueAt(String value, int index) {
		if(index >= this.parameterValues.size()) {
			return;
		}
		
		CstmValue tempValue = this.getParameterAt(index);
		tempValue.setValue(value);
    }
    
    public void mapArrayAt(CstmValue cstmValue, int index, String identifier) {
		if(index >= this.parameterValues.size()) {
			return;
		}
		
		CstmArray cstmArray = (CstmArray) cstmValue.getValue();
		
		CstmArray newCstmArray = new CstmArray(cstmArray.getPrimitiveType(), identifier);
		CstmValue newCstmValue = new CstmValue(newCstmArray, PrimitiveType.ARRAY);
		
		newCstmArray.initializeSize(cstmArray.getSize());
		
		for(int i = 0; i < newCstmArray.getSize(); i++) {
			newCstmArray.updateValueAt(cstmArray.getValueAt(i), i);
		}
		
		this.parameterValues.put(this.getParameterKeyAt(index), newCstmValue);
		
    }
    
    public int getParameterValueSize() {
		return this.parameterValues.size();
	}
	
	public void verifyParameterByValueAt(ExpressionContext exprCtx, int index) {
		if(index >= this.parameterValues.size()) {
			return;
		}
		
		CstmValue cstmValue = this.getParameterAt(index);
		CstmTypeChecker typeChecker = new CstmTypeChecker(cstmValue, exprCtx);
		typeChecker.verify();
    }
    
    /*
	 * Maps parameters by reference, in this case, accept a class scope.
	 */
	public void mapParameterByReference(CstmClassScope... classScopes) {
		Console.log("Mapping of parameter by reference not yet supported.");
	}
	
	public void addParameter(String identifierString, CstmValue cstmValue) {
		this.parameterValues.put(identifierString, cstmValue);
		Console.log(this.functionName + " added an empty parameter " + identifierString + " type " + cstmValue.getPrimitiveType());
	}
	
	public boolean hasParameter(String identifierString) {
		return this.parameterValues.containsKey(identifierString);
    }
    
    public CstmValue getParameter(String identifierString) {
		if(this.hasParameter(identifierString)) {
			return this.parameterValues.get(identifierString);
		}
		else {
			Console.log(identifierString + " not found in parameter list");
			return null;
		}
	}
	
	public CstmValue getParameterAt(int index) {
		int i = 0;

		for(CstmValue cstmValue : this.parameterValues.values()) {
			if(i == index) {
				return cstmValue;
			}
			
			i++;
		}
		
		Console.log(index + " has exceeded parameter list.");
		return null;
    }
    
	private String getParameterKeyAt(int index) {
		int i = 0;

		for(String key : this.parameterValues.keySet()) {
			if(i == index) {
				return key;
			}
			
			i++;
		}
		
		Console.log(index + " has exceeded parameter list.");
		return null;
	}
	
	public CstmValue getReturnValue() {
		if(this.returnType == FunctionType.VOID_TYPE) {
			//Console.log(LogType.DEBUG, this.functionName + " is a void function. Null mobi value is returned");
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
		
		if(CstmRecognizedKeywords.matchesKeyword(CstmRecognizedKeywords.PRIMITIVE_TYPE_BOOLEAN, primitiveTypeString)) {
			return FunctionType.BOOLEAN_TYPE;
		}
		else if(CstmRecognizedKeywords.matchesKeyword(CstmRecognizedKeywords.PRIMITIVE_TYPE_FLOAT, primitiveTypeString)) {
			return FunctionType.FLOAT_TYPE;
		}
		else if(CstmRecognizedKeywords.matchesKeyword(CstmRecognizedKeywords.PRIMITIVE_TYPE_INT, primitiveTypeString)) {
			return FunctionType.INT_TYPE;
		}
		else if(CstmRecognizedKeywords.matchesKeyword(CstmRecognizedKeywords.PRIMITIVE_TYPE_STRING, primitiveTypeString)) {
			return FunctionType.STRING_TYPE;
		}
		
		return FunctionType.VOID_TYPE;
	}

}
