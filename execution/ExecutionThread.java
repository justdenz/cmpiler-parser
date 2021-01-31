package execution;

import java.util.ArrayList;

import console.Console;
import execution.commands.CommandInterface;

public class ExecutionThread extends Thread{

    private ArrayList<CommandInterface> commandList = new ArrayList<CommandInterface>();
    private volatile boolean isRunning; // flag if thread is running or not
    public ExecutionThread(ArrayList<CommandInterface> commandList){
        this.commandList = commandList;
        this.isRunning = true;
    }

    @Override
    public void run(){
        int index = 0;
        while(index < commandList.size()){
            if (this.isRunning) {
                commandList.get(index).execute();
                index++;
            }
        }
    }

    public void pauseRunning(){
        this.isRunning = false;
    }

    public void resumeRunning(){
        this.isRunning = true;
        System.out.println("Thread has been resumed.");
    }
    
}
