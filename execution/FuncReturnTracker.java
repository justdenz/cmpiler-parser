package execution;

import semantics.representations.CstmFunction;

public class FuncReturnTracker {
  
  private static FuncReturnTracker sharedInstance = null;
  private CstmFunction currentFunction;
  private boolean hasReturned;

  public FuncReturnTracker(){
    currentFunction = null;
    hasReturned = false;
  }

  public static FuncReturnTracker getInstance(){
    if(sharedInstance == null){
      sharedInstance = new FuncReturnTracker();
    }
    return sharedInstance;
  }

  public void reset(){
    sharedInstance = null;
    hasReturned = false;
    currentFunction = null;
  }

  public CstmFunction getCurFunction(){
    return currentFunction;
  }

  public void setCurFunction(CstmFunction cstmFunction){
    this.currentFunction = cstmFunction;
  }

  public boolean funcHasReturned(){
    return hasReturned;
  }

  public void setFuncReturned(boolean hasReturn){
    this.hasReturned = hasReturn;
  }
}
