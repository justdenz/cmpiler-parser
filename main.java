package parser;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import parser.*;

public class Main{
    public static void main(String[] args){
        try{
            String test = "System.out.println(1)";
            InputStream inputStream = Main.class.getResourceAsStream(test);
            Lexer lexer = new CLexer(CharStreams.fromStream(inputStream));
            TokenStream tokenStream = new CommonTokenStream(lexer);
            CParser parser = new CParser(tokenStream);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}