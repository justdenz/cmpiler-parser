package model;

import org.antlr.v4.runtime.*;

import java.util.Collections;
import java.util.List;

import console.Console;
public class CustomErrorListener extends BaseErrorListener{

    private String NO_VIABLE = "no viable alternative at input";
    private String MISSING = "missing";
    private String MISMATCHED = "mismatched input";
    private String EXTRANEOUS = "extraneous input";
    private String TOK_RECOG = "token recognition error";

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object o, int lineNum, int charNum, String message, RecognitionException e) {

        List<String> stack = ((Parser)recognizer).getRuleInvocationStack(); 
        Collections.reverse(stack);
        CustomError error = new CustomError();

        error.setLineNumber(lineNum);
        error.setCharNumber(charNum);

        if (message.contains(MISSING)) {

            error.setErrorType(CustomError.ErrorType.MISSING);
            String split[] = message.split(MISSING);
            if(!message.contains("missing valid operators")){
                String tokens[] = split[1].split("at");
                error.setErrorMessage("Missing " + tokens[0] + " before " + tokens[1] + " . Consider adding " + tokens[0] + " before " + tokens[1] + ".");
            } else {
                error.setErrorMessage("Missing valid operators. Consider replacing it with valid operators.");
            }
            
        } else if (message.contains(NO_VIABLE)) {

            error.setErrorType(CustomError.ErrorType.NO_VIABLE_ALTERNATIVE);
            String split[] = message.split(NO_VIABLE);
            error.setErrorMessage("Could not resolve the token " + split[1] + " .");

        } else if (message.contains(MISMATCHED)) {

            error.setErrorType(CustomError.ErrorType.MISMATCHED_INPUT);
            String split[] = message.split(MISMATCHED);
            String str[] = new String[1];

            if (split[1].contains("expecting")) {
                str = split[1].split("expecting");
            }

            if (str[1].contains("IntegerLiteral") 
                && str[1].contains("FloatingPointLiteral") 
                && str[1].contains("BooleanLiteral") 
                && str[1].contains("CharacterLiteral")
                && str[1].contains("StringLiteral") 
                && str[1].contains("Identifier")) {
                error.setErrorMessage("Mismatched input " + str[0] + ". Consider replacing it with an expression.");

            } else if (str[1].contains("Identifier")) {
                error.setErrorMessage("Expected identifier. Consider replacing it with an identifier.");

            } else {
                error.setErrorMessage("Mismatched input " + str[0] + ". Consider replacing it with " + str[1] + ".");
            }

        } else if (message.contains(EXTRANEOUS)) {

            error.setErrorType(CustomError.ErrorType.EXTRANEOUS_INPUT);
            String split[] = message.split(EXTRANEOUS);

            String str[] = new String[1];
            for (int k = 0; k < split.length; k++) {
                split[k] = split[k].trim();

                if (split[k].contains("expecting")) {
                    str = split[k].split("expecting");
                }
            }

            if (str[1].contains("'end'")) {
                error.setErrorMessage("Extraneous input. Missing 'end' statement.");

            } else if (str[1].contains("IntegerLiteral") 
                    && str[1].contains("FloatingPointLiteral") 
                    && str[1].contains("BooleanLiteral") 
                    && str[1].contains("CharacterLiteral")
                    && str[1].contains("StringLiteral") 
                    && str[1].contains("Identifier")) {
                error.setErrorMessage("Extraneous input. Consider removing " + str[0] + " and replacing it with an expression.");

            } else if (str[1].contains("Identifier"))  {
                error.setErrorMessage("Extraneous input. Consider removing " + str[0] + " and replacing it with an identifier.");

            } else {
                error.setErrorMessage("Extraneous input. Consider removing " + str[0] + " and replacing it with " + str[1] + ".");
            }

        } else if (message.contains(TOK_RECOG)) {
            error.setErrorType(CustomError.ErrorType.TOKEN_RECOGNITION);
            error.setErrorMessage("Token recognition error.");
        } else {
            //error.setErrorType(CustomError.ErrorType.TOKEN_RECOGNITION);
            error.setErrorMessage(message);
        }

        String errLineNum = String.valueOf(error.getLineNumber());
        String errCharNum = String.valueOf(error.getCharNumber());
        String errLoc = errLineNum;
        String errMsg = error.getErrorMessage();
        Console.log(errLoc, errMsg);
    }
}