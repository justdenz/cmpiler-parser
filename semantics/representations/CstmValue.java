package semantics.representations;

import javax.swing.text.StringContent;

import semantics.utils.CstmKeywords;

public class CstmValue {
    
    //these are the accepted primitive types
    public enum PrimitiveType {
		NOT_YET_IDENTIFIED,
		BOOLEAN,
		INT,
		FLOAT,
		STRING,
		ARRAY
    }
    
    private Object defaultValue; //this value will no longer change.
	private Object objValue;
	private PrimitiveType primitiveType = PrimitiveType.NOT_YET_IDENTIFIED;
    private boolean finalFlag = false;
    
    public CstmValue(Object value, String primitiveType) {

		PrimitiveType verifiedPrimType = verifyPrimType(primitiveType);

		if(value == null || checkValueType(value, verifiedPrimType)) {
			this.objValue = value;
			this.primitiveType = verifiedPrimType;
		}
		else {
			System.out.println("Value is not appropriate for  " + primitiveType + "!");
		}
	}
	
	public void setPrimitiveType(PrimitiveType primitiveType) {
		this.primitiveType = primitiveType;
	}
	
	public void reset() {
		this.objValue = this.defaultValue;
    }

    /*
	 * Marks this value as final if there is a final keyword
	 */
	public void markFinal() {
		this.finalFlag = true;
	}
	
	public boolean isFinal() {
		return this.finalFlag;
    }
    
    public void setValue(String value) {
		
		if(this.primitiveType == PrimitiveType.NOT_YET_IDENTIFIED) {
			System.out.println("Primitive type not yet identified!");
		}
		
		else if(this.primitiveType == PrimitiveType.STRING) {
			this.objValue = value.replace("\"", "");
		}
		else if(this.primitiveType == PrimitiveType.ARRAY) {
			System.out.println(this.primitiveType + " is an array. Cannot directly change value.");
		}
    }
    
    public Object getValue() {
		return this.objValue;
	}
	
	public PrimitiveType getPrimitiveType() {
		return this.primitiveType;
	}
    
    //TYPE CHECKING MECHANISM
    public static boolean checkValueType(Object value, PrimitiveType primitiveType) {
		switch(primitiveType) {
			case BOOLEAN:
				return value instanceof Boolean;
			case INT:
				return value instanceof Integer;
			case FLOAT:
				return value instanceof Float;
			case STRING:
				return value instanceof String;
			case ARRAY:
				return value instanceof Object;
			default:
				return false;
		}
    }
    
    public static PrimitiveType verifyPrimType(String primitiveTypeString) {
		
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
		else if(CstmKeywords.matchesKeyword(CstmKeywords.IS_ARRAY, primitiveTypeString)) {
			primitiveType = PrimitiveType.ARRAY;
		}
	
		return primitiveType;
	}
}
