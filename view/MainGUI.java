package view;

import components.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import console.Console;
import console.Printer;

import java.util.ArrayList;

import org.fxmisc.flowless.*;

import controller.Controller;
import execution.ExecutionManager;

public class MainGUI extends Application {
  public EditorArea editorArea = new EditorArea();
  public static TerminalPane terminalPane = new TerminalPane();
  public ScannerWindow scannerWindow = new ScannerWindow();
  public Controller controller = new Controller();

  @Override
  public void start(Stage primaryStage) {
    BorderPane layout = new BorderPane();

    layout.setCenter(new VirtualizedScrollPane<>(editorArea.addEditorArea()));
    layout.setBottom(terminalPane.addTerminalBox());
    terminalPane.getBtnCompile().setOnAction(compile);
    terminalPane.getBtnParse().setOnAction(viewParseTree);
    scannerWindow.getEnterBtn().setOnAction(enterScanner);

    Scene scene = new Scene(layout, 600, 600);
    scene.getStylesheets().add("/components/style/java-keywords.css");
    primaryStage.setScene(scene);
    primaryStage.setTitle("The Search Three Compiler");
    primaryStage.show();
  }

  @Override
  public void stop() {
    editorArea.executor.shutdown();
  }

  // Event Handlers

  EventHandler<ActionEvent> compile = new EventHandler<ActionEvent>() {
  
    @Override
    public void handle(ActionEvent event) {
      String input = editorArea.getInput();
      ArrayList<String> logList = new ArrayList<>();
      String output = "";

      // if(input.contains("scan")){
      //   scannerWindow.showScannerWindow();
      // }

      try {
        controller.run(input);
        logList = Console.getLogList();
        if(logList.size() == 0){
          Printer.getInstance().display("No syntax errors found \n\n");
          ExecutionManager.getInstance().runAllCommands();
          ExecutionManager.getInstance().resetCommands();
        } else {
          for(String log : logList){
            output += output + log;
          }
          Printer.getInstance().display(output);
          Console.clearLogList();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  };

  EventHandler<ActionEvent> viewParseTree = new EventHandler<ActionEvent>() {

    @Override
    public void handle(ActionEvent event) {
      controller.viewParseTree();
    }
  };

  EventHandler<ActionEvent> enterScanner = new EventHandler<ActionEvent>(){

    @Override
    public void handle(ActionEvent event) {
      scannerWindow.close();

    }
    
  };
}
