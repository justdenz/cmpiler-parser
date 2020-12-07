import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import parser.CParser;
import parser.CLexer;

class Main{
    public static void main(String[] args) throws Exception{
        try{
            InputStream inputStream = Main.class.getResourceAsStream("input.txt");
            Lexer lexer = new CLexer(CharStreams.fromStream(inputStream));
            TokenStream tokenStream = new CommonTokenStream(lexer);
            CParser parser = new CParser(tokenStream);
            CParser.CompilationUnitContext tree = parser.compilationUnit();
            MyListener listener = new MyListener();

            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(listener,tree);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}