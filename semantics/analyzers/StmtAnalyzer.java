package semantics.analyzers;

import org.antlr.v4.runtime.ParserRuleContext;

import console.Console;
import execution.ExecutionManager;
import execution.FuncReturnTracker;
import execution.StmtCmdTracker;
import execution.commands.ConditionalCommand;
import execution.commands.IterCommandInterface;
import execution.commands.ReturnCommand;
import execution.commands.ScanCommand;
import execution.commands.SelectCommandInterface;
import builder.errorcheckers.CstmUnDecChecker;
import model.CUSTOMParser.CompoundStatementContext;
import model.CUSTOMParser.ExpressionStatementContext;
import model.CUSTOMParser.PrintStatementContext;
import model.CUSTOMParser.ScanStatementContext;
import model.CUSTOMParser.SelectionStatementContext;
import model.CUSTOMParser.StatementContext;
import semantics.representations.CstmFunction;
import semantics.representations.CstmValue;
import semantics.representations.CstmFunction.FunctionType;
import semantics.representations.CstmValue.PrimitiveType;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;

public class StmtAnalyzer implements AnalyzerInterface{

    private ParserRuleContext ctx;
    
    public StmtAnalyzer(ParserRuleContext ctx) {
        this.ctx = ctx;
    }
    
    @Override
	public void analyze() {
        if(ctx instanceof StatementContext){
            StatementContext stmtCtx = (StatementContext) ctx;

            // SCAN STATEMENT
            if (stmtCtx.scanStatement() != null){
                ScanStatementContext scanCtx = stmtCtx.scanStatement();

                if(scanCtx.IDENTIFIER() != null){
                    CstmValue cstmValue = GlobalScopeManager.getInstance().searchScopedVariable(scanCtx.IDENTIFIER().getText());

                    if(cstmValue != null){
                        if(cstmValue.getPrimitiveType() != PrimitiveType.ARRAY){
                            ScanCommand scanCmd = new ScanCommand(scanCtx.IDENTIFIER().getText(), scanCtx.StringLiteral().getText());
                            StmtCmdTracker stmtCmdTracker = StmtCmdTracker.getInstance();

                            if (stmtCmdTracker.isSelectionCommand()) {
                                SelectCommandInterface ifCommand = (SelectCommandInterface) stmtCmdTracker.getActiveCommand();

                                if (stmtCmdTracker.isInsideIf()) {
                                    ifCommand.addIfCommand(scanCmd);
                                } else {
                                    ifCommand.addElseCommand(scanCmd);
                                } 

                            } else if (stmtCmdTracker.isIterationCommand()) {
                                    IterCommandInterface iterationCommand = (IterCommandInterface) stmtCmdTracker.getActiveCommand();
                                    iterationCommand.addCommand(scanCmd);
                            } else {
                                    ExecutionManager.getInstance().addCommand(scanCmd);
                            }
                        } else{
                            Console.log(String.valueOf(scanCtx.getStart().getLine()), "Cannot make a scan assignment to an array");
                        }
                    } else {
                        Console.log(String.valueOf(scanCtx.getStart().getLine()) , "Variable not yet initialized");
                    }
                }
            } 
            // PRINT STATEMENT
            else if(stmtCtx.printStatement() != null){
                PrintStatementContext printStatementCtx = stmtCtx.printStatement();
                if(printStatementCtx.printStatementList() != null){
                    PrintStmtAnalyzer printStatementAnalyzer = new PrintStmtAnalyzer(printStatementCtx.printStatementList());
                    printStatementAnalyzer.analyze();
                }
            } 
            // EXPRESSION STATEMENT
            else if(stmtCtx.expressionStatement() != null){
                ExpressionStatementContext expStmtCtx = stmtCtx.expressionStatement();
                ExprStmtAnalyzer expStmtAnalyzer = new ExprStmtAnalyzer(expStmtCtx);
                expStmtAnalyzer.analyze();
            } 
            // SELECTION STATEMENT
            else if(stmtCtx.selectionStatement() != null){
                SelectionStatementContext selectStmtCtx = stmtCtx.selectionStatement();
                SelectionAnalyzer selectionAnalyzer = new SelectionAnalyzer(selectStmtCtx);
                selectionAnalyzer.analyze();
            } 
            // ITERATION STATEMENT
            else if(stmtCtx.iterationStatement() != null){
                System.out.println("Enter iteration statement");
                IterationAnalyzer iterationAnalyzer = new IterationAnalyzer(stmtCtx.iterationStatement());
                iterationAnalyzer.analyze();
            } 
            // RETURN STATEMENT
            else if(stmtCtx.returnStatement() != null){
                if(FuncReturnTracker.getInstance().getCurFunction() != null && GlobalScopeManager.getInstance().getCurrentScope().getParent() == null){
                    FuncReturnTracker.getInstance().setFuncReturned(true);

                    if(FuncReturnTracker.getInstance().getCurFunction().getReturnType() == FunctionType.VOID_TYPE) {
                        Console.log(String.valueOf(stmtCtx.getStart().getLine()), "Found a return value for this void function.");
                    }
                } else {
                    CstmFunction currFunc = FuncReturnTracker.getInstance().getCurFunction();
                    ReturnCommand returnCmd = new ReturnCommand(stmtCtx.returnStatement().simpleExpression(), currFunc);

                    StmtCmdTracker stmtCmdTracker = StmtCmdTracker.getInstance();

                    if (stmtCmdTracker.isSelectionCommand()) {
                        SelectCommandInterface ifCommand = (SelectCommandInterface) stmtCmdTracker.getActiveCommand();

                        if (stmtCmdTracker.isInsideIf()) {
                            ifCommand.addIfCommand(returnCmd);
                        } else {
                            ifCommand.addElseCommand(returnCmd);
                        } 

                    } else if (stmtCmdTracker.isIterationCommand()) {
                        IterCommandInterface iterationCommand = (IterCommandInterface) stmtCmdTracker.getActiveCommand();
                        iterationCommand.addCommand(returnCmd);
                    }  else {
                        ExecutionManager.getInstance().addCommand(returnCmd);
                    }

                    CstmUnDecChecker undecChecker = new CstmUnDecChecker(stmtCtx.returnStatement().simpleExpression());
                    undecChecker.verify();
                }
            }
        } else if(ctx instanceof SelectionStatementContext){
            SelectionStatementContext selectStmtCtx = (SelectionStatementContext) ctx;
            SelectionAnalyzer selectionAnalyzer = new SelectionAnalyzer(selectStmtCtx);
            selectionAnalyzer.analyze();
        }
	}

}
