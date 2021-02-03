package semantics.symboltable.scopes;

import java.util.HashMap;

import semantics.representations.CstmValue;

public class CstmLocalScope {

  private CstmLocalScope parentScope;
	
	private HashMap<String, CstmValue> localVariables = null;
	
	public CstmLocalScope() {
		this.parentScope = null;
		this.localVariables = new HashMap<String, CstmValue>();
	}
	
	public CstmLocalScope(CstmLocalScope parentScope) {
		this.parentScope = parentScope;
		this.localVariables = new HashMap<String, CstmValue>();
	}
	
	public void setParent(CstmLocalScope parentScope) {
		this.parentScope = parentScope;
	}
	
	public boolean isParent() {
		return (this.parentScope == null);
	}
	
	public CstmLocalScope getParent() {
		return this.parentScope;
	}
	
	public CstmValue getVariable(String identifier) {
		return this.localVariables.get(identifier);
	}
	
	public void addVariable(String identifier, CstmValue cstmValue) {
		this.localVariables.put(identifier, cstmValue);
	}

	public CstmValue getVariableWithinScope(String id) {
		CstmLocalScope current = this;
		CstmValue cstmValue = null;

		while (current != null) {
				cstmValue = current.getVariable(id);
				if (cstmValue != null) {
						return cstmValue;
				} 
				current = current.getParent();
		}
		return cstmValue;
  }
}
