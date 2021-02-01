package execution.commands;

import org.antlr.v4.runtime.tree.TerminalNode;

import model.CUSTOMParser.MutableContext;
import semantics.representations.CstmValue;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;

public class ArrayInitCommand implements CommandInterface{

  private TerminalNode identifier;
  private MutableContext mutableContext;
  private CstmLocalScope cstmLocalScope;

  public ArrayInitCommand(TerminalNode identifier, MutableContext mutableContext){
    this.identifier = identifier;
    this.mutableContext = mutableContext;
    this.cstmLocalScope = GlobalScopeManager.getInstance().getCurrentScope();
  }

	@Override
	public void execute() {

    CstmValue leftHandSide = this.cstmLocalScope.getVariableWithinScope(this.identifier.getText());
    CstmValue rightHandSide = this.cstmLocalScope.getVariableWithinScope(this.mutableContext.getText());
    
    if(leftHandSide != null){
      leftHandSide.setValue(rightHandSide);
    } 
	}
}
