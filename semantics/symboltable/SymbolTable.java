package semantics.symboltable;
import java.util.HashMap;
import semantics.symboltable.scopes.ClassScope;

public class SymbolTable {
    private final static String TAG = "MobiProg_SymbolTable";
	
	private static SymbolTable sharedInstance = null;
	
	public static SymbolTable getInstance() {
		return sharedInstance;
	}
	
	private HashMap<String, ClassScope> classTable;
	
	private SymbolTable() {
		this.classTable = new HashMap<String, ClassScope>();
	}
	
	public static void initialize() {
		sharedInstance = new SymbolTable();
	}
	
	public static void reset() {
		sharedInstance.classTable.clear();
	}
	
	public void addClassScope(String className, ClassScope classScope) {
		this.classTable.put(className, classScope);
	}
	
	public ClassScope getClassScope(String className) {
		if(this.containsClassScope(className)) {
			return this.classTable.get(className);
		}
		else {
			Log.e(TAG, className + " is not found!");
			return null;
		}
	}
	
	public boolean containsClassScope(String className) {
		return this.classTable.containsKey(className);
	}
	
	public void resetClassTables() {
		ClassScope[] classScopes = this.classTable.values().toArray(new ClassScope[this.classTable.size()]);
		
		for(int i = 0; i < classScopes.length; i++) {
			classScopes[i].resetValues();
		}
	}
}
