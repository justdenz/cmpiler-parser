
package semantics.symboltable.scopes;

import semantics.representations.CstmValue;

public interface CstmScopeInterface {

	public abstract CstmValue searchVariableIncludingLocal(String identifier);
	public abstract boolean isParent();
}
