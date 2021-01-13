package model;

public class CustomError {

    private int lineNum;
    private int charNum = -1;
    private String errorMessage;
    private ErrorType errorType;

    public enum ErrorType {
        NO_VIABLE_ALTERNATIVE,
        MISSING,
        MISMATCHED_INPUT,
        EXTRANEOUS_INPUT,
        TOKEN_RECOGNITION
    }

    public int getLineNumber() {
        return lineNum;
    }

    public void setLineNumber(int lineNum) {
        this.lineNum = lineNum;
    }

    public int getCharNumber() {
        return charNum;
    }

    public void setCharNumber(int charNum) {
        this.charNum = charNum;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public void setErrorType(ErrorType errorType) {
        this.errorType = errorType;
    }
}