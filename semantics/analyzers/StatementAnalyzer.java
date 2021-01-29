package semantics.analyzers;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import console.Console;
import builder.errorcheckers.CstmUnDecChecker;
import model.CUSTOMParser.CompoundStatementContext;
import model.CUSTOMParser.PrintStatementContext;
import model.CUSTOMParser.ScanStatementContext;
import model.CUSTOMParser.SelectionStatementContext;
import model.CUSTOMParser.StatementContext;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;

public class StatementAnalyzer{
    public StatementAnalyzer() {}
    

	public void analyze(ParserRuleContext ctx) {
        if(ctx instanceof StatementContext){
            StatementContext stmtCtx = (StatementContext) ctx;

            if (stmtCtx.scanStatement() != null){
                ScanStatementContext scanStatementCtx = stmtCtx.scanStatement();
                if(scanStatementCtx.scanStatementList() != null){
                    String scanStmtIdentifier =  scanStatementCtx.scanStatementList().IDENTIFIER().toString();
                    if(GlobalScopeManager.getInstance().searchScopedVariable(scanStmtIdentifier) == null){
                        Console.log("Variable not yet initialized.");
                        System.out.println("variable not found");
                    }
                }

            } else if(stmtCtx.printStatement() != null){
                PrintStatementContext printStatementCtx = stmtCtx.printStatement();
                if(printStatementCtx.printStatementList() != null){
                    PrintStatementAnalyzer printStatementAnalyzer = new PrintStatementAnalyzer();
                    printStatementAnalyzer.analyze(printStatementCtx.printStatementList());
                }
            } else if(stmtCtx.expressionStatement() != null){
                // ExpressionAnalyzer
            } else if(stmtCtx.compoundStatement() != null){
                CompoundStatementContext compoundCtx = stmtCtx.compoundStatement();
                if(compoundCtx.compoundStatementList() != null){
                    CompoundStatementAnalyzer compoundStmtAnalyzer = new CompoundStatementAnalyzer();
                    compoundStmtAnalyzer.analyze(compoundCtx);
                }
            } else if(stmtCtx.selectionStatement() != null){
                SelectionStatementContext selectStmtCtx = stmtCtx.selectionStatement();
                // verify the declared variables in condition
                CstmUnDecChecker undecChecker = new CstmUnDecChecker(selectStmtCtx.simpleExpression());
                undecChecker.verify();
                
                CstmLocalScope ifScope = new CstmLocalScope(GlobalScopeManager.getInstance().getCurrentScope());
                GlobalScopeManager.getInstance().setCurrentScope(ifScope);
                System.out.println("Opened if/else if scope");

                CompoundStatementAnalyzer compoundStatementAnalyzer = new CompoundStatementAnalyzer();
                compoundStatementAnalyzer.analyze(selectStmtCtx.compoundStatement());

                if(selectStmtCtx.elseStatement() != null){
                    if(selectStmtCtx.elseStatement().compoundStatement() != null){
                        CstmLocalScope elseScope = new CstmLocalScope(GlobalScopeManager.getInstance().getCurrentScope());
                        GlobalScopeManager.getInstance().setCurrentScope(elseScope);
                        System.out.println("Opened else scope");
                        CompoundStatementAnalyzer elseStatementAnalyzer = new CompoundStatementAnalyzer();
                        elseStatementAnalyzer.analyze(selectStmtCtx.elseStatement().compoundStatement());
                    } else {
                        StatementAnalyzer stmtAnalyzer = new StatementAnalyzer();
                        stmtAnalyzer.analyze(selectStmtCtx.elseStatement().selectionStatement());
                    }
                    
                } 
            } else if(stmtCtx.iterationStatement() != null){
                // IterationAnalyzer (for and while loop)
                IterationAnalyzer iterationAnalyzer = new IterationAnalyzer();
                // iterationAnalyzer.analyze(stmtCtx.iterationStatement());
                System.out.println("Found iteration statement");
            } else if(stmtCtx.returnStatement() != null){
                // ReturnAnalyzer
            }
        }
	}

}
