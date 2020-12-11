import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;

public class MyListener {
    public static ErrorListener INSTANCE = new ErrorListener();
    public static class ErrorListener extends BaseErrorListener{
        private String errMsg = "";
        @Override 
        public void syntaxError(Recognizer<?, ?> recognizer,
                                Object offendingSymbol,
                                int line, int charPositionInLine,
                                String msg,
                                RecognitionException e) {  
            
            List<String> stack = ((Parser)recognizer).getRuleInvocationStack();
            Collections.reverse(stack);                 
            System.err.println("rule stack: " + stack);
            //System.err.println("line "+line+":"+charPositionInLine+" at "+ offendingSymbol+": "+msg);
            System.err.println(msg +" at line "+line+":"+charPositionInLine);
            errMsg = msg +" at line "+line+":"+charPositionInLine;
        }

        @Override
        public String toString(){
            return this.errMsg;
        }
    }
}