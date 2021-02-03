package execution.commands;

import java.util.ArrayList;

import execution.ExecutionManager;
import model.CUSTOMParser.ForConditionContext;
import model.CUSTOMParser.ForStatementContext;
import model.CUSTOMParser.SimpleExpressionContext;
import model.CUSTOMParser.UpDownToStatementContext;
import semantics.representations.CstmValue;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;


public class ForCommand implements IterCommandInterface{

	private CstmLocalScope cstmLocalScope;
	private ForStatementContext forStmtCtx;
	private ArrayList<CommandInterface> commandList;
	private int counter = 0;
	private CstmValue cstmValue;
	private String iteratorIdentifier;
	private ForConditionContext forConditionCtx;
	private UpDownToStatementContext upDownStmt;
	private SimpleExpressionContext simpleExprCtx;
	private boolean isLessThan = false;

	//private IterationEvaluatorCommand iterationEvaluatorCommand;

	public ForCommand(ForStatementContext forStmtCtx){
		this.forStmtCtx = forStmtCtx;
		this.commandList = new ArrayList<CommandInterface>();
		this.cstmLocalScope = GlobalScopeManager.getInstance().getCurrentScope();
		this.forConditionCtx = forStmtCtx.forCondition();
		this.upDownStmt = forStmtCtx.upDownToStatement();
		this.simpleExprCtx = forStmtCtx.simpleExpression();
		this.iteratorIdentifier = forConditionCtx.IDENTIFIER().getText();
		this.cstmValue = cstmLocalScope.getVariableWithinScope(iteratorIdentifier);

		if(upDownStmt.getText().contains("up")){
			this.isLessThan = true;
		} else {
			this.isLessThan = false;
		}
		//this.iterationEvaluatorCommand = new IterationEvaluatorCommand(this.forStmtCtx, this.cstmLocalScope);
	}

	@Override
	public void execute() {
		this.counter = Integer.parseInt(cstmValue.getValue().toString());

		EvaluationCommand evalCmd = new EvaluationCommand(this.simpleExprCtx, this.cstmLocalScope);
		evalCmd.execute();

		if(this.isLessThan){
			while(this.counter < evalCmd.getResult().intValue()){
				int index = 0;
				while(index < commandList.size()){
					if(ExecutionManager.getInstance().isRunning()){
						commandList.get(index).execute();
						index++;
					}
				}
				evalCmd = new EvaluationCommand(this.simpleExprCtx, this.cstmLocalScope);
				evalCmd.execute();
				this.updateCounter();
			}
		} else {
			while(this.counter > evalCmd.getResult().intValue()){
				int index = 0;
				while(index < commandList.size()){
					if(ExecutionManager.getInstance().isRunning()){
						commandList.get(index).execute();
						index++;
					}
				}
				evalCmd = new EvaluationCommand(this.simpleExprCtx, this.cstmLocalScope);
				evalCmd.execute();
				this.updateCounter();
			}
		}

		// iterationEvaluatorCommand.execute();
	
		// while(iterationEvaluatorCommand.getResult()){
		// 	int index = 0;
		// 	iterationEvaluatorCommand.execute();
		// 	while(index < this.commandList.size()){
		// 		if(ExecutionManager.getInstance().isRunning()){
		// 			commandList.get(index).execute();
		// 			index++;
		// 		}
		// 	}
		// 	iterationEvaluatorCommand.execute();
		// }
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