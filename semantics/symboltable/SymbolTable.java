package semantics.symboltable;

import semantics.symboltable.scopes.ClassScope;

public class SymbolTable {
	
	private static SymbolTable sharedInstance = null;
	
	public static SymbolTable getInstance() {
		return sharedInstance;
	}
	
	private ClassScope classScope;
	
	private SymbolTable() {
		this.classScope = new ClassScope();
	}
	
	public static void initialize() {
		sharedInstance = new SymbolTable();
	}
	
	public static void reset() {
		sharedInstance.classScope = new ClassScope();
	}
	

	public ClassScope getClassScope() {
		return this.classScope;
	}
}
