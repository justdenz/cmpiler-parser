package semantics.analyzers;

import org.antlr.v4.runtime.ParserRuleContext;

import console.Console;
import builder.errorcheckers.CstmUnDecChecker;
import model.CUSTOMParser.CompoundStatementContext;
import model.CUSTOMParser.ForDeclarationContext;
import model.CUSTOMParser.ForExpressionContext;
import model.CUSTOMParser.ForStatementContext;
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
                    PrintStatementAnalyzer printStatementAnalyzer = new PrintStatementAnalyzer();
                    printStatementAnalyzer.analyze(printStatementCtx.printStatementList());
                }
            } 
            // EXPRESSION STATEMENT
            else if(stmtCtx.expressionStatement() != null){
                // ExpressionAnalyzer
            } 
            // COMPOUND STATEMENT
            else if(stmtCtx.compoundStatement() != null){
                CompoundStatementContext compoundCtx = stmtCtx.compoundStatement();
                if(compoundCtx.compoundStatementList() != null){
                    CompoundStatementAnalyzer compoundStmtAnalyzer = new CompoundStatementAnalyzer();
                    compoundStmtAnalyzer.analyze(compoundCtx);
                }
            } 
            // SELECTION STATEMENT
            else if(stmtCtx.selectionStatement() != null){
                SelectionStatementContext selectStmtCtx = stmtCtx.selectionStatement();
                // verify the declared variables in condition
                CstmUnDecChecker undecChecker = new CstmUnDecChecker(selectStmtCtx.simpleExpression());
                undecChecker.verify();
                System.out.println(selectStmtCtx.simpleExpression().getText());
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
            } 
            // ITERATION STATEMENT
            else if(stmtCtx.iterationStatement() != null){
                // IterationAnalyzer (for and while loop)
                IterationAnalyzer iterationAnalyzer = new IterationAnalyzer();
                ForDeclarationContext forDeclaration = stmtCtx.iterationStatement().forStatement().forCondition().forDeclaration();
                ForExpressionContext forExpression = stmtCtx.iterationStatement().forStatement().forCondition().forExpression();
                
                if(stmtCtx.iterationStatement().forStatement() != null){
                    if(forExpression != null && forDeclaration != null){
                        
                        CstmLocalScope forScope = new CstmLocalScope(GlobalScopeManager.getInstance().getCurrentScope());
                        GlobalScopeManager.getInstance().setCurrentScope(forScope);
                        System.out.println("Opened For Loop Scope");
                        CompoundStatementAnalyzer forStatementAnalyzer = new CompoundStatementAnalyzer();
                        forStatementAnalyzer.analyze(stmtCtx.iterationStatement().forStatement().compoundStatement());
                    } else {
                        System.out.println("For loop declaration is empty");
                    }
                } else {
                    
                }
                // iterationAnalyzer.analyze(stmtCtx.iterationStatement());
            } 
            // RETURN STATEMENT
            else if(stmtCtx.returnStatement() != null){
                if(stmtCtx.returnStatement().simpleExpression() != null){
                    CstmUnDecChecker unDecChecker = new CstmUnDecChecker(stmtCtx.returnStatement().simpleExpression());
                    unDecChecker.verify();
                }
            }
        }
	}

}
