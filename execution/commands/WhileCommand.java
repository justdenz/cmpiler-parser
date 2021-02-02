package execution.commands;

import java.util.ArrayList;

import model.CUSTOMParser.WhileStatementContext;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;

public class WhileCommand implements IterCommandInterface{

  private CstmLocalScope cstmLocalScope;
  private ArrayList<CommandInterface> commandList;
  private WhileStatementContext whileStatementContext;
  IterationEvaluatorCommand iterationEval;
  
  public WhileCommand(WhileStatementContext whileStatementContext){
	this.whileStatementContext = whileStatementContext;
    this.cstmLocalScope = GlobalScopeManager.getInstance().getCurrentScope();
    this.iterationEval = new IterationEvaluatorCommand(this.whileStatementContext, this.cstmLocalScope);
  }


	@Override
	public void execute() {
		iterationEval.execute();
	}

	@Override
	public void addCommand(CommandInterface commandInterface) {
		this.commandList.add(commandInterface);
		
	}
  
}
