package semantics.analyzers;

import java.util.List;

import console.Console;
import execution.ExecutionManager;
import execution.commands.AssignmentCommand;
import builder.errorcheckers.CstmConstChecker;
import builder.errorcheckers.CstmParamChecker;
import builder.errorcheckers.CstmTypeChecker;
import builder.errorcheckers.CstmUnDecChecker;
import model.CUSTOMParser.ArgsContext;
import model.CUSTOMParser.CallContext;
import model.CUSTOMParser.ExperssionStandAloneContext;
import model.CUSTOMParser.SimpleExpressionContext;
import model.CUSTOMParser.TypeSpecifierContext;
import model.CUSTOMParser.ExpressionStatementContext;
import model.CUSTOMParser.MutableContext;
import semantics.representations.CstmArray;
import semantics.representations.CstmFunction;
import semantics.representations.CstmValue;
import semantics.representations.CstmValue.PrimitiveType;
import semantics.symboltable.GlobalScopeManager;

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
			
			CstmConstChecker constChecker = new CstmConstChecker(mutableCtx);
			constChecker.verify();
			
			CstmValue cstmValue = GlobalScopeManager.getInstance().searchScopedVariable(mutableCtx.IDENTIFIER().getText());

			if (exprStdAlneCtx.simpleExpression() != null) { // if right hand side is simple expression
				if (cstmValue != null) {
					CstmTypeChecker typeChecker = new CstmTypeChecker(cstmValue, exprStdAlneCtx.simpleExpression());
					typeChecker.verify();
					//put assignment command here
					AssignmentCommand assignmentCommand = new AssignmentCommand(mutableCtx, exprStdAlneCtx.simpleExpression());
					ExecutionManager.getInstance().addCommand(assignmentCommand);
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
				}
			}
        } else if(ctx.call() != null){
            CallContext callCtx = ctx.call();

			String functionName = callCtx.IDENTIFIER().getText();
			CstmFunction cstmFunc = GlobalScopeManager.getInstance().getFunction(functionName);

			ArgsContext callArgsCtx = callCtx.args();

			CstmParamChecker paramChecker = new CstmParamChecker(cstmFunc, callArgsCtx);
			paramChecker.verify();

			// check if the arguments exist
			List<SimpleExpressionContext> callArgsList = callArgsCtx.simpleExpression();
			
			for (SimpleExpressionContext exprCtx : callArgsList) {
				CstmUnDecChecker undeclaredSemCheck = new CstmUnDecChecker(exprCtx);
				undeclaredSemCheck.verify();
			}
        }
    }
}
