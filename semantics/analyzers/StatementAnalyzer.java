package semantics.analyzers;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import builder.errorcheckers.CstmUnDecChecker;
import builder.errorcheckers.CstmUnDecChecker;
import model.CUSTOMParser.CompoundStatementContext;
import model.CUSTOMParser.SelectionStatementContext;
import model.CUSTOMParser.StatementContext;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;

public class StatementAnalyzer{
    public StatementAnalyzer() {}
    

	public void analyze(StatementContext ctx) {
        if(ctx instanceof StatementContext){
            StatementContext stmtCtx = (StatementContext) ctx;

            if (stmtCtx.scanStatement() != null){
                // ScanAnalyzer
            } else if(stmtCtx.printStatement() != null){
                // PrintAnalyzer
            } else if(stmtCtx.expressionStatement() != null){
                // ExpressionAnalyzer
            } else if(stmtCtx.compoundStatement() != null){
                CompoundStatementContext compoundCtx = ctx.compoundStatement();
                if(compoundCtx.compoundStatementList() != null){
                    CompoundStatementAnalyzer compoundStmtAnalyzer = new CompoundStatementAnalyzer();
                    compoundStmtAnalyzer.analyze(compoundCtx);
                }
            } else if(stmtCtx.selectionStatement() != null){
                // SelectionAnalyzer (if-elseif-else conditions)
                SelectionStatementContext selectionStatementContext = ctx.selectionStatement();
                
                if(selectionStatementContext.selectionDeclaration() != null){
                    System.out.println("Found If Statement");
                    GlobalScopeManager.getInstance().setCurrentScope(GlobalScopeManager.getInstance().getCurrentScope());
                    CstmUnDecChecker undecChecker = new CstmUnDecChecker(selectionStatementContext.selectionDeclaration().simpleExpression());
                    undecChecker.verify();

                    CompoundStatementAnalyzer compoundStatementAnalyzer = new CompoundStatementAnalyzer();
                    compoundStatementAnalyzer.analyze(selectionStatementContext.compoundStatement());
                }

                //else if statement
                if(selectionStatementContext.elseStatement() != null){
                    if(selectionStatementContext.elseStatement().selectionStatement() != null){
                        System.out.println("Found else if!");
                        GlobalScopeManager.getInstance().setCurrentScope(GlobalScopeManager.getInstance().getCurrentScope());
                        CstmUnDecChecker undecChecker = new CstmUnDecChecker(selectionStatementContext.elseStatement().selectionStatement().selectionDeclaration().simpleExpression());
                        undecChecker.verify();

                        CompoundStatementAnalyzer compoundStatementAnalyzer = new CompoundStatementAnalyzer();
                        compoundStatementAnalyzer.analyze(selectionStatementContext.compoundStatement());
                    }else if(selectionStatementContext.elseStatement().compoundStatement() != null){//else then
                        System.out.println("Found else");
                        GlobalScopeManager.getInstance().setCurrentScope(GlobalScopeManager.getInstance().getCurrentScope());
                        CompoundStatementAnalyzer compoundStatementAnalyzer = new CompoundStatementAnalyzer();
                        compoundStatementAnalyzer.analyze(selectionStatementContext.compoundStatement());
    
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
