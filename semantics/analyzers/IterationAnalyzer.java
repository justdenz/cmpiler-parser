package semantics.analyzers;

import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

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
			// if(forStmtCtx.forCondition().forDeclaration() == null){
				// Console.log("Empty Declaration");
				// System.out.println("Empty Declaration");
			// }else if (forStmtCtx.forCondition())

			if(forExpression != null && forDeclaration != null){
				System.out.println("Opened For Loop Scope");
				
				CstmLocalScope forScope = new CstmLocalScope(GlobalScopeManager.getInstance().getCurrentScope());
				GlobalScopeManager.getInstance().setCurrentScope(forScope);
				CompStmtAnalyzer forStatementAnalyzer = new CompStmtAnalyzer();
				forStatementAnalyzer.analyze(forStmtCtx.compoundStatement());
			} else {
				System.out.println("For loop declaration is empty.");
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
				System.out.println("While Declaration is empty.");
			}

		}
	}


}
