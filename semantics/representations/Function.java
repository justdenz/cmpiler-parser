package semantics.representations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import builder.errorcheckers.TypeChecker;
import console.Console;
import model.CUSTOMParser.ExpressionContext;
import semantics.representations.Value.PrimitiveType;
import semantics.symboltable.scopes.ClassScope;
import semantics.symboltable.scopes.LocalScope;
import semantics.utils.RecognizedKeywords;

/**
 * Represents the intermediate representation of a function
 */

public class Function {

    public enum FunctionType {
		INT_TYPE,
		BOOLEAN_TYPE,
		FLOAT_TYPE,
		STRING_TYPE,
		VOID_TYPE,
    }
    
    private String functionName;
	//private List<ICommand> commandSequences; //the list of commands execution by the function
	
    private LocalScope parentLocalScope; //refers to the parent local scope of this function.

    private LinkedHashMap<String, ClassScope> parameterReferences; //the list of parameters accepted that follows the 'call-by-reference' standard.
	private LinkedHashMap<String, Value> parameterValues;	//the list of parameters accepted that follows the 'call-by-value' standard.
	private Value returnValue; //the return value of the function. null if it's a void type
	private FunctionType returnType = FunctionType.VOID_TYPE; //the return type of the function
    
    public Function() {
		//this.commandSequences = new ArrayList<ICommand>();
		this.parameterValues = new LinkedHashMap<String,Value>();
		this.parameterReferences = new LinkedHashMap<String, ClassScope>();
    }
    
    public void setParentLocalScope(LocalScope localScope) {
		this.parentLocalScope = localScope;
	}
	
	public LocalScope getParentLocalScope() {
		return this.parentLocalScope;
    }
    
    public void setReturnType(FunctionType functionType) {
		this.returnType = functionType;
		
		//create an empty mobi value as a return value
		switch(this.returnType) {
			case BOOLEAN_TYPE: this.returnValue = new Value(true, PrimitiveType.BOOLEAN); break;
			case INT_TYPE: this.returnValue = new Value(0, PrimitiveType.INT); break;
			case FLOAT_TYPE: this.returnValue = new Value(0, PrimitiveType.FLOAT); break;
			case STRING_TYPE: this.returnValue = new Value("", PrimitiveType.STRING); break;
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
			Value value = this.getParameterAt(i);
			value.setValue(values[i]);
		}
	}
	
	public void mapParameterByValueAt(String value, int index) {
		if(index >= this.parameterValues.size()) {
			return;
		}
		
		Value tempValue = this.getParameterAt(index);
		tempValue.setValue(value);
    }
    
    public void mapArrayAt(Value value, int index, String identifier) {
		if(index >= this.parameterValues.size()) {
			return;
		}
		
		Array mobiArray = (Array) value.getValue();
		
		Array newArray = new Array(mobiArray.getPrimitiveType(), identifier);
		Value newValue = new Value(newArray, PrimitiveType.ARRAY);
		
		newArray.initializeSize(mobiArray.getSize());
		
		for(int i = 0; i < newArray.getSize(); i++) {
			newArray.updateValueAt(mobiArray.getValueAt(i), i);
		}
		
		this.parameterValues.put(this.getParameterKeyAt(index), newValue);
		
    }
    
    public int getParameterValueSize() {
		return this.parameterValues.size();
	}
	
	public void verifyParameterByValueAt(ExpressionContext exprCtx, int index) {
		if(index >= this.parameterValues.size()) {
			return;
		}
		
		Value value = this.getParameterAt(index);
		TypeChecker typeChecker = new TypeChecker(value, exprCtx);
		typeChecker.verify();
    }
    
    /*
	 * Maps parameters by reference, in this case, accept a class scope.
	 */
	public void mapParameterByReference(ClassScope... classScopes) {
		Console.log("Mapping of parameter by reference not yet supported.");
	}
	
	public void addParameter(String identifierString, Value value) {
		this.parameterValues.put(identifierString, value);
		Console.log(this.functionName + " added an empty parameter " +identifierString+ " type " +value.getPrimitiveType());
	}
	
	public boolean hasParameter(String identifierString) {
		return this.parameterValues.containsKey(identifierString);
    }
    
    public Value getParameter(String identifierString) {
		if(this.hasParameter(identifierString)) {
			return this.parameterValues.get(identifierString);
		}
		else {
			Console.log(identifierString + " not found in parameter list");
			return null;
		}
	}
	
	public Value getParameterAt(int index) {
		int i = 0;

		for(Value value : this.parameterValues.values()) {
			if(i == index) {
				return value;
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
	
	public Value getReturnValue() {
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
		
		if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_BOOLEAN, primitiveTypeString)) {
			return FunctionType.BOOLEAN_TYPE;
		}
		else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_FLOAT, primitiveTypeString)) {
			return FunctionType.FLOAT_TYPE;
		}
		else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_INT, primitiveTypeString)) {
			return FunctionType.INT_TYPE;
		}
		else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_STRING, primitiveTypeString)) {
			return FunctionType.STRING_TYPE;
		}
		
		return FunctionType.VOID_TYPE;
	}

}
