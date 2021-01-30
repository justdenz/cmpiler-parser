package console;

import components.TerminalPane;

public class Printer {
  private static TerminalPane terminalPane = new TerminalPane();
  private static Printer printerInstance = null;

  public static void createPrinterInstance(){
    if(printerInstance == null){
      printerInstance = new Printer();
    }
  }

  public static void initialize() {
    createPrinterInstance();
  }

  public static void display(String output) {
    terminalPane.getConsole().setText(output);
  }

  public static void clearTerminal(){
    terminalPane.getConsole().clear();
  }
}
