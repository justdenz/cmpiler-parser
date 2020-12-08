import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.*;

import parser.CUSTOMParser;
import parser.CUSTOMLexer;

class Main{
    public static void main(String[] args) throws Exception{
        try{
            InputStream inputStream = Main.class.getResourceAsStream("input.txt");
            Lexer lexer = new CUSTOMLexer(CharStreams.fromStream(inputStream));
            TokenStream tokenStream = new CommonTokenStream(lexer);
            CUSTOMParser parser = new CUSTOMParser(tokenStream);
            ParseTree tree = parser.program();
            MyListener listener = new MyListener();

            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(listener,tree);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}