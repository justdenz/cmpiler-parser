package execution.commands;

import builder.errorcheckers.CstmUnDecChecker;
import model.CUSTOMParser.SimpleExpressionContext;
import semantics.representations.CstmArray;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;

public class ArrayCreateCommand implements CommandInterface{

  private CstmLocalScope cstmLocalScope;
  private SimpleExpressionContext simpleExprCtx;
  private CstmArray cstmArray;
  private EvaluationCommand evalCmd;

  public ArrayCreateCommand(CstmArray cstmArray, SimpleExpressionContext simpleExprCtx){
    this.cstmArray = cstmArray;
    this.simpleExprCtx = simpleExprCtx;
    this.cstmLocalScope = GlobalScopeManager.getInstance().getCurrentScope();

    CstmUnDecChecker unDecChecker = new CstmUnDecChecker(this.simpleExprCtx);
    unDecChecker.verify();

    evalCmd = new EvaluationCommand(this.simpleExprCtx, this.cstmLocalScope);
  }

	@Override
	public void execute() {
    evalCmd.execute();
    this.cstmArray.initializeSize(evalCmd.getResult().intValue());
	}
}