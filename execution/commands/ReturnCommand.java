package execution.commands;

import java.math.BigDecimal;

import builder.errorcheckers.CstmTypeChecker;
import builder.errorcheckers.CstmUnDecChecker;
import console.Console;
import console.Printer;
import execution.FuncCmdTracker;
import model.CUSTOMParser.SimpleExpressionContext;
import semantics.representations.CstmFunction;
import semantics.representations.CstmValue;
import semantics.representations.CstmFunction.FunctionType;
import semantics.representations.CstmValue.PrimitiveType;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;

public class ReturnCommand implements CommandInterface{

  private SimpleExpressionContext simpleExpCtx;
  private CstmFunction cstmFunc;
  private CstmLocalScope cstmLocalScope;

  public ReturnCommand(SimpleExpressionContext simpExpCtx, CstmFunction cstmFunc){
    this.simpleExpCtx = simpExpCtx;
    this.cstmFunc = cstmFunc;
    this.cstmLocalScope = GlobalScopeManager.getInstance().getCurrentScope();

    CstmUnDecChecker cstmUnDecChecker = new CstmUnDecChecker(this.simpleExpCtx);
    cstmUnDecChecker.verify();

    CstmValue cstmVal = this.cstmFunc.getReturnValue();

    if(this.cstmFunc.getReturnType() != FunctionType.VOID_TYPE){
      CstmTypeChecker typeChecker = new CstmTypeChecker(cstmVal, this.simpleExpCtx);
      typeChecker.verify();
    } else {
      Console.log(String.valueOf(simpleExpCtx.getStart().getLine()), "Found a return statement in a void type function.");
    }
  }

	@Override
	public void execute() {
    EvaluationCommand evaluationCommand = new EvaluationCommand(this.simpleExpCtx, FuncCmdTracker.getInstance().getCurrentFunc().getFunctionLocalScope());
    evaluationCommand.execute();

    CstmValue cstmValue = FuncCmdTracker.getInstance().getCurrentFunc().getReturnValue();
    BigDecimal evalResult = evaluationCommand.getResult();
    
    if(cstmValue != null){
      if(cstmValue.getPrimitiveType() == PrimitiveType.INT){
          cstmValue.setValue(evalResult.intValue());
      } else if(cstmValue.getPrimitiveType() == PrimitiveType.FLOAT){
          cstmValue.setValue(evalResult.floatValue());
      } else if(cstmValue.getPrimitiveType() == PrimitiveType.BOOLEAN){
          switch(evalResult.intValue()){
              case 0:
                  cstmValue.setValue('F');
                  break;
              case 1:
                  cstmValue.setValue('T');
                  break;
          }
      }
    }
	}
}
