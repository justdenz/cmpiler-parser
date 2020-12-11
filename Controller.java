import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.*;
import parser.CUSTOMLexer;
import parser.CUSTOMParser;

public class Controller {
  CUSTOMParser parser;

  public String run(String input) throws Exception {
    String result = "";
    // InputStream inputStream = MainGUI.class.getResourceAsStream(input);
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    try {
      Lexer lexer = new CUSTOMLexer(CharStreams.fromStream(inputStream));
      TokenStream tokenStream = new CommonTokenStream(lexer);
      parser = new CUSTOMParser(tokenStream);
      parser.removeErrorListeners();
      parser.addErrorListener(MyListener.INSTANCE);

      result = MyListener.INSTANCE.toString();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return result;
  }

  public void viewParseTree() {
    ParseTree tree = parser.program();
    TreeViewer viewer = new TreeViewer(
      Arrays.asList(parser.getRuleNames()),
      tree
    );

    viewer.open();
  }
}
