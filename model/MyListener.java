package model;

import org.antlr.v4.runtime.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class MyListener extends BaseErrorListener{

    private ArrayList<CustomError> errors = new ArrayList<>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e) {
        //System.err.println("Syntax Error @ Line " + i + " : " + i1 + " " + s);

        // TODO :
        // IDENTIFY ERRORS FROM String s
        //  - Extraneous Input
        //  - Mismatched Input
        //  - No viable alternative
        //  - Missing
        //  - Token Recognition
        // CREATE OWN ERROR MESSAGES AND SUGGESTIONS
        // THEN ADD THEM TO ERRORS LIST
        // USE getErrors() IN PRINTING THE ERRORS IN CONSOLE

        List<String> stack = ((Parser)recognizer).getRuleInvocationStack(); Collections.reverse(stack);
        //System.err.println("rule stack: "+stack);

        CustomError error = new CustomError();

        error.setLineNumber(i);
        error.setCharNumber(i1);

        if (s.contains(CustomError.MISSING_KEY)) {

            error.setType(CustomError.ErrorType.MISSING);

            String split[] = s.split(CustomError.MISSING_KEY);

            String tokens[] = split[1].split("at");

            error.setErrorPrefix("missing " + tokens[0] + " before " + tokens[1] + "");
            error.setLineLayout("line " + i + " @ " + i1);
            error.setErrorSuffix(". Try adding " + tokens[0] + " before " + tokens[1] + ".");

        } else if (s.contains(CustomError.NO_VIABLE_ALT_KEY)) {

            error.setType(CustomError.ErrorType.NO_VIABLE_ALTERNATIVE);

            String split[] = s.split(CustomError.NO_VIABLE_ALT_KEY);

            error.setErrorPrefix("could not resolve the token " + split[1] + "");
            error.setLineLayout("line " + i + " @ " + i1);
            error.setErrorSuffix(".");

        } else if (s.contains(CustomError.MISMATCHED_INPUT_KEY)) {

            error.setType(CustomError.ErrorType.MISMATCHED_INPUT);

            String split[] = s.split(CustomError.MISMATCHED_INPUT_KEY);

            String str[] = new String[1];

            if (split[1].contains("expecting")) {
                str = split[1].split("expecting");
            }

            error.setLineLayout("line " + i + " @ " + i1);
            error.setErrorSuffix(".");

            if (str[1].contains("IntegerLiteral") && str[1].contains("FloatingPointLiteral") && str[1].contains("BooleanLiteral") && str[1].contains("CharacterLiteral")
                    && str[1].contains("StringLiteral") && str[1].contains("Identifier")) {

                error.setErrorPrefix("mismatched input " + str[0] + " try replacing it with an expression");
            } else if (str[1].contains("Identifier")) {
                //resultedMessage = "Expected identifier at line " + i + " @ " + i1;

                error.setErrorPrefix("expected identifier");
            } else {

                error.setErrorPrefix("mismatched input " + str[0] + " try replacing it with " + str[1] + "");
            }

        } else if (s.contains(CustomError.EXTRANEOUS_INPUT_KEY)) {

            error.setType(CustomError.ErrorType.EXTRANEOUS_INPUT);

            String split[] = s.split(CustomError.EXTRANEOUS_INPUT_KEY);

            error.setLineLayout("line " + i + " @ " + i1);
            error.setErrorPrefix("extraneous input");

            String str[] = new String[1];
            for (int k = 0; k < split.length; k++) { // test
                //System.out.print("k: ");
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

                System.out.println("--==-=-=-==" + i);

                error.setErrorSuffix(" : consider removing " + str[0] + " and replacing it with an expression.");

            } else if (str[1].contains("Identifier"))  {

                error.setErrorSuffix(" : consider removing " + str[0] + " and replacing it with an identifier.");

            } else {

                error.setErrorSuffix(" : consider removing " + str[0] + " and replacing it with " + str[1] + ".");

            }

        } else if (s.contains(CustomError.TOKEN_RECOGNITION_KEY)) {
            error.setType(CustomError.ErrorType.TOKEN_RECOGNITION);

            error.setErrorPrefix("token recognition error");
            error.setLineLayout("line " + i + " @ " + i1);
            error.setErrorSuffix(".");
        }
        errors.add(error);
    }

    public ArrayList<CustomError> getErrors () {
        return this.errors;
    }

    /*@Override
    public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet, ATNConfigSet atnConfigSet) {
        System.err.println("Ambiguity @ Line " + i + " : " + i1);
    }
    @Override
    public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitSet, ATNConfigSet atnConfigSet) {
        System.err.println("Attempting Full Context @ Line " + i + " : " + i1);
    }
    @Override
    public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atnConfigSet) {
        System.err.println("Context Sensitivity @ Line " + i + " : " + i1);
    }*/
}