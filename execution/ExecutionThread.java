package execution;

import java.util.ArrayList;

import console.Console;
import execution.commands.CommandInterface;

public class ExecutionThread extends Thread{

    private ArrayList<CommandInterface> commandList = new ArrayList<CommandInterface>();
    private volatile boolean isRunning; // flag if thread is running or not
    private int index;
    public ExecutionThread(ArrayList<CommandInterface> commandList){
        this.commandList = commandList;
        this.isRunning = true;
    }

    @Override
    public void run(){
        index = 0;
        while(index < commandList.size()){
            if (this.isRunning) {
                commandList.get(index).execute();
                index++;
            }
        }
        ExecutionManager.getInstance().resetCommands();
    }

    public boolean getRunStatus(){
        return this.isRunning;
    }

    public void pauseRunning(){
        this.isRunning = false;
    }

    public void resumeRunning(){
        this.isRunning = true;
    }
    
    public void stopThread(){
        this.index = commandList.size();
    }
}
