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

public class Controller {
    public String run(InputStream inputStream) throws Exception{
        String result = "";
        try{
            Lexer lexer = new CUSTOMLexer(CharStreams.fromStream(inputStream));
            TokenStream tokenStream = new CommonTokenStream(lexer);
            CUSTOMParser parser = new CUSTOMParser(tokenStream);
            parser.removeErrorListeners();
            parser.addErrorListener(MyListener.INSTANCE);
            ParseTree tree = parser.program();

            result = MyListener.INSTANCE.toString();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }    
}

