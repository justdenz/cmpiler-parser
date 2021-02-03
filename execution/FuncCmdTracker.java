package execution;

import java.util.Stack;

import semantics.representations.CstmFunction;

public class FuncCmdTracker {
  
  private static FuncCmdTracker sharedInstance = null;
  private Stack<CstmFunction> stack;

  public FuncCmdTracker(){
    this.stack = new Stack<CstmFunction>();
  }

  public static FuncCmdTracker getInstance(){
    if(sharedInstance == null){
      sharedInstance = new FuncCmdTracker();
      System.out.println("Function Command Tracker initialized.");
    }
    return sharedInstance;
  }

  public void reset(){
    sharedInstance = null;
  }

  public void openFunction(CstmFunction cstmFunction){
    this.stack.push(cstmFunction);
  }

  public void closeFunction(){
    this.stack.pop();
  }

  public CstmFunction getCurrentFunc(){
    return this.stack.peek();
  }

  public boolean isInsideFunction(){
    return this.stack.size() != 0;
  }
}
