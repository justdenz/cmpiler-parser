package components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class ButtonsPane {
  Button btnRun = new Button("Run");
  Button btnParse = new Button();
  Image img = new Image("/components/style/tree.png");

  public HBox buttonPane() {
    btnRun.setPrefSize(100, 24);
    btnParse.setPrefSize(32, 32);
    btnParse.setGraphic(new ImageView(img));

    HBox hbox = new HBox();
    hbox.setPadding(new Insets(15, 10, 15, 10));
    hbox.setStyle("-fx-background-color: #F6F6F6;");
    hbox.setAlignment(Pos.BASELINE_CENTER);
    HBox.setMargin(btnRun, new Insets(5, 5, 5, 5));
    HBox.setMargin(btnParse, new Insets(5, 5, 5, 5));

    hbox.getChildren().addAll(btnRun, btnParse);

    return hbox;
  }

  public Button getBtnParse() {
    return this.btnParse;
  }

  public Button getBtnRun() {
    return this.btnRun;
  }
}
