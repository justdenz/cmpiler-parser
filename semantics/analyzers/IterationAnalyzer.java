package semantics.analyzers;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import builder.errorcheckers.CstmConstChecker;
import builder.errorcheckers.CstmTypeChecker;
import builder.errorcheckers.CstmUnDecChecker;
import console.Console;
import execution.ExecutionManager;
import execution.StmtCmdTracker;
import execution.commands.ForCommand;
import execution.commands.IterCommandInterface;
import execution.commands.IterationAssignCommand;
import execution.commands.SelectCommandInterface;
import execution.commands.WhileCommand;
import model.CUSTOMParser.ForConditionContext;
import model.CUSTOMParser.ForStatementContext;
import model.CUSTOMParser.IterationStatementContext;
import model.CUSTOMParser.SimpleExpressionContext;
import model.CUSTOMParser.WhileStatementContext;
import semantics.representations.CstmValue;
import semantics.representations.CstmValue.PrimitiveType;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;
import semantics.utils.CstmKeywords;
import model.CUSTOMParser.StatementContext;

public class IterationAnalyzer implements AnalyzerInterface{

	private IterationStatementContext stmtCtx;

	public IterationAnalyzer(IterationStatementContext ctx){
		this.stmtCtx = ctx;
	}

	@Override
	public void analyze() {

		// FOR STATEMENT
		if (stmtCtx.forStatement() != null){
			ForStatementContext forStmtCtx = stmtCtx.forStatement();
			ForConditionContext conditionCtx = forStmtCtx.forCondition();

			// Int Declaration as Condition
			if(conditionCtx.Int() != null){
				if(GlobalScopeManager.getInstance().searchScopedVariable(conditionCtx.IDENTIFIER().getText()) != null){
					Console.log(String.valueOf(stmtCtx.getStart().getLine()), "Found multiple declaration of variable in for statement");
				} else {
					CstmValue tempVal = new CstmValue(null, CstmKeywords.IS_INT);
					GlobalScopeManager.getInstance().getCurrentScope().addVariable(conditionCtx.IDENTIFIER().getText(), tempVal);
				}
				// if no Int Declaration
				if(conditionCtx.Assign() != null){
					IterationAssignCommand iterAssignCmd = new IterationAssignCommand(conditionCtx.IDENTIFIER(), conditionCtx.simpleExpression());

					if(StmtCmdTracker.getInstance().isSelectionCommand()){
						SelectCommandInterface selectCmd = (SelectCommandInterface) StmtCmdTracker.getInstance().getActiveCommand();

						if(StmtCmdTracker.getInstance().isInsideIf()){
							selectCmd.addIfCommand(iterAssignCmd);
						} else {
							selectCmd.addElseCommand(iterAssignCmd);
						}
					} else if(StmtCmdTracker.getInstance().isIterationCommand()){
						IterCommandInterface iterCmd = (IterCommandInterface) StmtCmdTracker.getInstance().getActiveCommand();
						iterCmd.addCommand(iterAssignCmd);
					} else {
						ExecutionManager.getInstance().addCommand(iterAssignCmd);
					}
				}
			} 
			// Variable as Condition
			else {
				CstmValue cstmValue = GlobalScopeManager.getInstance().searchScopedVariable(conditionCtx.IDENTIFIER().getText());

				if(cstmValue != null){
					if(cstmValue.getPrimitiveType() != PrimitiveType.INT){
						Console.log(String.valueOf(forStmtCtx.getStart().getLine()), "Found a type mismatch in for statement");
					}
				} else {
					Console.log(String.valueOf(stmtCtx.getStart().getLine()), "Found an undeclared variable in for statement");
				}

				if(conditionCtx.Assign() != null){
					IterationAssignCommand iterAssignCmd = new IterationAssignCommand(conditionCtx.IDENTIFIER(), conditionCtx.simpleExpression());

					if(StmtCmdTracker.getInstance().isSelectionCommand()){
						SelectCommandInterface selectCmd = (SelectCommandInterface) StmtCmdTracker.getInstance().getActiveCommand();

						if(StmtCmdTracker.getInstance().isInsideIf()){
							selectCmd.addIfCommand(iterAssignCmd);
						} else {
							selectCmd.addElseCommand(iterAssignCmd);
						}
					} else if(StmtCmdTracker.getInstance().isIterationCommand()){
						IterCommandInterface iterCmd = (IterCommandInterface) StmtCmdTracker.getInstance().getActiveCommand();
						iterCmd.addCommand(iterAssignCmd);
					} else {
						ExecutionManager.getInstance().addCommand(iterAssignCmd);
					}
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
			ForCommand forCommand = new ForCommand(forStmtCtx);
			StmtCmdTracker.getInstance().openIterationCommand(forCommand);

			CompStmtAnalyzer forStatementAnalyzer = new CompStmtAnalyzer(forStmtCtx.compoundStatement());
			forStatementAnalyzer.analyze();
			
			StmtCmdTracker.getInstance().closeIterationCommand();
		} 

		// WHILE STATEMENT
		else if (stmtCtx.whileStatement() != null){
			
			WhileStatementContext whileStmtContext = stmtCtx.whileStatement();
			String whileVar = whileStmtContext.IDENTIFIER().getText();
			CstmValue cstmValue = GlobalScopeManager.getInstance().searchScopedVariable(whileVar);

			if(cstmValue != null){
				if(cstmValue.getPrimitiveType() != PrimitiveType.INT){
					Console.log(String.valueOf(stmtCtx.getStart().getLine()), "Found type mismatch in while loop declaration.");
				}
			} else {
				Console.log(String.valueOf(stmtCtx.getStart().getLine()), "Found undeclared variable in while loop declaration.");
			}

			CstmUnDecChecker undecChecker = new CstmUnDecChecker(whileStmtContext.simpleExpression());
			undecChecker.verify();

			CstmValue tempVal = new CstmValue(null, CstmKeywords.IS_INT);
			CstmTypeChecker typeChecker = new CstmTypeChecker(tempVal, whileStmtContext.simpleExpression());
			typeChecker.verify();

			System.out.println("Opened While Loop Scope");
			WhileCommand whileCommand = new WhileCommand(whileStmtContext);
			StmtCmdTracker.getInstance().openIterationCommand(whileCommand);

			CstmLocalScope whileScope = new CstmLocalScope(GlobalScopeManager.getInstance().getCurrentScope());
			GlobalScopeManager.getInstance().setCurrentScope(whileScope);

			CompStmtAnalyzer whileStatementAnalyzer = new CompStmtAnalyzer(whileStmtContext.compoundStatement());
			whileStatementAnalyzer.analyze();

			StmtCmdTracker.getInstance().closeIterationCommand();
		}
	}
}