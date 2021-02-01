package execution.commands;

import org.antlr.v4.runtime.tree.TerminalNode;

import model.CUSTOMParser.SimpleExpressionContext;
import semantics.representations.CstmArray;
import semantics.representations.CstmValue;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;

public class ArrayInitCommand implements CommandInterface{

  private TerminalNode identifier;
  private SimpleExpressionContext simpleExpressionContext;
  private CstmLocalScope cstmLocalScope;

  public ArrayInitCommand(TerminalNode identifier, SimpleExpressionContext simpleExpressionContext){
    this.identifier = identifier;
    this.simpleExpressionContext = simpleExpressionContext;
    this.cstmLocalScope = GlobalScopeManager.getInstance().getCurrentScope();
  
  }

	@Override
	public void execute() {

    CstmValue leftHandSide = this.cstmLocalScope.getVariableWithinScope(this.identifier.getText());
    CstmValue rightHandSide = this.cstmLocalScope.getVariableWithinScope(this.simpleExpressionContext.getText());
    
    if(leftHandSide != null){
      leftHandSide.setValue(rightHandSide);
    }
    
	}
    
  
}
