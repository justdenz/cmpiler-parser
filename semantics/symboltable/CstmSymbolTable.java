package semantics.symboltable;

import semantics.symboltable.scopes.CstmClassScope;

public class CstmSymbolTable {
	
	private static CstmSymbolTable sharedInstance = null;
	
	public static CstmSymbolTable getInstance() {
		return sharedInstance;
	}
	
	private CstmClassScope classScope;
	
	private CstmSymbolTable() {
		this.classScope = new CstmClassScope();
	}
	
	public static void initialize() {
		sharedInstance = new CstmSymbolTable();
	}
	
	public static void reset() {
		sharedInstance.classScope = new CstmClassScope();
	}
	

	public CstmClassScope getClassScope() {
		return this.classScope;
	}
}
