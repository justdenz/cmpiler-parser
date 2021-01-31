package execution;

import java.util.ArrayList;

import execution.commands.CommandInterface;

public class ExecutionManager {
    private static ExecutionManager sharedInstance = null;
    private ArrayList<CommandInterface> commandList = new ArrayList<CommandInterface>();
    private ExecutionThread executionThread;

    //setter of flag for thread

    public ExecutionManager(){

    }

    public static ExecutionManager getInstance(){
        if(sharedInstance == null){
            sharedInstance = new ExecutionManager();
        }
        return sharedInstance;
    }

    public void runAllCommands(){
        this.executionThread = new ExecutionThread(commandList);
        this.executionThread.run();
    }

    public void resetCommands(){
        this.commandList.clear();
    }

    public void addCommand(CommandInterface command){
        this.commandList.add(command);
    }

}
