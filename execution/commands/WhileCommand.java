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
	private boolean isLessThan = false;
	private int counter = 0;
	private CstmValue cstmValue;
  
	public WhileCommand(WhileStatementContext whileStatementContext){
		this.cstmLocalScope = GlobalScopeManager.getInstance().getCurrentScope();
		this.whileStatementContext = whileStatementContext;
		this.commandList = new ArrayList<CommandInterface>();
		this.cstmValue = cstmLocalScope.getVariableWithinScope(whileStatementContext.IDENTIFIER().getText());
		this.iterationEval = new IterationEvaluatorCommand(this.whileStatementContext, this.cstmLocalScope);

		if(whileStatementContext.upDownToStatement().getText().contains("up")){
			this.isLessThan = true;
		} else {
			this.isLessThan = false;
		}

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
			this.updateCounter();
		}
	}

	@Override
	public void addCommand(CommandInterface commandInterface) {
		this.commandList.add(commandInterface);
	}

	private void updateCounter(){
		if (this.isLessThan) {
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
