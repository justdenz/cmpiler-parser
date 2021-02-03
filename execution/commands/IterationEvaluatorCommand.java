package execution.commands;

import model.CUSTOMParser.ForStatementContext;
import model.CUSTOMParser.SimpleExpressionContext;
import model.CUSTOMParser.WhileStatementContext;
import semantics.representations.CstmValue;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;

public class IterationEvaluatorCommand implements CommandInterface{

    private ForStatementContext forStatement;
    private WhileStatementContext whileStatement;
    private CstmLocalScope scope;
    EvaluationCommand evaluationCommand;
    private boolean result;
    private int evaluated;
    private CstmValue cstmValue;

    public IterationEvaluatorCommand(ForStatementContext forStatement, CstmLocalScope scope){
        this.forStatement = forStatement;
        this.scope = scope;
        this.evaluationCommand = new EvaluationCommand(forStatement.simpleExpression(), this.scope);
        this.result = false;
        this.cstmValue = scope.getVariableWithinScope(forStatement.forCondition().IDENTIFIER().getText());
    }

    public IterationEvaluatorCommand(WhileStatementContext whileStatement, CstmLocalScope scope){
        this.whileStatement = whileStatement;
        this.scope = scope;
        this.evaluationCommand = new EvaluationCommand(whileStatement.simpleExpression(), this.scope);
        this.result = false;
        this.cstmValue = scope.getVariableWithinScope(whileStatement.IDENTIFIER().getText());
    }

    @Override
    public void execute() {
        this.evaluationCommand.execute();
        this.evaluated = this.evaluationCommand.getResult().intValue();

        if(forStatement != null){
            int leftHandValue = Integer.parseInt(cstmValue.getValue().toString());
            int rightHandValue = this.evaluationCommand.getResult().intValue();
            if(forStatement.upDownToStatement().getText().contains("up to")){
                if(leftHandValue < rightHandValue-1){
                    this.result = true;
                } else {
                    this.result = false;
                }
            } else if(forStatement.upDownToStatement().getText().contains("down to")){
                if(leftHandValue > rightHandValue-1){
                    this.result = true;

                } else {
                    this.result = false;
                }
            }
        }
        
        else if(whileStatement != null){
            int leftHandValue = Integer.parseInt(cstmValue.getValue().toString());
            int rightHandValue = this.evaluationCommand.getResult().intValue();

            if(whileStatement.upDownToStatement().getText().contains("up to")){
                if(leftHandValue < rightHandValue){
                    this.result = true;
                } else {
                    this.result = false;
                }
            } else if(whileStatement.upDownToStatement().getText().contains("down to")){
                if(leftHandValue > rightHandValue){
                    this.result = true;
                } else {
                    this.result = false;
                }
            }
        }

    }

    public boolean getResult(){
        return this.result;
    }

    public int getEvaluated(){
        return this.evaluated;
    }
}
