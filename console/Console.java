package console;
import java.util.ArrayList;

public class Console {

  private static Console consoleInstance = null;
  private ArrayList<String> logList;

  public static void createConsole() {
    if (consoleInstance == null) {
      consoleInstance = new Console();
    }
  }

  private Console() {
    this.logList = new ArrayList<String>();
  }

  public static void initialize() {
      createConsole();
	}

  public static void log(final String logLocation, final String logMessage){
    createConsole();
    String logLoc = "In line " + logLocation + ":";
    consoleInstance.logList.add(logLoc + logMessage + "\n");
  }

  public static ArrayList<String> getLogList(){
    return consoleInstance.logList;
  }

  public static void clearLogList() {
    consoleInstance.logList.clear();
  }
}
