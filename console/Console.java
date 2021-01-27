package console;
import java.util.ArrayList;

import components.TerminalPane;

public class Console {

  private static Console consoleInstance = null;
  private static TerminalPane terminal = new TerminalPane();
  private ArrayList<String> logList;

  private Console() {
    this.logList = new ArrayList<String>();
  }

  public static void getInstance() {
    if (consoleInstance == null){
      consoleInstance = new Console();
    }
  }

  public static void log(final String logMessage){
    consoleInstance.logList.add(logMessage);
  }

  public static ArrayList<String> getLogList(){
    return consoleInstance.logList;
  }

  public static void clearLogList() {
    consoleInstance.logList.clear();
  }
     
}
