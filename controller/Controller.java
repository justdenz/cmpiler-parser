package controller;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.CUSTOMLexer;
import model.CUSTOMParser;
import model.MyListener;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.*;

public class Controller {
  CUSTOMParser parser;
  ParseTree tree;

  public String run(String input) throws Exception {
    String result = "";
    MyListener errorListener = new MyListener();
    // InputStream inputStream = MainGUI.class.getResourceAsStream(input);
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    try {
      Lexer lexer = new CUSTOMLexer(CharStreams.fromStream(inputStream));
      TokenStream tokenStream = new CommonTokenStream(lexer);
      parser = new CUSTOMParser(tokenStream);
      parser.removeErrorListeners();
      parser.addErrorListener(errorListener);
      tree = parser.program();

      result = errorListener.toString();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return result;
  }

  public void viewParseTree() {
    TreeViewer viewer = new TreeViewer(
      Arrays.asList(parser.getRuleNames()),
      tree
    );

    viewer.open();
  }
}
