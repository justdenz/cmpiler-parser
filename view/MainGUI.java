package view;

import components.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import console.Console;
import console.Printer;
import console.ScanWindow;

import java.util.ArrayList;

import org.fxmisc.flowless.*;

import controller.Controller;
import execution.ExecutionManager;

public class MainGUI extends Application {
  public EditorArea editorArea = new EditorArea();
  public static TerminalPane terminalPane = new TerminalPane();
  public Controller controller = new Controller();

  @Override
  public void start(Stage primaryStage) {
    BorderPane layout = new BorderPane();

    layout.setCenter(new VirtualizedScrollPane<>(editorArea.addEditorArea()));
    layout.setBottom(terminalPane.addTerminalBox());
    terminalPane.getBtnCompile().setOnAction(compile);
    terminalPane.getBtnParse().setOnAction(viewParseTree);

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

      try {
        controller.run(input);
        if(Console.getLogList().size() == 0){
          Printer.getInstance().display("No syntax errors found \n");
          ExecutionManager.getInstance().runAllCommands();
        } else {
          for(String log : Console.getLogList()){
            Printer.getInstance().display(log);
          }
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

}
