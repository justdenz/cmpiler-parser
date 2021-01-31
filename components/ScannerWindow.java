package components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ScannerWindow {
  
  Stage scannerWindow = new Stage();
  TextField inputField = new TextField();
  Button enterBtn = new Button();
  Scene scene;

  public void showScannerWindow(){

    scannerWindow.setTitle("Scanner Window");

    VBox layout = new VBox(10);
    layout.setPadding(new Insets(10));

    inputField.setPromptText("Enter value:");
    enterBtn.setText("Submit");

    layout.getChildren().addAll(inputField, enterBtn);
    layout.setAlignment(Pos.CENTER);

    scene = new Scene(layout, 250, 100);
    scannerWindow.setScene(scene);
    scannerWindow.show();
  }

  public void close(){
    scannerWindow.close();
  }

  public Scene getScene(){
    return scene;
  }

  public String getScannerInput() {
    return inputField.getText();
  }

  public Button getEnterBtn() {
    return enterBtn;
  }

}
