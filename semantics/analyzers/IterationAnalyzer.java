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

			// Int Declaration as Condition
			if(conditionCtx.Int() != null){
				if(GlobalScopeManager.getInstance().searchScopedVariable(conditionCtx.IDENTIFIER().getText()) != null){
					Console.log(String.valueOf(ctx.getStart().getLine()), "Found multiple declaration of variable in for statement");
				} else {
					CstmValue tempVal = new CstmValue(null, CstmKeywords.IS_INT);
					GlobalScopeManager.getInstance().getCurrentScope().addVariable(conditionCtx.IDENTIFIER().getText(), tempVal);
				}
				// if no Int Declaration
				if(conditionCtx.Assign() != null){
					CstmValue tempVal = new CstmValue(null, CstmKeywords.IS_INT);
					CstmTypeChecker typeChecker = new CstmTypeChecker(tempVal, conditionCtx.simpleExpression());
					typeChecker.verify();
				}
			} 
			// Variable as Condition
			else {
				CstmValue cstmValue = GlobalScopeManager.getInstance().searchScopedVariable(conditionCtx.IDENTIFIER().getText());

				if(cstmValue != null){
					if(cstmValue.getPrimitiveType() != PrimitiveType.INT){
						Console.log(String.valueOf(ctx.getStart().getLine()), "Found a type mismatch in for statement");
					}
				} else {
					Console.log(String.valueOf(ctx.getStart().getLine()), "Found an undeclared variable in for statement");
				}

				if(conditionCtx.Assign() != null){
					CstmValue tempVal = new CstmValue(null, CstmKeywords.IS_INT);
					CstmTypeChecker typeChecker = new CstmTypeChecker(tempVal, conditionCtx.simpleExpression());
					typeChecker.verify();
				}
			}

			CstmUnDecChecker undecChecker = new CstmUnDecChecker(forStmtCtx.simpleExpression());
			undecChecker.verify();

			CstmValue tempVal = new CstmValue(null, CstmKeywords.IS_INT);
			CstmTypeChecker typeChecker = new CstmTypeChecker(tempVal, forStmtCtx.simpleExpression());
			typeChecker.verify();

			CstmLocalScope forScope = new CstmLocalScope(GlobalScopeManager.getInstance().getCurrentScope());
			GlobalScopeManager.getInstance().setCurrentScope(forScope);

			System.out.println("Opened For Loop Scope");
			CompStmtAnalyzer whileStatementAnalyzer = new CompStmtAnalyzer(forStmtCtx.compoundStatement());
			whileStatementAnalyzer.analyze();
		} 

		// WHILE STATEMENT
		else if (stmtCtx.iterationStatement().whileStatement() != null){
			
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
			typeChecker.verify();

			CstmLocalScope forScope = new CstmLocalScope(GlobalScopeManager.getInstance().getCurrentScope());
			GlobalScopeManager.getInstance().setCurrentScope(forScope);

			System.out.println("Opened While Loop Scope");
			CompStmtAnalyzer whileStatementAnalyzer = new CompStmtAnalyzer(whileStmtContext.compoundStatement());
			whileStatementAnalyzer.analyze();
		}
	}
}