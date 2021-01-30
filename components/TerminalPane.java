package components;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;

public class TerminalPane {
  TextArea terminalArea = new TextArea();
  ButtonsPane btnPane = new ButtonsPane();

  public VBox addTerminalBox() {
    VBox vbox = new VBox();

    terminalArea.setEditable(false);
    terminalArea.setPrefHeight(250);

    vbox.getChildren().addAll(btnPane.buttonPane(), terminalArea);

    return vbox;
  }

  public Button getBtnParse() {
    return this.btnPane.getBtnParse();
  }

  public Button getBtnCompile() {
    return this.btnPane.getBtnRun();
  }

  public TextArea getTerminalArea() {
    return this.terminalArea;
  }

  public String getTerminalAreaText() {
    return this.terminalArea.getText();
  }
}
