package model;

import org.antlr.v4.runtime.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomErrorListener extends BaseErrorListener{

    private String NO_VIABLE = "no viable alternative at input";
    private String MISSING = "missing";
    private String MISMATCHED = "mismatched input";
    private String EXTRANEOUS = "extraneous input";
    private String TOK_RECOG = "token recognition error";

    private ArrayList<CustomError> errors = new ArrayList<>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object o, int lineNum, int charNum, String message, RecognitionException e) {

        List<String> stack = ((Parser)recognizer).getRuleInvocationStack(); 
        Collections.reverse(stack);
        CustomError error = new CustomError();

        error.setLineNumber(lineNum);
        error.setCharNumber(charNum);

        if (message.contains(MISSING)) {

            error.setType(CustomError.ErrorType.MISSING);

            String split[] = message.split(MISSING);

            String tokens[] = split[1].split("at");

            error.setErrorPrefix("missing " + tokens[0] + " before " + tokens[1] + "");
            error.setErrorSuffix(". Try adding " + tokens[0] + " before " + tokens[1] + ".");

        } else if (message.contains(NO_VIABLE)) {

            error.setType(CustomError.ErrorType.NO_VIABLE_ALTERNATIVE);

            String split[] = message.split(NO_VIABLE);

            error.setErrorPrefix("could not resolve the token " + split[1] + "");
            error.setErrorSuffix(".");

        } else if (message.contains(MISMATCHED)) {

            error.setType(CustomError.ErrorType.MISMATCHED_INPUT);

            String split[] = message.split(MISMATCHED);

            String str[] = new String[1];

            if (split[1].contains("expecting")) {
                str = split[1].split("expecting");
            }

            error.setErrorSuffix(".");

            if (str[1].contains("IntegerLiteral") && str[1].contains("FloatingPointLiteral") && str[1].contains("BooleanLiteral") && str[1].contains("CharacterLiteral")
                    && str[1].contains("StringLiteral") && str[1].contains("Identifier")) {

                error.setErrorPrefix("mismatched input " + str[0] + " try replacing it with an expression");
            } else if (str[1].contains("Identifier")) {
                error.setErrorPrefix("expected identifier");
            } else {
                error.setErrorPrefix("mismatched input " + str[0] + " try replacing it with " + str[1] + "");
            }

        } else if (message.contains(EXTRANEOUS)) {

            error.setType(CustomError.ErrorType.EXTRANEOUS_INPUT);

            String split[] = message.split(EXTRANEOUS);

            error.setErrorPrefix("extraneous input");

            String str[] = new String[1];
            for (int k = 0; k < split.length; k++) {
                split[k] = split[k].trim();

                if (split[k].contains("expecting")) {
                    str = split[k].split("expecting");
                }
            }

            if (str[1].contains("'end'")) {

                error.setErrorPrefix("missing 'end' statement");
                error.setErrorSuffix(".");

            } else if (str[1].contains("IntegerLiteral") && str[1].contains("FloatingPointLiteral") && str[1].contains("BooleanLiteral") && str[1].contains("CharacterLiteral")
                    && str[1].contains("StringLiteral") && str[1].contains("Identifier")) {

                error.setErrorSuffix(" : consider removing " + str[0] + " and replacing it with an expression.");

            } else if (str[1].contains("Identifier"))  {

                error.setErrorSuffix(" : consider removing " + str[0] + " and replacing it with an identifier.");

            } else {

                error.setErrorSuffix(" : consider removing " + str[0] + " and replacing it with " + str[1] + ".");

            }

        } else if (message.contains(TOK_RECOG)) {

            error.setType(CustomError.ErrorType.TOKEN_RECOGNITION);

            error.setErrorPrefix("token recognition error");
            error.setErrorSuffix(".");

        }
        errors.add(error);
    }

    public ArrayList<CustomError> getErrors () {
        return this.errors;
    }
}