package execution;

import java.util.ArrayList;

import console.Console;
import execution.commands.CommandInterface;

public class ExecutionThread extends Thread{
    private ArrayList<CommandInterface> commandList = new ArrayList<CommandInterface>();

    // flag object is here
    //make a setter for flag (pause and resume)

    public ExecutionThread(ArrayList<CommandInterface> commandList){
        this.commandList = commandList;
    }

    @Override
    public void run(){
        for (CommandInterface command : commandList) {
            command.execute();
        }
    }

    // make a method to terminate thread agad if may runtime error
    
}
