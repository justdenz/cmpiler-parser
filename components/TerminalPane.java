package components;

import javafx.scene.control.TextArea;
import javafx.scene.layout.*;

public class TerminalPane {

  public VBox addTerminalBox() {
    VBox vbox = new VBox();

    ButtonsPane btnPane = new ButtonsPane();

    TextArea console = new TextArea();
    console.setEditable(false);
    console.setPrefHeight(150);

    vbox.getChildren().addAll(btnPane.buttonPane(), console);

    return vbox;
  }
}
