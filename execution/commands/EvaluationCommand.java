package execution.commands;

import java.math.BigDecimal;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import console.Printer;
import execution.ExecutionManager;
import model.CUSTOMParser.MutableContext;
import model.CUSTOMParser.SimpleExpressionContext;
import semantics.representations.CstmArray;
import semantics.representations.CstmValue;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;
import semantics.utils.CstmKeywords;
import semantics.utils.Expression;

public class EvaluationCommand implements CommandInterface, ParseTreeListener {

    private SimpleExpressionContext simpleExpression;
    private String modifiedExpression;
    private BigDecimal result;
    private CstmLocalScope scope;

    public EvaluationCommand(SimpleExpressionContext ctx, CstmLocalScope scope){
        this.simpleExpression = ctx;
        this.scope = scope;
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        this.modifiedExpression = this.simpleExpression.getText();
        evaluateIfFloat();
        if(this.modifiedExpression.contains(CstmKeywords.BOOLEAN_TRUE)){
            this.result = new BigDecimal(1);
        } else if(this.modifiedExpression.contains(CstmKeywords.BOOLEAN_FALSE)){
            this.result = new BigDecimal(0);
        } else {
            ParseTreeWalker tree = new ParseTreeWalker();
            tree.walk(this, this.simpleExpression);

            if(!this.modifiedExpression.contains("\"")){
                Expression evalExpression = new Expression(this.modifiedExpression);
                this.result = evalExpression.eval();
            }
        }
    }

    private void evaluateIfFloat(){
        if(this.modifiedExpression.contains("f")){
            this.modifiedExpression = this.modifiedExpression.replaceFirst("f", "");
        }
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        // TODO Auto-generated method stub
        if(ctx instanceof MutableContext){
            MutableContext mutableContext = (MutableContext) ctx;
            // if non-array variable
            if(mutableContext.IDENTIFIER() != null && mutableContext.LeftBracket() == null) {
                CstmValue cstmValue = this.scope.getVariableWithinScope(mutableContext.IDENTIFIER().getText());
                if(cstmValue == null){
                    ExecutionManager.getInstance().stopExecution();
                    Printer.getInstance().display("Variable might not be initialized at line  " + ctx.getStart().getLine());
                } else {
                    this.modifiedExpression = this.modifiedExpression.replaceFirst(mutableContext.IDENTIFIER().getText(), cstmValue.getValue().toString());    
                }
                
            } else {
                EvaluationCommand evaluationCommand = new EvaluationCommand(mutableContext.simpleExpression(), this.scope);
                evaluationCommand.execute();

                int arrayIndex = evaluationCommand.getResult().intValue();

                CstmValue cstmValue = scope.getVariableWithinScope(mutableContext.IDENTIFIER().getText());
                CstmArray cstmArray = (CstmArray) cstmValue.getValue();

                if(cstmArray.getValueAt(arrayIndex) != null){ //int x = anArray[arrayIndex];
                    if(cstmArray.getValueAt(arrayIndex).getValue() != null){
                        this.modifiedExpression = this.modifiedExpression.replaceFirst("\\[.*\\]", cstmArray.getValueAt(arrayIndex).getValue().toString());
                    } else {
                        ExecutionManager.getInstance().stopExecution();
                    }
                } else {
                    Printer.getInstance().display("Array Value out of bounds at line  " + ctx.getStart().getLine());
                    ExecutionManager.getInstance().stopExecution();
                }
            }
            
        }
    }

    @Override
    public void exitEveryRule(ParserRuleContext arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitErrorNode(ErrorNode arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitTerminal(TerminalNode arg0) {
        // TODO Auto-generated method stub

    }


    public BigDecimal getResult(){
        return this.result;
    }
}
