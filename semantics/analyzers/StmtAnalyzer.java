package semantics.analyzers;

import org.antlr.v4.runtime.ParserRuleContext;

import console.Console;
import builder.errorcheckers.CstmUnDecChecker;
import model.CUSTOMParser.CompoundStatementContext;
import model.CUSTOMParser.ForDeclarationContext;
import model.CUSTOMParser.ForExpressionContext;
import model.CUSTOMParser.ForStatementContext;
import model.CUSTOMParser.ExpressionStatementContext;
import model.CUSTOMParser.PrintStatementContext;
import model.CUSTOMParser.ScanStatementContext;
import model.CUSTOMParser.SelectionStatementContext;
import model.CUSTOMParser.StatementContext;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;

public class StmtAnalyzer{
    public StmtAnalyzer() {}
    

	public void analyze(ParserRuleContext ctx) {
        if(ctx instanceof StatementContext){
            StatementContext stmtCtx = (StatementContext) ctx;

            // SCAN STATEMENT
            if (stmtCtx.scanStatement() != null){
                ScanStatementContext scanStatementCtx = stmtCtx.scanStatement();
                if(scanStatementCtx.scanStatementList() != null){
                    String scanStmtIdentifier =  scanStatementCtx.scanStatementList().IDENTIFIER().toString();
                    if(GlobalScopeManager.getInstance().searchScopedVariable(scanStmtIdentifier) == null){
                        Console.log(String.valueOf(scanStatementCtx.getStart().getLine()) , "Variable not yet initialized");
                    }
                }
            } 
            // PRINT STATEMENT
            else if(stmtCtx.printStatement() != null){
                PrintStatementContext printStatementCtx = stmtCtx.printStatement();
                if(printStatementCtx.printStatementList() != null){
                    PrintStmtAnalyzer printStatementAnalyzer = new PrintStmtAnalyzer();
                    printStatementAnalyzer.analyze(printStatementCtx.printStatementList());
                }
            } 
            // EXPRESSION STATEMENT
            else if(stmtCtx.expressionStatement() != null){
                ExpressionStatementContext expStmtCtx = stmtCtx.expressionStatement();
                ExprStmtAnalyzer expStmtAnalyzer = new ExprStmtAnalyzer();
                expStmtAnalyzer.analyze(expStmtCtx);
            } 
            // COMPOUND STATEMENT
            else if(stmtCtx.compoundStatement() != null){
                CompoundStatementContext compoundCtx = stmtCtx.compoundStatement();
                if(compoundCtx.compoundStatementList() != null){
                    CompStmtAnalyzer compoundStmtAnalyzer = new CompStmtAnalyzer();
                    compoundStmtAnalyzer.analyze(compoundCtx);
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

                CompStmtAnalyzer compoundStatementAnalyzer = new CompStmtAnalyzer();
                compoundStatementAnalyzer.analyze(selectStmtCtx.compoundStatement());

                if(selectStmtCtx.elseStatement() != null){
                    if(selectStmtCtx.elseStatement().compoundStatement() != null){
                        CstmLocalScope elseScope = new CstmLocalScope(GlobalScopeManager.getInstance().getCurrentScope());
                        GlobalScopeManager.getInstance().setCurrentScope(elseScope);
                        System.out.println("Opened else scope");
                        CompStmtAnalyzer elseStatementAnalyzer = new CompStmtAnalyzer();
                        elseStatementAnalyzer.analyze(selectStmtCtx.elseStatement().compoundStatement());
                    } else {
                        StmtAnalyzer stmtAnalyzer = new StmtAnalyzer();
                        stmtAnalyzer.analyze(selectStmtCtx.elseStatement().selectionStatement());
                    }
                    
                } 
            } 
            // ITERATION STATEMENT
            else if(stmtCtx.iterationStatement() != null){
                // IterationAnalyzer (for and while loop)
                System.out.println("Enter iteration statement");
                IterationAnalyzer iterationAnalyzer = new IterationAnalyzer();
                iterationAnalyzer.analyze(stmtCtx);
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

            CompStmtAnalyzer compoundStatementAnalyzer = new CompStmtAnalyzer();
            compoundStatementAnalyzer.analyze(selectStmtCtx.compoundStatement());

            if(selectStmtCtx.elseStatement() != null){
                if(selectStmtCtx.elseStatement().compoundStatement() != null){
                    CstmLocalScope elseScope = new CstmLocalScope(GlobalScopeManager.getInstance().getCurrentScope());
                    GlobalScopeManager.getInstance().setCurrentScope(elseScope);
                    System.out.println("Opened else scope");
                    CompStmtAnalyzer elseStatementAnalyzer = new CompStmtAnalyzer();
                    elseStatementAnalyzer.analyze(selectStmtCtx.elseStatement().compoundStatement());
                } else {
                    StmtAnalyzer stmtAnalyzer = new StmtAnalyzer();
                    stmtAnalyzer.analyze(selectStmtCtx.elseStatement().selectionStatement());
                }
                
            } 
        }
	}

}
