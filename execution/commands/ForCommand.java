package execution.commands;

import java.util.ArrayList;

import model.CUSTOMParser.ForStatementContext;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;


public class ForCommand implements IterCommandInterface{

	private CstmLocalScope cstmLocalScope;
	private ForStatementContext forStmtCtx;
	private ArrayList<CommandInterface> commandList;
	private IterationEvaluatorCommand iterationEvaluatorCommand;

	private ForCommand(ForStatementContext forStmtCtx){
		this.forStmtCtx = forStmtCtx;
		this.commandList = new ArrayList<CommandInterface>();
		this.cstmLocalScope = GlobalScopeManager.getInstance().getCurrentScope();
		this.iterationEvaluatorCommand = new IterationEvaluatorCommand(this.forStmtCtx, this.cstmLocalScope);
	}

	@Override
	public void execute() {
		iterationEvaluatorCommand.execute();
	}

	@Override
	public void addCommand(CommandInterface commandInterface) {
		this.commandList.add(commandInterface);
	}
  
}