package execution.commands;

import java.math.BigDecimal;

import builder.errorcheckers.CstmTypeChecker;
import builder.errorcheckers.CstmUnDecChecker;
import console.Printer;
import model.CUSTOMParser.SimpleExpressionContext;
import semantics.representations.CstmFunction;
import semantics.representations.CstmValue;
import semantics.representations.CstmValue.PrimitiveType;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;

public class ReturnCommand implements CommandInterface{

  private SimpleExpressionContext simpleExpCtx;
  private CstmFunction cstmFunc;
  private CstmLocalScope cstmLocalScope;
  private EvaluationCommand evaluationCommand;

  public ReturnCommand(SimpleExpressionContext simpExpCtx, CstmFunction cstmFunc){
    this.simpleExpCtx = simpExpCtx;
    this.cstmFunc = cstmFunc;
    this.cstmLocalScope = GlobalScopeManager.getInstance().getCurrentScope();

    CstmUnDecChecker cstmUnDecChecker = new CstmUnDecChecker(this.simpleExpCtx);
    cstmUnDecChecker.verify();

    CstmValue cstmVal = this.cstmFunc.getReturnValue();
    CstmTypeChecker typeChecker = new CstmTypeChecker(cstmVal, this.simpleExpCtx);
    typeChecker.verify();

    evaluationCommand = new EvaluationCommand(this.simpleExpCtx, this.cstmLocalScope);
  }

	@Override
	public void execute() {
    evaluationCommand.execute();
    CstmValue cstmValue = this.cstmFunc.getReturnValue();
    BigDecimal evalResult = evaluationCommand.getResult();

      if(cstmValue != null){
        if(cstmValue.getPrimitiveType() == PrimitiveType.INT){
            cstmValue.setValue(evalResult.intValue());
        } else if(cstmValue.getPrimitiveType() == PrimitiveType.FLOAT){
            cstmValue.setValue(evalResult.floatValue());
        } else if(cstmValue.getPrimitiveType() == PrimitiveType.STRING){
            cstmValue.setValue(simpleExpCtx.getText().replaceAll("\"", ""));
        } else if(cstmValue.getPrimitiveType() == PrimitiveType.BOOLEAN){
            switch(evalResult.intValue()){
                case 0:
                    cstmValue.setValue(false);
                    break;
                case 1:
                    cstmValue.setValue(true);
                    break;
            }
        }
      }
	}
}
