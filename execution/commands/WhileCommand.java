package execution.commands;

import java.util.ArrayList;

import model.CUSTOMParser.WhileStatementContext;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;

public class WhileCommand implements IterCommandInterface{

  private CstmLocalScope cstmLocalScope;
  private ArrayList<CommandInterface> commandList;
  private WhileStatementContext whileStatementContext;
  
  public WhileCommand(){
    this.cstmLocalScope = GlobalScopeManager.getInstance().getCurrentScope();
    
  }


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCommand(CommandInterface commandInterface) {
		// TODO Auto-generated method stub
		
	}
  
}
