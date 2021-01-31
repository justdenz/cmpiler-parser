package execution.commands;

import console.ScanWindow;
import console.Printer;
import execution.ExecutionManager;
import javafx.application.Platform;
import semantics.representations.CstmValue;
import semantics.symboltable.GlobalScopeManager;
import semantics.symboltable.scopes.CstmLocalScope;

public class ScanCommand implements CommandInterface {

    private String varName;
    private String scanPrompt;
    private CstmLocalScope cstmScope;

    public ScanCommand(String varName, String scanPrompt){
        this.varName = varName;
        this.scanPrompt = scanPrompt.replaceAll("^\"+|\"+$", "");
        this.cstmScope = GlobalScopeManager.getInstance().getCurrentScope();
    }
    
    @Override
    public void execute() {
        ExecutionManager.getInstance().pauseThread();

        Platform.runLater(new Runnable() {
            @Override public void run() {
                String scanValue = ScanWindow.getInstance().getInput(scanPrompt);
                CstmValue value = cstmScope.getVariableWithinScope(varName);

                try {
                    switch(value.getPrimitiveType()) {
                        case INT: value.setValue(Integer.valueOf(scanValue));
                        case FLOAT: value.setValue(Float.valueOf(scanValue));
                        case BOOLEAN: value.setValue(Boolean.valueOf(scanValue));
                        case STRING: value.setValue(scanValue.replaceAll("^\"+|\"+$", ""));
                        default: value.setValue(scanValue);
                    }
                    ExecutionManager.getInstance().resumeThread();;
                    System.out.println("Ito yung value ni variable "+varName+" : "+value.getValue().toString());
                } catch (NumberFormatException e) {
                    Printer.getInstance().display("Program Terminated. Scan value mismatch.");
                    ExecutionManager.getInstance().resetCommands();;
                }
            }
        });
    }
}
