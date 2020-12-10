package components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

public class ButtonsPane {

  public HBox buttonPane() {
    Button btnRun = new Button("Run");
    btnRun.setPrefSize(100, 20);

    Button btnParse = new Button("View Parse Tree");
    btnParse.setPrefSize(100, 20);

    HBox hbox = new HBox();
    hbox.setPadding(new Insets(15, 10, 15, 10));
    hbox.setStyle("-fx-background-color: #F6F6F6;");
    hbox.setAlignment(Pos.BASELINE_CENTER);
    HBox.setMargin(btnRun, new Insets(5, 5, 5, 5));
    HBox.setMargin(btnParse, new Insets(5, 5, 5, 5));

    hbox.getChildren().addAll(btnRun, btnParse);

    return hbox;
  }
}
