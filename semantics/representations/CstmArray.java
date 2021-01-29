package semantics.representations;

import console.Console;
import semantics.representations.CstmValue.PrimitiveType;
import semantics.utils.CstmKeywords;

public class CstmArray {

    private CstmValue[] valueArray;
	private PrimitiveType arrayPrimitiveType;
	private String arrayIdentifier;
	private boolean finalFlag = false;
	
	public CstmArray(PrimitiveType primitiveType, String identifier) {
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
		this.valueArray = new CstmValue[size];
		System.out.println("Mobi array initialized to size " +this.valueArray.length);
	}
	
	public int getSize() {
		return this.valueArray.length;
	}
	
	public void updateValueAt(CstmValue value, int index) {
		if(index >= this.valueArray.length) {
            System.out.println("RUNTIME ARRAY OUT OF BOUNDS");
			// Console.log(LogType.ERROR, String.format(ErrorRepository.getErrorMessage(ErrorRepository.RUNTIME_ARRAY_OUT_OF_BOUNDS), this.arrayIdentifier));
			return;
		}
		this.valueArray[index] = value;
	}
	
	public CstmValue getValueAt(int index) {
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
	public static CstmArray createArray(String primitiveTypeString, String arrayIdentifier) {
		//identify primitive type
		PrimitiveType primitiveType = PrimitiveType.NOT_YET_IDENTIFIED;
		
		if(CstmKeywords.matchesKeyword(CstmKeywords.IS_BOOLEAN, primitiveTypeString)) {
			primitiveType = PrimitiveType.BOOLEAN;
		}
		else if(CstmKeywords.matchesKeyword(CstmKeywords.IS_FLOAT, primitiveTypeString)) {
			primitiveType = PrimitiveType.FLOAT;
		}
		else if(CstmKeywords.matchesKeyword(CstmKeywords.IS_INT, primitiveTypeString)) {
			primitiveType = PrimitiveType.INT;
		}
		else if(CstmKeywords.matchesKeyword(CstmKeywords.IS_STRING, primitiveTypeString)) {
			primitiveType = PrimitiveType.STRING;
		}
		
		CstmArray array = new CstmArray(primitiveType, arrayIdentifier);
		
		return array;
	}
}
