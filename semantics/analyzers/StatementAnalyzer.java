package semantics.analyzers;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import model.CUSTOMParser.CompoundStatementContext;
import model.CUSTOMParser.StatementContext;

public class StatementAnalyzer implements ParseTreeListener{
    public StatementAnalyzer() {}
    
    public void analyze(StatementContext ctx){
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(this, ctx);
    }

    @Override
	public void enterEveryRule(ParserRuleContext ctx) {
        if(ctx instanceof StatementContext){
            StatementContext stmtCtx = (StatementContext) ctx;

            if (stmtCtx.scanStatement() != null){
                // ScanAnalyzer
            } else if(stmtCtx.printStatement() != null){
                // PrintAnalyzer
            } else if(stmtCtx.expressionStatement() != null){
                // ExpressionAnalyzer
            } else if(stmtCtx.compoundStatement() != null){
                CompoundStatementContext compoundCtx = (CompoundStatementContext) ctx;
                if(compoundCtx.compoundStatementList() != null){
                    CompoundStatementAnalyzer compoundStmtAnalyzer = new CompoundStatementAnalyzer();
                    compoundStmtAnalyzer.analyze(compoundCtx);
                }
            } else if(stmtCtx.selectionStatement() != null){
                // SelectionAnalyzer (if-elseif-else conditions)
            } else if(stmtCtx.iterationStatement() != null){
                // IterationAnalyzer (for and while loop)
            } else if(stmtCtx.returnStatement() != null){
                // ReturnAnalyzer
            }
        }
	}

    @Override
	public void exitEveryRule(ParserRuleContext ctx) {
		// TODO Auto-generated method stub
		
	}

    @Override
	public void visitTerminal(TerminalNode node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitErrorNode(ErrorNode node) {
		// TODO Auto-generated method stub
		
	}
    
}
