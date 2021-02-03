package semantics.analyzers;

import console.Console;
import execution.ExecutionManager;
import execution.StmtCmdTracker;
import execution.commands.ArrayCreateCommand;
import execution.commands.AssignmentCommand;
import execution.commands.FuncCallCommand;
import execution.commands.IterCommandInterface;
import execution.commands.SelectCommandInterface;
import builder.errorcheckers.CstmConstChecker;
import builder.errorcheckers.CstmTypeChecker;
import model.CUSTOMParser.ArgsContext;
import model.CUSTOMParser.CallContext;
import model.CUSTOMParser.ExperssionStandAloneContext;
import model.CUSTOMParser.TypeSpecifierContext;
import model.CUSTOMParser.ExpressionStatementContext;
import model.CUSTOMParser.MutableContext;
import semantics.representations.CstmArray;
import semantics.representations.CstmFunction;
import semantics.representations.CstmValue;
import semantics.representations.CstmValue.PrimitiveType;
import semantics.symboltable.GlobalScopeManager;
import semantics.utils.CstmKeywords;

public class ExprStmtAnalyzer implements AnalyzerInterface{

		private ExpressionStatementContext ctx;

		public ExprStmtAnalyzer(ExpressionStatementContext ctx){
			this.ctx = ctx;
		}

		@Override
    public void analyze(){
			if(ctx.experssionStandAlone() != null){
				ExperssionStandAloneContext exprStdAlneCtx = ctx.experssionStandAlone();
				MutableContext mutableCtx = exprStdAlneCtx.mutable(); //left hand side
				
				CstmConstChecker constChecker = new CstmConstChecker(mutableCtx.IDENTIFIER());
				constChecker.verify();

				CstmValue cstmValue = GlobalScopeManager.getInstance().searchScopedVariable(mutableCtx.IDENTIFIER().getText());

				if (exprStdAlneCtx.simpleExpression() != null ) { // if right hand side is simple expression
					if (cstmValue != null) {
						AssignmentCommand assignmentCommand = new AssignmentCommand(mutableCtx, exprStdAlneCtx.simpleExpression());

						if(StmtCmdTracker.getInstance().isSelectionCommand()){
							SelectCommandInterface selectCmd = (SelectCommandInterface) StmtCmdTracker.getInstance().getActiveCommand();
	
							if(StmtCmdTracker.getInstance().isInsideIf()){
								selectCmd.addIfCommand(assignmentCommand);
							} else {
								selectCmd.addElseCommand(assignmentCommand);
							}
						} else if(StmtCmdTracker.getInstance().isIterationCommand()){
							IterCommandInterface iterCmd = (IterCommandInterface) StmtCmdTracker.getInstance().getActiveCommand();
							iterCmd.addCommand(assignmentCommand);
						} else {
							ExecutionManager.getInstance().addCommand(assignmentCommand);
						}
						
					} else {
						Console.log(String.valueOf(exprStdAlneCtx.getStart().getLine()) , "Found an undecalred variable.");
					}
				} else if (exprStdAlneCtx.arrayExpression() != null) {
					if (cstmValue.getPrimitiveType() != PrimitiveType.ARRAY) {
						Console.log(String.valueOf(exprStdAlneCtx.getStart().getLine()), "Identifier is not an array");
					} else {
						TypeSpecifierContext typeSpecifier = exprStdAlneCtx.arrayExpression().typeSpecifier();
						CstmArray cstmArray = (CstmArray) cstmValue.getValue();
		
						if ((cstmArray.getPrimitiveType() == PrimitiveType.INT && typeSpecifier.Int() == null) || 
							(cstmArray.getPrimitiveType() == PrimitiveType.STRING && typeSpecifier.String() == null) || 
							(cstmArray.getPrimitiveType() == PrimitiveType.BOOLEAN && typeSpecifier.Boolean() == null) ||
							(cstmArray.getPrimitiveType() == PrimitiveType.FLOAT && typeSpecifier.Float() == null) ) {
							Console.log(String.valueOf(exprStdAlneCtx.getStart().getLine()) , "Found a mismatch type.");
						}	 

						CstmValue tempVal = new CstmValue(null, CstmKeywords.IS_INT);
						CstmTypeChecker typeChecker = new CstmTypeChecker(tempVal, exprStdAlneCtx.arrayExpression().simpleExpression());
						typeChecker.verify();

						ArrayCreateCommand arrCreateCmd = new ArrayCreateCommand(cstmArray, exprStdAlneCtx.arrayExpression().simpleExpression());
						
						if(StmtCmdTracker.getInstance().isSelectionCommand()){
							SelectCommandInterface selectCmd = (SelectCommandInterface) StmtCmdTracker.getInstance().getActiveCommand();

							if(StmtCmdTracker.getInstance().isInsideIf()){
								selectCmd.addIfCommand(arrCreateCmd);
							} else {
								selectCmd.addElseCommand(arrCreateCmd);
							}
						} else if(StmtCmdTracker.getInstance().isIterationCommand()){
							IterCommandInterface iterCmd = (IterCommandInterface) StmtCmdTracker.getInstance().getActiveCommand();
							iterCmd.addCommand(arrCreateCmd);
						} else {
							ExecutionManager.getInstance().addCommand(arrCreateCmd);
						}
					}
				}
			} 
			else if(ctx.call() != null){
				CallContext callCtx = ctx.call();

				String functionName = callCtx.IDENTIFIER().getText();
				CstmFunction cstmFunc = GlobalScopeManager.getInstance().getFunction(functionName);

				if(cstmFunc != null){
					FuncCallAnalyzer functionCallAnalyzer = new FuncCallAnalyzer(callCtx);
					functionCallAnalyzer.analyze(); 

					ArgsContext callArgsCtx = callCtx.args();
					FuncCallCommand funcCmd = new FuncCallCommand(cstmFunc, callArgsCtx);
					
					if(StmtCmdTracker.getInstance().isSelectionCommand()){
						SelectCommandInterface selectCmd = (SelectCommandInterface) StmtCmdTracker.getInstance().getActiveCommand();

						if(StmtCmdTracker.getInstance().isInsideIf()){
							selectCmd.addIfCommand(funcCmd);
						} else {
							selectCmd.addElseCommand(funcCmd);
						}
					} else if(StmtCmdTracker.getInstance().isIterationCommand()){
						IterCommandInterface iterCmd = (IterCommandInterface) StmtCmdTracker.getInstance().getActiveCommand();
						iterCmd.addCommand(funcCmd);
					} else {
						ExecutionManager.getInstance().addCommand(funcCmd);
					}
					
				} else {
					Console.log(String.valueOf(callCtx.getStart().getLine()), "Found an undeclared function.");
				}
			}
		}
}
