package execution.commands;

import model.CUSTOMParser.ExperssionStandAloneContext;
import model.CUSTOMParser.ExpressionContext;
// import builder.errorcheckers.CstmUnDecChecker;
// import builder.errorcheckers.CstmConstChecker;
// import builder.errorcheckers.CstmTypeChecker;
import model.CUSTOMParser.MutableContext;
import model.CUSTOMParser.SimpleExpressionContext;
import semantics.representations.CstmValue;
import semantics.representations.CstmValue.PrimitiveType;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;

public class AssignmentCommand implements CommandInterface{

  private MutableContext leftContext;
  private SimpleExpressionContext righContext;
  private CstmLocalScope scope;
  private EvaluationCommand evalCommand;
  public AssignmentCommand(MutableContext leftContext, SimpleExpressionContext righContext){
    this.leftContext = leftContext;
    this.righContext = righContext;
    this.scope = GlobalScopeManager.getInstance().getCurrentScope();

    this.evalCommand = new EvaluationCommand(righContext, this.scope);

  
  }

  @Override
  public void execute() {
    this.evalCommand.execute();

    CstmValue cstmValue = this.scope.getVariableWithinScope(this.leftContext.getText());

    if(cstmValue != null){
      if(cstmValue.getPrimitiveType() == PrimitiveType.STRING){
        cstmValue.setValue(righContext.getText().replaceAll("\"", ""));
      }else if(cstmValue.getPrimitiveType() == PrimitiveType.INT){
        cstmValue.setValue(this.evalCommand.getResult().intValue());
      }else if(cstmValue.getPrimitiveType() == PrimitiveType.FLOAT){
        cstmValue.setValue(this.evalCommand.getResult().floatValue());
      }
    }
  }  
}
