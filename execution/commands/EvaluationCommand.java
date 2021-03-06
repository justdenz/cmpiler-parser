package execution.commands;

import java.math.BigDecimal;
import java.util.regex.Matcher;

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
import semantics.symboltable.scopes.CstmLocalScope;
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
                    this.modifiedExpression = this.modifiedExpression.replaceFirst(mutableContext.IDENTIFIER().getText(), Matcher.quoteReplacement(cstmValue.getValue().toString()));    
                }
                
            } else {
                EvaluationCommand evaluationCommand = new EvaluationCommand(mutableContext.simpleExpression(), this.scope);
                evaluationCommand.execute();

                int arrayIndex = evaluationCommand.getResult().intValue();

                CstmValue cstmValue = scope.getVariableWithinScope(mutableContext.IDENTIFIER().getText());
                CstmArray cstmArray = (CstmArray) cstmValue.getValue();

                if(cstmArray.getSize() > arrayIndex){ //int x = anArray[arrayIndex];
                    if(cstmArray.getValueAt(arrayIndex).getValue() != null){
                        // this.modifiedExpression = this.modifiedExpression.replaceFirst("\\[.*\\]", cstmArray.getValueAt(arrayIndex).getValue().toString());
                        this.modifiedExpression = cstmArray.getValueAt(arrayIndex).getValue().toString();
                    } else {
                        Printer.getInstance().display("Array might not be initialized at this index at line  " + ctx.getStart().getLine());
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

    @Override
    public void execute() {
        this.modifiedExpression = this.simpleExpression.getText();

        if(this.modifiedExpression.contains("\"")){
            String newComparisons = this.modifiedExpression.replaceAll("\"", "");
            String[]  compareArray = newComparisons.split("==");

            CstmValue stringValue = this.scope.getVariableWithinScope(compareArray[0].trim());
            String toBeCompared = stringValue.getValue().toString();

            if(toBeCompared.equals(compareArray[1].trim())){
                this.result = new BigDecimal(1);
            } else {
                this.result = new BigDecimal(0);
            }
        } else {
            ParseTreeWalker tree = new ParseTreeWalker();
            tree.walk(this, this.simpleExpression);
            Expression evalExpression = new Expression(this.modifiedExpression.replace("f", ""));
            this.result = evalExpression.eval();
        }
    }

    public BigDecimal getResult(){
        return this.result;
    }
}
