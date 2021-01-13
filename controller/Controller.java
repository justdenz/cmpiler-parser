package controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import model.CUSTOMLexer;
import model.CUSTOMParser;
import model.CustomErrorListener;
import model.CustomError;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.*;

public class Controller {
  CUSTOMParser parser;
  ParseTree tree;

  public ArrayList<CustomError> run(String input) throws Exception {
    ArrayList<CustomError> output = new ArrayList<>();
    CustomErrorListener errorListener = new CustomErrorListener();
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    try {
      Lexer lexer = new CUSTOMLexer(CharStreams.fromStream(inputStream));
      TokenStream tokenStream = new CommonTokenStream(lexer);
      parser = new CUSTOMParser(tokenStream);
      parser.removeErrorListeners();
      parser.addErrorListener(errorListener);
      tree = parser.program();

      output = errorListener.getErrors();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return output;
  }

  public void viewParseTree() {
    TreeViewer viewer = new TreeViewer(
      Arrays.asList(parser.getRuleNames()),
      tree
    );

    viewer.open();
  }
}
