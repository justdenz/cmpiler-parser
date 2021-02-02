package execution;

import java.util.Stack;

import execution.commands.CommandInterface;
import execution.commands.IterCommandInterface;
import execution.commands.SelectCommandInterface;

public class StmtCmdTracker {
  
  private static StmtCmdTracker instance = null;
  private Stack<CommandInterface> stackCmd;
  private CommandInterface activeCommand = null;
  private boolean isInIf;

  public StmtCmdTracker(){
    this.stackCmd = new Stack<CommandInterface>();
  }

  public static StmtCmdTracker getInstance(){
    if(instance == null) {
      instance = new StmtCmdTracker();
      System.out.println("Statement Command Tracker initialized");
    }
    return instance;
  }

  public static void reset(){
    instance = null;
    instance.stackCmd.clear();
    instance.activeCommand = null;
  }

  public boolean isInsideIf(){
    return isInIf;
  }

  public void exitIfCommand(){
    this.isInIf = false;
  }

  public void openSelectionCommand(SelectCommandInterface command){
    if(!this.stackCmd.isEmpty()){
      this.addCommand(command);
    } else {
      this.activeCommand = command;
      this.stackCmd.push(command);
    }
    this.isInIf = true;
  }

  public void openIterationCommand(IterCommandInterface command){
    this.stackCmd.push(command);
    this.activeCommand = command;
  }

  public void closeIterationCommand(){
    if(this.stackCmd.size() == 1){
      ExecutionManager.getInstance().addCommand(this.stackCmd.pop());
      this.activeCommand = null;
    } 
    else if(this.stackCmd.size() > 1){
      CommandInterface childCmd = this.stackCmd.pop();
      CommandInterface parentCmd = this.stackCmd.peek();
      this.activeCommand = parentCmd;

      if(parentCmd instanceof IterCommandInterface){
        IterCommandInterface iterCmd = (IterCommandInterface) parentCmd;
        iterCmd.addCommand(childCmd);
      }
    }
  }

  public void addCommand(CommandInterface command){
    if(this.isSelectionCommand()){
      SelectCommandInterface selectCmd = (SelectCommandInterface) this.activeCommand;

      if(this.isInIf){
        selectCmd.addIfCommand(command);
      } else {
        selectCmd.addElseCommand(command);
      }

    } else {
      IterCommandInterface iterCmd = (IterCommandInterface) this.activeCommand;
      iterCmd.addCommand(command);
    }

    this.activeCommand = command;
    this.stackCmd.push(command);
  }

  public boolean isIterationCommand(){
    return (this.activeCommand != null && this.activeCommand instanceof IterCommandInterface);
  }

  public boolean isSelectionCommand(){
    return (this.activeCommand != null && this.activeCommand instanceof SelectCommandInterface);
  }

  public CommandInterface getActiveCommand(){
    return this.activeCommand;
  }
}
