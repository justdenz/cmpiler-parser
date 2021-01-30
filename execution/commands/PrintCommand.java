package execution.commands;

import org.antlr.v4.parse.ANTLRParser.id_return;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import builder.errorcheckers.CstmUnDecChecker;
import console.Printer;
import model.CUSTOMParser.PrintParametersContext;
import model.CUSTOMParser.PrintStatementContext;
import model.CUSTOMParser.PrintStatementListContext;
import model.CUSTOMParser.SimpleExpressionContext;

public class PrintCommand implements CommandInterface, ParseTreeListener {

    private PrintStatementListContext printStatementList;
    private String statementToPrint = "";

    public PrintCommand(PrintStatementListContext printStatementList){
        this.printStatementList = printStatementList;
    }

    @Override
    public void execute() {
        ParseTreeWalker tree = new ParseTreeWalker();
        tree.walk(this, this.printStatementList);
        String msgInTerminal = Printer.getInstance().getTerminalContent();
        Printer.getInstance().display(msgInTerminal + this.statementToPrint + "\n");
        this.statementToPrint = "";
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        if(ctx instanceof PrintParametersContext){
            PrintParametersContext printParamCtx = (PrintParametersContext) ctx;

            this.statementToPrint = printParamCtx.getText().replace("\"", "");
            
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

    public String getStatementToPrint() {
		return this.statementToPrint;
	}
}
