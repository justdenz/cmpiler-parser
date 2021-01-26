
package semantics.symboltable.scopes;

import semantics.representations.Value;

public interface ScopeInterface {

	public abstract Value searchVariableIncludingLocal(String identifier);
	public abstract boolean isParent();
}
