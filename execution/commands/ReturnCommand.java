package execution.commands;

import builder.errorcheckers.CstmTypeChecker;
import builder.errorcheckers.CstmUnDecChecker;
import console.Printer;
import model.CUSTOMParser.SimpleExpressionContext;
import semantics.representations.CstmFunction;
import semantics.representations.CstmValue;
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
    CstmTypeChecker typeChecker = new CstmTypeChecker(cstmVal, this.simpleExpCtx);
    typeChecker.verify();

  }

	@Override
	public void execute() {
    EvaluationCommand evaluationCommand = new EvaluationCommand(this.simpleExpCtx, cstmLocalScope);
    evaluationCommand.execute();

    CstmValue cstmValue = this.cstmFunc.getReturnValue();
    Printer.getInstance().display(cstmValue.toString());
	}
  
}
