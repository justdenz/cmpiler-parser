package execution;

import java.util.ArrayList;

import execution.commands.CommandInterface;

public class ExecutionManager {
    private static ExecutionManager sharedInstance = null;
    private static ArrayList<CommandInterface> commandList;
    private ExecutionThread executionThread;
    // private CstmFunction currFunc;

    public ExecutionManager(){

    }

    public static ExecutionManager getInstance(){
        if(sharedInstance == null){
            sharedInstance = new ExecutionManager();
            commandList = new ArrayList<CommandInterface>();
            // this.currFunc = null;
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
        System.out.println("Added " + command.getClass() + " to command list");
        // if may currentFunction sa GlobalScopeManager
            // 1. this.currFunc = new CstmFunction()
            // 2. this.currFunc = GlobalScopeManager.getFunction(currentFunction);
            // 3. this.currFunc.functionCommandList.add(command)
        // else
            commandList.add(command);
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

}
