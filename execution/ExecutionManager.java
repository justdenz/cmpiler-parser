package execution;

import java.util.ArrayList;

import execution.commands.CommandInterface;
import semantics.representations.CstmFunction;
import semantics.symboltable.GlobalScopeManager;

public class ExecutionManager {
    private static ExecutionManager sharedInstance = null;
    private static ArrayList<CommandInterface> commandList;
    private ExecutionThread executionThread;
    private CstmFunction currFunc;

    public ExecutionManager(){
        this.currFunc = new CstmFunction();
    }

    public static ExecutionManager getInstance(){
        if(sharedInstance == null){
            sharedInstance = new ExecutionManager();
            commandList = new ArrayList<CommandInterface>();
            System.out.println("Execution Manager initialized");
        }
        return sharedInstance;
    }

    public void runAllCommands(){
        this.executionThread = new ExecutionThread(commandList);
        this.executionThread.start();
    }

    public void resetCommands(){
        if(commandList != null){
            commandList.clear();
            System.out.println("Execution was reset");
        }
    }

    public void addCommand(CommandInterface command){
        if(GlobalScopeManager.getInstance().getIsInFunction()){
            this.setFunction();
            currFunc.addCommand(command);
            System.out.println("Added " + command.getClass() + " to function command list");
        } else {
            commandList.add(command);
            System.out.println("Added " + command.getClass() + " to main command list");
        }
    }

    public boolean isRunning(){
        return this.executionThread.getRunStatus();
    }

    public void pauseThread(){
        this.executionThread.pauseRunning();
    }

    public void resumeThread(){
        this.executionThread.resumeRunning();
    }

    public void stopExecution(){
        this.executionThread.stopThread();
    }

    public void setFunction(){
        String currFuncName = GlobalScopeManager.getInstance().getCurrentFunctionName();
        this.currFunc = GlobalScopeManager.getInstance().getFunction(currFuncName);
    }

    public void resetFunction(){
        this.currFunc = new CstmFunction();
    }
}
