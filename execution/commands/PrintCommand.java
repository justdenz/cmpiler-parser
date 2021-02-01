package execution.commands;

import org.antlr.v4.parse.ANTLRParser.id_return;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import builder.errorcheckers.CstmUnDecChecker;
import console.Printer;
import execution.ExecutionManager;
import execution.commands.EvaluationCommand;
import console.Console;
import model.CUSTOMParser.PrintParametersContext;
import model.CUSTOMParser.PrintStatementContext;
import model.CUSTOMParser.PrintStatementListContext;
import model.CUSTOMParser.SimpleExpressionContext;
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
    }

    @Override
    public void execute() {
        ParseTreeWalker tree = new ParseTreeWalker();
        tree.walk(this, this.printStatementList);
        System.out.println("To be printed: "+this.statementToPrint);
        Printer.getInstance().display(this.statementToPrint);
        this.statementToPrint = "";
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        if(ctx instanceof PrintParametersContext){
            PrintParametersContext printParamCtx = (PrintParametersContext) ctx;

            //printing of regular string
            if(printParamCtx.StringLiteral() != null){
                System.out.println("its a string so imma print: " + printParamCtx.StringLiteral().getText().replaceAll("^\"+|\"+$", ""));
                this.statementToPrint += printParamCtx.StringLiteral().getText().replaceAll("^\"+|\"+$", "");
            }
            //printing expressions

            //printing variables
            else if(printParamCtx.IDENTIFIER() != null){
                String varName = printParamCtx.IDENTIFIER().getText();
                CstmValue val = cstmScope.getVariableWithinScope(varName);
                if(val != null){
                    this.statementToPrint += val.getValue().toString();
                } else {
                    this.statementToPrint = "In line " + String.valueOf(printParamCtx.getStart().getLine()) + " : Found undeclared value for printing.";
                    ExecutionManager.getInstance().stopExecution();
                }
            }

            else{
                EvaluationCommand evaluationCommand = new EvaluationCommand(printParamCtx.simpleExpression(), this.cstmScope);
                evaluationCommand.execute();
                System.out.println(evaluationCommand.getResult());
            }
            //printing function calls

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
