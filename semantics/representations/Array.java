package semantics.representations;

import console.Console;
import semantics.representations.Value.PrimitiveType;
import semantics.utils.RecognizedKeywords;

public class Array {

    private Value[] valueArray;
	private PrimitiveType arrayPrimitiveType;
	private String arrayIdentifier;
	private boolean finalFlag = false;
	
	public Array(PrimitiveType primitiveType, String identifier) {
		this.arrayPrimitiveType = primitiveType;
		this.arrayIdentifier = identifier;
	}
	
	public void setPrimitiveType(PrimitiveType primitiveType) {
		this.arrayPrimitiveType = primitiveType;
	}
	
	public PrimitiveType getPrimitiveType() {
		return this.arrayPrimitiveType;
	}
	
	public void markFinal() {
		this.finalFlag = true;
	}
	
	public boolean isFinal() {
		return this.finalFlag;
	}
	
	public void initializeSize(int size) {
		this.valueArray = new Value[size];
		System.out.println("Mobi array initialized to size " +this.valueArray.length);
	}
	
	public int getSize() {
		return this.valueArray.length;
	}
	
	public void updateValueAt(Value value, int index) {
		if(index >= this.valueArray.length) {
            System.out.println("RUNTIME ARRAY OUT OF BOUNDS");
			// Console.log(LogType.ERROR, String.format(ErrorRepository.getErrorMessage(ErrorRepository.RUNTIME_ARRAY_OUT_OF_BOUNDS), this.arrayIdentifier));
			return;
		}
		this.valueArray[index] = value;
	}
	
	public Value getValueAt(int index) {
		if(index >= this.valueArray.length) {
            System.out.println("RUNTIME ARRAY OUT OF BOUNDS");
			// Console.log(LogType.ERROR, String.format(ErrorRepository.getErrorMessage(ErrorRepository.RUNTIME_ARRAY_OUT_OF_BOUNDS), this.arrayIdentifier));
			return this.valueArray[this.valueArray.length - 1];
		}
		else {
			return this.valueArray[index];
		}
	}
	
	/*
	 * Utility function that returns an arary of specified primitive type.
	 */
	public static Array createArray(String primitiveTypeString, String arrayIdentifier) {
		//identify primitive type
		PrimitiveType primitiveType = PrimitiveType.NOT_YET_IDENTIFIED;
		
		if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_BOOLEAN, primitiveTypeString)) {
			primitiveType = PrimitiveType.BOOLEAN;
		}
		else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_FLOAT, primitiveTypeString)) {
			primitiveType = PrimitiveType.FLOAT;
		}
		else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_INT, primitiveTypeString)) {
			primitiveType = PrimitiveType.INT;
		}
		else if(RecognizedKeywords.matchesKeyword(RecognizedKeywords.PRIMITIVE_TYPE_STRING, primitiveTypeString)) {
			primitiveType = PrimitiveType.STRING;
		}
		
		Array array = new Array(primitiveType, arrayIdentifier);
		
		return array;
	}
}
