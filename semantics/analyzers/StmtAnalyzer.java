package semantics.analyzers;

import org.antlr.v4.runtime.ParserRuleContext;

import console.Console;
import execution.ExecutionManager;
import execution.commands.ScanCommand;
import builder.errorcheckers.CstmUnDecChecker;
import model.CUSTOMParser.CompoundStatementContext;
import model.CUSTOMParser.ExpressionStatementContext;
import model.CUSTOMParser.PrintStatementContext;
import model.CUSTOMParser.ScanStatementContext;
import model.CUSTOMParser.SelectionStatementContext;
import model.CUSTOMParser.StatementContext;
import semantics.representations.CstmValue;
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
                            ExecutionManager.getInstance().addCommand(scanCmd);
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
            // COMPOUND STATEMENT
            else if(stmtCtx.compoundStatement() != null){
                CompoundStatementContext compoundCtx = stmtCtx.compoundStatement();
                if(compoundCtx.compoundStatementList() != null){
                    CompStmtAnalyzer compoundStmtAnalyzer = new CompStmtAnalyzer(compoundCtx);
                    compoundStmtAnalyzer.analyze();
                }
            } 
            // SELECTION STATEMENT
            else if(stmtCtx.selectionStatement() != null){
                SelectionStatementContext selectStmtCtx = stmtCtx.selectionStatement();
                // verify the declared variables in condition
                CstmUnDecChecker undecChecker = new CstmUnDecChecker(selectStmtCtx.simpleExpression());
                undecChecker.verify();
                CstmLocalScope ifScope = new CstmLocalScope(GlobalScopeManager.getInstance().getCurrentScope());
                GlobalScopeManager.getInstance().setCurrentScope(ifScope);
                System.out.println("Opened if/else if scope");

                CompStmtAnalyzer compoundStatementAnalyzer = new CompStmtAnalyzer(selectStmtCtx.compoundStatement());
                compoundStatementAnalyzer.analyze();

                if(selectStmtCtx.elseStatement() != null){
                    if(selectStmtCtx.elseStatement().compoundStatement() != null){
                        CstmLocalScope elseScope = new CstmLocalScope(GlobalScopeManager.getInstance().getCurrentScope());
                        GlobalScopeManager.getInstance().setCurrentScope(elseScope);
                        System.out.println("Opened else scope");
                        CompStmtAnalyzer elseStatementAnalyzer = new CompStmtAnalyzer(selectStmtCtx.elseStatement().compoundStatement());
                        elseStatementAnalyzer.analyze();
                    } else {
                        StmtAnalyzer stmtAnalyzer = new StmtAnalyzer(selectStmtCtx.elseStatement().selectionStatement());
                        stmtAnalyzer.analyze();
                    }
                    
                } 
            } 
            // ITERATION STATEMENT
            else if(stmtCtx.iterationStatement() != null){
                // IterationAnalyzer (for and while loop)
                System.out.println("Enter iteration statement");
                IterationAnalyzer iterationAnalyzer = new IterationAnalyzer(stmtCtx);
                iterationAnalyzer.analyze();
            } 
            // RETURN STATEMENT
            else if(stmtCtx.returnStatement() != null){
                if(stmtCtx.returnStatement().simpleExpression() != null){
                    CstmUnDecChecker unDecChecker = new CstmUnDecChecker(stmtCtx.returnStatement().simpleExpression());
                    unDecChecker.verify();
                }
            }
        } else if(ctx instanceof SelectionStatementContext){
            SelectionStatementContext selectStmtCtx = (SelectionStatementContext) ctx;
            // verify the declared variables in condition
            CstmUnDecChecker undecChecker = new CstmUnDecChecker(selectStmtCtx.simpleExpression());
            undecChecker.verify();
            System.out.println(selectStmtCtx.simpleExpression().getText());
            CstmLocalScope ifScope = new CstmLocalScope(GlobalScopeManager.getInstance().getCurrentScope());
            GlobalScopeManager.getInstance().setCurrentScope(ifScope);
            System.out.println("Opened if/else if scope");

            CompStmtAnalyzer compoundStatementAnalyzer = new CompStmtAnalyzer(selectStmtCtx.compoundStatement());
            compoundStatementAnalyzer.analyze();

            if(selectStmtCtx.elseStatement() != null){
                if(selectStmtCtx.elseStatement().compoundStatement() != null){
                    CstmLocalScope elseScope = new CstmLocalScope(GlobalScopeManager.getInstance().getCurrentScope());
                    GlobalScopeManager.getInstance().setCurrentScope(elseScope);
                    System.out.println("Opened else scope");
                    CompStmtAnalyzer elseStatementAnalyzer = new CompStmtAnalyzer(selectStmtCtx.elseStatement().compoundStatement());
                    elseStatementAnalyzer.analyze();
                } else {
                    StmtAnalyzer stmtAnalyzer = new StmtAnalyzer(selectStmtCtx.elseStatement().selectionStatement());
                    stmtAnalyzer.analyze();
                }
                
            } 
        }
	}

}
