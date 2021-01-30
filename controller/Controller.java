package controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import console.Console;
import console.Printer;
import execution.ExecutionManager;
import model.CUSTOMLexer;
import model.CUSTOMParser;
import model.CustomErrorListener;
import model.ProgramCustomListener;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.*;

public class Controller {
  CUSTOMParser parser;
  ParseTree tree;

  public void run(String input) throws Exception {
    Console.initialize();
    CustomErrorListener errorListener = new CustomErrorListener();
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    try {
      Lexer lexer = new CUSTOMLexer(CharStreams.fromStream(inputStream));
      TokenStream tokenStream = new CommonTokenStream(lexer);
      parser = new CUSTOMParser(tokenStream);
      parser.removeErrorListeners();
      parser.addErrorListener(errorListener); //syntax part
      tree = parser.program();

      ParseTreeWalker walker = new ParseTreeWalker();
      ProgramCustomListener programCustomListener = new ProgramCustomListener(); //semantic part
      walker.walk(programCustomListener, tree);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void viewParseTree() {
    TreeViewer viewer = new TreeViewer(
      Arrays.asList(parser.getRuleNames()),
      tree
    );
    viewer.open();
  }
}
