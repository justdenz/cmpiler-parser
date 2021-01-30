package components;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;

public class TerminalPane {
  TextArea console = new TextArea();
  ButtonsPane btnPane = new ButtonsPane();

  public VBox addTerminalBox() {
    VBox vbox = new VBox();

    console.setEditable(false);
    console.setPrefHeight(250);

    vbox.getChildren().addAll(btnPane.buttonPane(), console);

    return vbox;
  }

  public Button getBtnParse() {
    return this.btnPane.getBtnParse();
  }

  public Button getBtnCompile() {
    return this.btnPane.getBtnRun();
  }

  public TextArea getConsole() {
    return this.console;
  }
}
