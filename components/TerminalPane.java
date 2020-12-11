package components;

import javafx.scene.control.TextArea;
import javafx.scene.layout.*;

public class TerminalPane {
  TextArea console;

  public VBox addTerminalBox() {
    VBox vbox = new VBox();

    ButtonsPane btnPane = new ButtonsPane();

    console = new TextArea();
    console.setEditable(false);
    console.setPrefHeight(150);

    vbox.getChildren().addAll(btnPane.buttonPane(), console);

    return vbox;
  }
}
