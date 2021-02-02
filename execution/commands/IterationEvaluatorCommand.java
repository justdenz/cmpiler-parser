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

    public IterationEvaluatorCommand(ForStatementContext forStatement, CstmLocalScope scope){
        this.forStatement = forStatement;
        this.scope = scope;
        this.evaluationCommand = new EvaluationCommand(forStatement.simpleExpression(), this.scope);
        this.result = false;
    }

    public IterationEvaluatorCommand(WhileStatementContext whileStatement, CstmLocalScope scope){
        this.whileStatement = whileStatement;
        this.scope = scope;
        this.evaluationCommand = new EvaluationCommand(whileStatement.simpleExpression(), this.scope);
        this.result = false;
    }

    @Override
    public void execute() {
        this.evaluationCommand.execute();

        if(forStatement != null){
            CstmValue cstmValue = this.scope.getVariableWithinScope(this.forStatement.forCondition().IDENTIFIER().getText());
            int leftHandValue = Integer.parseInt(cstmValue.getValue().toString());
            int rightHandValue = this.evaluationCommand.getResult().intValue();
            
            if(forStatement.upDownToStatement().getText().contains("up to")){
                if(leftHandValue <= rightHandValue){
                    int newValue = leftHandValue+1;
                    this.result = true;
                    cstmValue.setValue(Integer.toString(newValue));
                } else {
                    this.result = false;
                }
            } else if(forStatement.upDownToStatement().getText().contains("down to")){
                if(leftHandValue >= rightHandValue){
                    int newValue = leftHandValue-1;
                    this.result = true;
                    cstmValue.setValue(Integer.toString(newValue));

                } else {
                    this.result = false;
                }
            }
        }
        
        else if(whileStatement != null){
            CstmValue cstmValue = this.scope.getVariableWithinScope(this.whileStatement.IDENTIFIER().getText());
            int leftHandValue = Integer.parseInt(cstmValue.getValue().toString());
            int rightHandValue = this.evaluationCommand.getResult().intValue();

            if(whileStatement.upDownToStatement().getText().contains("up to")){
                if(leftHandValue <= rightHandValue){
                    int newValue = leftHandValue+1;
                    this.result = true;
                    cstmValue.setValue(Integer.toString(newValue));
                } else {
                    this.result = false;
                }
            } else if(whileStatement.upDownToStatement().getText().contains("down to")){
                if(leftHandValue >= rightHandValue){
                    int newValue = leftHandValue-1;
                    this.result = true;
                    cstmValue.setValue(Integer.toString(newValue));
                } else {
                    this.result = false;
                }
            }
        }

    }

    public boolean getResult(){
        return this.result;
    }
    
}
