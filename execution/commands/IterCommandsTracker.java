package execution.commands;

import java.util.Stack;

public class IterCommandsTracker {
  private static IterCommandsTracker iterCommTrackerInstance = null;
  private Stack<CommandInterface> commandStack;
  private boolean posCommand = true;
  
  private static IterCommandsTracker getInstance(){
    return iterCommTrackerInstance;
  }

  private IterCommandsTracker(){
    this.commandStack = new Stack<CommandInterface>();
    getInstance();
  }

  public void peekCommands(){
    
  }

}
