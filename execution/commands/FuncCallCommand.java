package execution.commands;

import java.util.List;

import builder.errorcheckers.CstmTypeChecker;
import model.CUSTOMParser.ArgsContext;
import model.CUSTOMParser.SimpleExpressionContext;
import semantics.representations.CstmFunction;
import semantics.representations.CstmValue;
import semantics.representations.CstmValue.PrimitiveType;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;

public class FuncCallCommand implements CommandInterface{

  private CstmFunction function;
  private ArgsContext argsCtx;
  private String funcName;
  private CstmLocalScope cstmScope;

  public FuncCallCommand(CstmFunction function, ArgsContext argsCtx){
    this.function = function;
    this.argsCtx = argsCtx;
    this.cstmScope = GlobalScopeManager.getInstance().getCurrentScope();
    
    this.verifyParameters();
  }

  @Override
  public void execute() {
    this.function.execute();
  }

  public void verifyParameters() {
		if(this.argsCtx.simpleExpression().size() == 0) {
			return;
		}
		
		List<SimpleExpressionContext> args = this.argsCtx.simpleExpression();
    
		for(int i = 0; i < args.size(); i++) {
      SimpleExpressionContext simpleExprCtx = args.get(i);
      
			if(this.function.getParameterCount() > i){
        CstmTypeChecker typeChecker = new CstmTypeChecker(this.function.getParameterAt(i), simpleExprCtx);
        typeChecker.verify();
      }
		}	
  }

  public void mapParameters(){
    if(this.argsCtx.simpleExpression().size() == 0){
      return;
    }

    List<SimpleExpressionContext> args = this.argsCtx.simpleExpression();

    for(int i = 0; i < args.size(); i++){
      SimpleExpressionContext simpleExprCtx = args.get(i);

      if(this.function.getParameterAt(i).getPrimitiveType() != PrimitiveType.ARRAY) {
        EvaluationCommand evalCommand = new EvaluationCommand(simpleExprCtx, this.cstmScope);
        evalCommand.execute();

        String result = evalCommand.getResult().toPlainString();

        if(this.function.getParameterCount() > i){
          CstmValue cstmValue = this.function.getParameterAt(i);
          cstmValue.setValue(result);
        }
      } else {
        String identifier = simpleExprCtx.getText();
        CstmValue val = this.cstmScope.getVariableWithinScope(identifier);
        this.function.mapArrayParameter(i, identifier, val);
      }
    }
  }
  

  
}
