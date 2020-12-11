import components.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.fxmisc.flowless.VirtualizedScrollPane;

public class MainGUI extends Application {
  // private CodeArea codeArea;
  // private ExecutorService executor;
  EditorArea editorArea;
  Controller controller = new Controller();

  @Override
  public void start(Stage primaryStage) {
    // executor = Executors.newSingleThreadExecutor();

    BorderPane layout = new BorderPane();
    TerminalPane terminalPane = new TerminalPane();
    editorArea = new EditorArea();
    layout.setCenter(new VirtualizedScrollPane<>(editorArea.addEditorArea()));
    layout.setBottom(terminalPane.addTerminalBox());

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
}
