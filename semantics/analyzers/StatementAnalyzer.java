package semantics.analyzers;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import model.CUSTOMParser.CompoundStatementContext;
import model.CUSTOMParser.SelectionStatementContext;
import model.CUSTOMParser.StatementContext;

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
                System.out.println("Found selection statement");
            } else if(stmtCtx.iterationStatement() != null){
                // IterationAnalyzer (for and while loop)
            } else if(stmtCtx.returnStatement() != null){
                // ReturnAnalyzer
            }
        }
	}

}
