package semantics.analyzers;

import java.util.List;

import builder.errorcheckers.CstmParamChecker;
import builder.errorcheckers.CstmUnDecChecker;
import model.CUSTOMParser.ArgsContext;
import model.CUSTOMParser.CallContext;
import model.CUSTOMParser.ExperssionStandAloneContext;
import model.CUSTOMParser.SimpleExpressionContext;
import model.CUSTOMParser.ExpressionStatementContext;
import semantics.representations.CstmFunction;
import semantics.symboltable.GlobalScopeManager;

public class ExpressionStatementAnalyzer {
    public void analyze(ExpressionStatementContext ctx){
        if(ctx.experssionStandAlone() != null){
            
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
