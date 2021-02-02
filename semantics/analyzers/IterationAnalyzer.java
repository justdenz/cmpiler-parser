package semantics.analyzers;

import org.antlr.v4.runtime.ParserRuleContext;

import builder.errorcheckers.CstmTypeChecker;
import builder.errorcheckers.CstmUnDecChecker;
import console.Console;
import model.CUSTOMParser.ForConditionContext;
import model.CUSTOMParser.ForStatementContext;
import model.CUSTOMParser.WhileStatementContext;
import semantics.representations.CstmValue;
import semantics.representations.CstmValue.PrimitiveType;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;
import semantics.utils.CstmKeywords;
import model.CUSTOMParser.StatementContext;

public class IterationAnalyzer implements AnalyzerInterface{

	private ParserRuleContext ctx;

	public IterationAnalyzer(ParserRuleContext ctx){
		this.ctx = ctx;
	}

	@Override
	public void analyze() {
		
		StatementContext stmtCtx = (StatementContext) ctx;

		// FOR STATEMENT
		if (stmtCtx.iterationStatement().forStatement() != null){
			ForStatementContext forStmtCtx = stmtCtx.iterationStatement().forStatement();
			ForConditionContext conditionCtx = forStmtCtx.forCondition();

			if(conditionCtx.Int() != null){
				
			}
			
			// if(forExpression != null && forDeclaration != null){
			// 	System.out.println("Opened For Loop Scope");			
			// 	CstmLocalScope forScope = new CstmLocalScope(GlobalScopeManager.getInstance().getCurrentScope());
			// 	GlobalScopeManager.getInstance().setCurrentScope(forScope);
			// 	CompStmtAnalyzer forStatementAnalyzer = new CompStmtAnalyzer(forStmtCtx.compoundStatement());
			// 	forStatementAnalyzer.analyze();
			// } else {
			// 	Console.log(String.valueOf(forStmtCtx.getStart().getLine()), "Missing for loop declarations.");
			// }

		// WHILE STATEMENT
		} else if (stmtCtx.iterationStatement().whileStatement() != null){
			
			WhileStatementContext whileStmtContext = stmtCtx.iterationStatement().whileStatement();
			String whileVar = whileStmtContext.IDENTIFIER().getText();
			CstmValue cstmValue = GlobalScopeManager.getInstance().searchScopedVariable(whileVar);

			if(cstmValue != null){
				if(cstmValue.getPrimitiveType() != PrimitiveType.INT){
					Console.log(String.valueOf(whileStmtContext.getStart().getLine()), "Found type mismatch in while loop declaration.");
				}
			} else {
				Console.log(String.valueOf(whileStmtContext.getStart().getLine()), "Found undeclared variable in while loop declaration.");
			}

			CstmUnDecChecker undecChecker = new CstmUnDecChecker(whileStmtContext.simpleExpression());
			undecChecker.verify();

			CstmValue tempVal = new CstmValue(null, CstmKeywords.IS_INT);
			CstmTypeChecker typeChecker = new CstmTypeChecker(tempVal, whileStmtContext.simpleExpression());

			CstmLocalScope forScope = new CstmLocalScope(GlobalScopeManager.getInstance().getCurrentScope());
			GlobalScopeManager.getInstance().setCurrentScope(forScope);

			System.out.println("Opened While Loop Scope");
			CompStmtAnalyzer whileStatementAnalyzer = new CompStmtAnalyzer(whileStmtContext.compoundStatement());
		}
	}


}
