package execution.commands;

import java.util.ArrayList;
import java.util.List;

import execution.ExecutionManager;
import model.CUSTOMParser.SimpleExpressionContext;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;

public class ConditionalCommand implements SelectCommandInterface{
    List<CommandInterface> positiveCommands;
    List<CommandInterface> negativeCommands;
    SimpleExpressionContext ifConditionExpression;
    CstmLocalScope scope;
    EvaluationCommand evaluationCommand;

    public ConditionalCommand(SimpleExpressionContext simpleExpression){
        this.ifConditionExpression = simpleExpression;
        this.scope = GlobalScopeManager.getInstance().getCurrentScope();
        this.positiveCommands = new ArrayList<CommandInterface>();
        this.negativeCommands = new ArrayList<CommandInterface>();
        this.evaluationCommand = new EvaluationCommand(this.ifConditionExpression, this.scope);

    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        this.evaluationCommand.execute();
        System.out.println(this.evaluationCommand.getResult().intValue());
        if(this.evaluationCommand.getResult().intValue() == 1){
            int index = 0;
            while (index < positiveCommands.size() ) {
                if (ExecutionManager.getInstance().isRunning()) {
                    positiveCommands.get(index).execute();
                    index ++;
                } 
            }
        } else {
            int index = 0;
            while (index < negativeCommands.size() ) {
                if (ExecutionManager.getInstance().isRunning()) {
                    negativeCommands.get(index).execute();
                    index ++;
                } 
            }
        }

        
    }

    public int evaluateCondition(){

        return evaluationCommand.getResult().intValue();
    }

    @Override
    public void addIfCommand(CommandInterface command) {
        // TODO Auto-generated method stub
        this.positiveCommands.add(command);
    }

    @Override
    public void addElseCommand(CommandInterface command) {
        // TODO Auto-generated method stub
        this.negativeCommands.add(command);
    }

}
