package execution;

import java.util.ArrayList;

import console.Console;
import execution.commands.CommandInterface;

public class ExecutionThread extends Thread{
    private ArrayList<CommandInterface> commandList = new ArrayList<CommandInterface>();

    public ExecutionThread(ArrayList<CommandInterface> commandList){
        this.commandList = commandList;
    }

    @Override
    public void run(){
        for (CommandInterface command : commandList) {
            command.execute();
        }
    }
    
}
