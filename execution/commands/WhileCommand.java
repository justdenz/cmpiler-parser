package execution.commands;

import java.util.ArrayList;

import execution.ExecutionManager;
import model.CUSTOMParser.WhileStatementContext;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;

public class WhileCommand implements IterCommandInterface{

  private CstmLocalScope cstmLocalScope; //while loop scope
  private ArrayList<CommandInterface> commandList; // while command list
  private WhileStatementContext whileStatementContext; 
	IterationEvaluatorCommand iterationEval;
  
  public WhileCommand(WhileStatementContext whileStatementContext){
		this.cstmLocalScope = GlobalScopeManager.getInstance().getCurrentScope();
		this.whileStatementContext = whileStatementContext;
		this.commandList = new ArrayList<CommandInterface>();
		this.iterationEval = new IterationEvaluatorCommand(this.whileStatementContext, this.cstmLocalScope);
  }

	@Override
	public void execute() {
		iterationEval.execute();

		while(iterationEval.getResult()){
			int index = 0;
			while(index < commandList.size()){
				if(ExecutionManager.getInstance().isRunning()){
					commandList.get(index).execute();
					index++;
				}
			}
			iterationEval.execute();
		}
	}

	@Override
	public void addCommand(CommandInterface commandInterface) {
		this.commandList.add(commandInterface);
	}
}
