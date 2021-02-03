package execution.commands;

import java.util.ArrayList;

import execution.ExecutionManager;
import model.CUSTOMParser.WhileStatementContext;
import semantics.representations.CstmValue;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;

public class WhileCommand implements IterCommandInterface{

  private CstmLocalScope cstmLocalScope; //while loop scope
  private ArrayList<CommandInterface> commandList; // while command list
  private WhileStatementContext whileStatementContext; 
	IterationEvaluatorCommand iterationEval;
	private int counter = 0;
	private int condition;
	private CstmValue cstmValue; // identifier
  
  public WhileCommand(WhileStatementContext whileStatementContext){
		this.whileStatementContext = whileStatementContext;
		this.commandList = new ArrayList<CommandInterface>();
    this.cstmLocalScope = GlobalScopeManager.getInstance().getCurrentScope();
		this.iterationEval = new IterationEvaluatorCommand(this.whileStatementContext, this.cstmLocalScope);
		this.cstmValue = this.cstmLocalScope.getVariableWithinScope(whileStatementContext.IDENTIFIER().getText());
  }

	@Override
	public void execute() {
		//iterationEval.execute();
		this.counter = Integer.parseInt(cstmValue.getValue().toString());

		EvaluationCommand evalCommand = new EvaluationCommand(this.whileStatementContext.simpleExpression(), this.cstmLocalScope);
		evalCommand.execute();

		this.condition = iterationEval.getEvaluated();

		// if while condition contains "up to"
		if(this.whileStatementContext.upDownToStatement().getText().contains("up to")){  
			while(this.counter < evalCommand.getResult().intValue()){
				int index = 0;
				while(index < commandList.size()){
					if(ExecutionManager.getInstance().isRunning()){
						commandList.get(index).execute();
						index++;
					}
				}
				evalCommand = new EvaluationCommand(this.whileStatementContext.simpleExpression(), this.cstmLocalScope);
				evalCommand.execute();
				if(this.whileStatementContext.upDownToStatement().getText().contains("up to")){
					this.counter = Integer.parseInt(cstmValue.getValue().toString());
					this.counter++;
					this.cstmValue.setValue(this.counter);
				} else {
					this.counter = Integer.parseInt(cstmValue.getValue().toString());
					this.counter--;
					this.cstmValue.setValue(this.counter);
				}
			}
		}
		// if while condition contains "down to"
		else {
		}
	}

	@Override
	public void addCommand(CommandInterface commandInterface) {
		this.commandList.add(commandInterface);
	}
  
}
