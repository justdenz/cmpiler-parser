package semantics.utils;

/**
 * A holder for recognized keywords to be used for various conditional statements for 
 * creating intermediate representations
 */

public class CstmKeywords {
	
	public static String IS_BOOLEAN = "bool";
	public static String IS_INT = "int";
	public static String IS_FLOAT = "float";
	public static String IS_STRING = "String";

	public static String IS_ARRAY = "array";
	
	public static String BOOLEAN_TRUE = "T";
	public static String BOOLEAN_FALSE = "F";
	
	/*
	 * Returns true if the keywords match. This is case-sensitive
	 */
	public static boolean matchesKeyword(String keyword, String textToMatch) {
		if(textToMatch.contains(keyword)) {
			return true;
		}
		else {
			return false;
		}
	}
}
