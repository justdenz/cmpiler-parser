import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import javafx.application.Application;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.*;
import parser.CUSTOMLexer;
import parser.CUSTOMParser;

class Main {

  public static void main(String[] args) throws Exception {
    try {
      Application.launch(MainGUI.class, args);
      InputStream inputStream = Main.class.getResourceAsStream("input.txt");
      Lexer lexer = new CUSTOMLexer(CharStreams.fromStream(inputStream));
      TokenStream tokenStream = new CommonTokenStream(lexer);
      CUSTOMParser parser = new CUSTOMParser(tokenStream);
      parser.removeErrorListeners();
      parser.addErrorListener(MyListener.INSTANCE);
      ParseTree tree = parser.program();

      TreeViewer viewer = new TreeViewer(
        Arrays.asList(parser.getRuleNames()),
        tree
      );
      // viewer.open();
      // ParseTreeWalker walker = new ParseTreeWalker();
      // walker.walk(listener,tree);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
