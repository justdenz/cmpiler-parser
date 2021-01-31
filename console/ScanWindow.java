package console;

import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import view.MainGUI;

public class ScanWindow {
    private static ScanWindow scannerInstance = null;

    public ScanWindow() {
    }

    public static ScanWindow getInstance(){
        if(scannerInstance == null){
            scannerInstance = new ScanWindow();
        }
        return scannerInstance;
    }

    public String getInput(String prompt) {

        TextInputDialog td = new TextInputDialog(); 
        td.getDialogPane().lookupButton(ButtonType.CANCEL).setVisible(false);
        td.getDialogPane().lookupButton(ButtonType.CANCEL).setManaged(false);
        td.setHeaderText(prompt);
        td.showAndWait(); 
    
        return td.getEditor().getText(); 
    }
}
