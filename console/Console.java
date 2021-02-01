package console;
import java.util.ArrayList;

public class Console {

  private static Console consoleInstance = null;
  private static ArrayList<String> logList;

  public static Console getInstance() {
    if (consoleInstance == null) {
      logList = new ArrayList<String>();
      consoleInstance = new Console();
      System.out.println("Console initialized");
    }
    return consoleInstance;
  }

  public static void initialize() {
      getInstance();
	}

  public static void log(final String logLocation, final String logMessage){
    String logLoc = "In line " + logLocation + ": ";
    logList.add(logLoc + logMessage);
  }

  public static ArrayList<String> getLogList(){
    return logList;
  }

  public void clearLogList() {
    logList.clear();
  }
}
