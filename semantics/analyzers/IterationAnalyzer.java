package semantics.analyzers;

import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import model.CUSTOMParser.ForStatementContext;
import model.CUSTOMParser.WhileStatementContext;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;
import model.CUSTOMParser.IterationStatementContext;


public class IterationAnalyzer implements ParseTreeListener{

	public IterationAnalyzer(){
		GlobalScopeManager.getInstance().getCurrentScope();
	}

	public void analyze(IterationStatementContext ctx){
		ParseTreeWalker walker = new ParseTreeWalker();
    walker.walk(this, ctx);
	}

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		if (ctx instanceof ForStatementContext){
			ForStatementContext forStmtCtx = (ForStatementContext) ctx;
			
			// if(forStmtCtx.forCondition().forDeclaration() == null){
				// Console.log("Empty Declaration");
				// System.out.println("Empty Declaration");
			// }else if (forStmtCtx.forCondition())

			if(forStmtCtx.compoundStatement() != null){
				CompoundStatementAnalyzer compoundStatementAnalyzer = new CompoundStatementAnalyzer();
				compoundStatementAnalyzer.analyze(forStmtCtx.compoundStatement());
			}

			CstmLocalScope parentScope = GlobalScopeManager.getInstance().getCurrentScope().getParent();
			GlobalScopeManager.getInstance().setCurrentScope(parentScope);
			
		}else if (ctx instanceof WhileStatementContext){
			WhileStatementContext whileStmtContext = (WhileStatementContext) ctx;
			// if(whileStmtContext.relExpression() == null){
			// }

			if(whileStmtContext.compoundStatement() != null){
				CompoundStatementAnalyzer compoundStatementAnalyzer = new CompoundStatementAnalyzer();
				compoundStatementAnalyzer.analyze(whileStmtContext.compoundStatement());
			}

			CstmLocalScope parentScope = GlobalScopeManager.getInstance().getCurrentScope().getParent();
			GlobalScopeManager.getInstance().setCurrentScope(parentScope);

		}
	}

	@Override
	public void exitEveryRule(ParserRuleContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitErrorNode(ErrorNode arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitTerminal(TerminalNode arg0) {
		// TODO Auto-generated method stub
		
	}

}
