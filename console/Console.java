package console;
import java.util.ArrayList;

public class Console {

  private static Console consoleInstance = null;

  public static void createConsole() {
    if (consoleInstance == null){
      consoleInstance = new Console();
    }
  }

  private ArrayList<String> logList;

  private Console() {
    this.logList = new ArrayList<String>();
  }

  public static void initialize() {
      createConsole();
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
