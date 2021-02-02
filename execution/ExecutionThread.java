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
        System.out.println("Execution Started. Command Count: " + commandList.size());
        index = 0;
        while(index < commandList.size()){
            if (this.isRunning) {
                System.out.println("Executing " + commandList.get(index).getClass());
                commandList.get(index).execute();
                index++;
            }
        }
        ExecutionManager.getInstance().stopExecution();
        System.out.println("Execution Ended.");
    }

    public boolean getRunStatus(){
        return this.isRunning;
    }

    public void pauseRunning(){
        this.isRunning = false;
        System.out.println("Thread has been paused.");
    }

    public void resumeRunning(){
        this.isRunning = true;
        System.out.println("Thread has resumed.");
    }
    
    public void stopThread(){
        this.index = commandList.size();
        System.out.println("Thread has been stopped.");
    }
}
