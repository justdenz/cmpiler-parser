package execution.commands;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import console.Printer;
import javafx.application.Platform;
import console.Console;
import model.CUSTOMParser.PrintParametersContext;
import model.CUSTOMParser.PrintStatementListContext;
import semantics.representations.CstmFunction;
import semantics.representations.CstmValue;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;

public class PrintCommand implements CommandInterface, ParseTreeListener {

    private PrintStatementListContext printStatementList;
    private String statementToPrint = "";
    private CstmLocalScope cstmScope;

    public PrintCommand(PrintStatementListContext printStatementList){
        this.printStatementList = printStatementList;
        this.cstmScope = GlobalScopeManager.getInstance().getCurrentScope();

        List<PrintParametersContext> paramsList = printStatementList.printParameters();

        for(PrintParametersContext param : paramsList){
            if(param.IDENTIFIER() != null){
                String varName = param.IDENTIFIER().getText();
                CstmValue val = cstmScope.getVariableWithinScope(varName);
                if(val == null){
                    this.statementToPrint = "In line " + String.valueOf(param.getStart().getLine()) + " : Found undeclared value for printing.";
                }
            } else if(param.call() != null){
                CstmFunction func = GlobalScopeManager.getInstance().getFunction(param.call().IDENTIFIER().getText());
                if(func == null){
                    Console.log(String.valueOf(param.getStart().getLine()), "Found an undeclared function for printing.");
                }
            }
        }
    }

    @Override
    public void execute() {
        ParseTreeWalker tree = new ParseTreeWalker();
        tree.walk(this, this.printStatementList);
        final String toPrint = this.statementToPrint;
        Platform.runLater(new Runnable() {
            @Override public void run() {
                Printer.getInstance().display(toPrint);
            }
        });
        this.statementToPrint = "";
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        if(ctx instanceof PrintParametersContext){
            PrintParametersContext printParamCtx = (PrintParametersContext) ctx;

            //printing of regular string
            if(printParamCtx.StringLiteral() != null){
                this.statementToPrint += printParamCtx.StringLiteral().getText().replaceAll("^\"+|\"+$", "");
            }
            //printing variables
            else if(printParamCtx.IDENTIFIER() != null){
                String varName = printParamCtx.IDENTIFIER().getText();
                CstmValue val = cstmScope.getVariableWithinScope(varName);
                this.statementToPrint += val.getValue().toString();
            }
            //printing expressions
            else if(printParamCtx.simpleExpression() != null){
                EvaluationCommand evaluationCommand = new EvaluationCommand(printParamCtx.simpleExpression(), this.cstmScope);
                evaluationCommand.execute();
                System.out.println(evaluationCommand.getResult().toPlainString());
            }
            //printing function calls
            // else if(printParamCtx.call() != null){
                
            // }

        }
    }

    @Override
    public void exitEveryRule(ParserRuleContext arg0) {

    }

    @Override
    public void visitErrorNode(ErrorNode arg0) {

    }

    @Override
    public void visitTerminal(TerminalNode arg0) {

    }
}
