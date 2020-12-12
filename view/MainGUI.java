package view;
import components.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.fxmisc.flowless.VirtualizedScrollPane;

import controller.Controller;

public class MainGUI extends Application {
  EditorArea editorArea = new EditorArea();
  TerminalPane terminalPane = new TerminalPane();
  Controller controller = new Controller();

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
    primaryStage.setTitle("Java Keywords Demo");
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
      String parsedResult = "";

      try {
        
        parsedResult = controller.run(input);

        if(parsedResult == ""){
          parsedResult = "No errors! Galing galing naman!";
        }
        
        terminalPane.getConsole().setText(parsedResult);
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