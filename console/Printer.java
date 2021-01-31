package console;

import view.MainGUI;

public class Printer {
  private static Printer printerInstance = null;

  public Printer() {
  }

  public static Printer getInstance(){
    if(printerInstance == null){
      printerInstance = new Printer();
    }
    return printerInstance;
  }

  public void display(String output) {
    MainGUI.terminalPane.getTerminalArea().setText(this.getTerminalContent() + output);
  }

  public static void clearTerminal(){
    MainGUI.terminalPane.getTerminalArea().clear();
  }

  public String getTerminalContent(){
    return MainGUI.terminalPane.getTerminalArea().getText();
  }
}
