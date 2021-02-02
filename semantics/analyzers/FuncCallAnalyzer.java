package semantics.analyzers;

import java.util.List;

import builder.errorcheckers.CstmUnDecChecker;
import execution.commands.FuncCallCommand;
import model.CUSTOMParser.ArgsContext;
import model.CUSTOMParser.CallContext;
import model.CUSTOMParser.SimpleExpressionContext;
import semantics.representations.CstmFunction;
import semantics.symboltable.GlobalScopeManager;

public class FuncCallAnalyzer implements AnalyzerInterface{
  
  private CallContext callCtx;
  private ArgsContext argsCtx;
  private CstmFunction function;
  private String functionCallName;

  public FuncCallAnalyzer(CallContext callCtx){
    this.callCtx = callCtx;
    this.argsCtx = callCtx.args();
    this.functionCallName = callCtx.IDENTIFIER().getText();
    this.function = GlobalScopeManager.getInstance().getFunction(this.functionCallName);
  }

  @Override
  public void analyze(){
    ParamNumAnalyzer paramNumAnalyzer = new ParamNumAnalyzer(this.function, this.argsCtx);
    paramNumAnalyzer.analyze();

    List<SimpleExpressionContext> callArgsList = this.argsCtx.simpleExpression();

    for(SimpleExpressionContext exprCtx : callArgsList){
      CstmUnDecChecker unDecChecker = new CstmUnDecChecker(exprCtx);
      unDecChecker.verify();
    }
    FuncCallCommand functionCallCommand = new FuncCallCommand(this.function, argsCtx);
    functionCallCommand.execute();
  }

}
