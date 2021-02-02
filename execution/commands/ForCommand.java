package execution.commands;

import java.util.ArrayList;

import model.CUSTOMParser.ForStatementContext;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;


public class ForCommand implements IterCommandInterface{

	private CstmLocalScope cstmLocalScope;
	private ForStatementContext forStmtCtx;
	private ArrayList<CommandInterface> commandList;

	private ForCommand(ForStatementContext forStmtCtx){
		this.forStmtCtx = forStmtCtx;
		this.commandList = new ArrayList<CommandInterface>();
		this.cstmLocalScope = GlobalScopeManager.getInstance().getCurrentScope();
	}

	@Override
	public void execute() {
		EvaluationCommand evaluationCommand = new EvaluationCommand(this.forStmtCtx.simpleExpression(), this.cstmLocalScope);
		evaluationCommand.execute();
		while(){
			for(CommandInterface comm: this.commandList){
				comm.execute();
			}
			
		}
	}

	@Override
	public void addCommand(CommandInterface commandInterface) {
		this.commandList.add(commandInterface);
	}

	public int getCommandCount() {
		return this.commandList.size();
	}
  
}