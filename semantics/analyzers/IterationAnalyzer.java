package semantics.analyzers;

import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import console.Console;
import model.CUSTOMParser.ForDeclarationContext;
import model.CUSTOMParser.ForExpressionContext;
import model.CUSTOMParser.ForStatementContext;
import model.CUSTOMParser.WhileStatementContext;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;
import model.CUSTOMParser.IterationStatementContext;
import model.CUSTOMParser.StatementContext;


public class IterationAnalyzer {

	public IterationAnalyzer(){
	}

	public void analyze (ParserRuleContext ctx) {
		
		StatementContext stmtCtx = (StatementContext) ctx;
		if (stmtCtx.iterationStatement().forStatement() != null){
			ForStatementContext forStmtCtx = stmtCtx.iterationStatement().forStatement();
			ForDeclarationContext forDeclaration = forStmtCtx.forCondition().forDeclaration();
      ForExpressionContext forExpression = forStmtCtx.forCondition().forExpression();
			

			if(forExpression != null && forDeclaration != null){
				System.out.println("Opened For Loop Scope");			
				CstmLocalScope forScope = new CstmLocalScope(GlobalScopeManager.getInstance().getCurrentScope());
				GlobalScopeManager.getInstance().setCurrentScope(forScope);
				CompStmtAnalyzer forStatementAnalyzer = new CompStmtAnalyzer();
				forStatementAnalyzer.analyze(forStmtCtx.compoundStatement());
			} else {
				Console.log(String.valueOf(forStmtCtx.getStart().getLine()), "Missing for loop declarations.");
			}
			
		}else if (stmtCtx.iterationStatement().whileStatement() != null){
			System.out.println("Enterd while loop analyzer");
			WhileStatementContext whileStmtContext = stmtCtx.iterationStatement().whileStatement();
			
			if(whileStmtContext.IDENTIFIER() != null && whileStmtContext.relExpression() != null){
				CstmLocalScope forScope = new CstmLocalScope(GlobalScopeManager.getInstance().getCurrentScope());
				GlobalScopeManager.getInstance().setCurrentScope(forScope);
				System.out.println("Opened While Loop Scope");
				CompStmtAnalyzer whileStatementAnalyzer = new CompStmtAnalyzer();
				whileStatementAnalyzer.analyze(whileStmtContext.compoundStatement());
			} else {
				Console.log(String.valueOf(whileStmtContext.getStart().getLine()), "Missing while loop declarations.");
			}

		}
	}


}
