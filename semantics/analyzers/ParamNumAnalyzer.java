package semantics.analyzers;

import java.util.List;

import console.Console;
import model.CUSTOMParser.ArgsContext;
import model.CUSTOMParser.SimpleExpressionContext;
import semantics.representations.CstmFunction;

public class ParamNumAnalyzer implements AnalyzerInterface{
  
  private CstmFunction function;
  private int lineNumber;
  private List<SimpleExpressionContext> exprCtxList;
 

  public ParamNumAnalyzer(CstmFunction function, ArgsContext argsCtx){
    this.function = function;
    this.lineNumber = argsCtx.getStart().getLine();
    if(argsCtx.simpleExpression() != null){
      this.exprCtxList = argsCtx.simpleExpression();
    }
  }

  @Override
  public void analyze(){
    if(this.exprCtxList == null && this.function.getParameterCount() != 0){
      Console.log(String.valueOf(this.lineNumber), "Found a paramater count mismatch.");
    } else if(this.exprCtxList == null && this.function.getParameterCount() != this.exprCtxList.size()){
      Console.log(String.valueOf(this.lineNumber), "Found a paramater count mismatch.");
    }
  }
}
