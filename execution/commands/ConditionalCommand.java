package execution.commands;

import java.util.ArrayList;
import java.util.List;

import model.CUSTOMParser.SimpleExpressionContext;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;

public class ConditionalCommand implements CommandInterface{
    List<CommandInterface> positiveCommands;
    List<CommandInterface> negativeCommands;
    SimpleExpressionContext ifConditionExpression;
    CstmLocalScope scope;
    EvaluationCommand evaluationCommand;

    public ConditionalCommand(SimpleExpressionContext simpleExpression){
        this.ifConditionExpression = simpleExpression;
        this.positiveCommands = new ArrayList<CommandInterface>();
        this.negativeCommands = new ArrayList<CommandInterface>();    
        this.evaluationCommand = new EvaluationCommand(this.ifConditionExpression, this.scope);
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        
    }

    public int evaluateCondition(){

        return evaluationCommand.getResult().intValue();
    }

}
