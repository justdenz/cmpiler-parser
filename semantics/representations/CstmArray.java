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

		for(int i = 0; i < size; i++){
			CstmValue val = new CstmValue(null, this.arrayPrimitiveType);
			this.valueArray[i] = val;
		}
	}
	
	public int getSize() {
		return this.valueArray.length;
	}
	
	public void updateValueAt(CstmValue value, int index) {
		this.valueArray[index] = value;
	}
	
	public CstmValue getValueAt(int index) {
		return this.valueArray[index];
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
