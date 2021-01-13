package model;

public class CustomError {

    private int lineNumber;
    private int charNumber = -1;
    private String errorPrefix;
    private String errorSuffix;
    private ErrorType type;

    public enum ErrorType {
        NO_VIABLE_ALTERNATIVE,
        MISSING,
        MISMATCHED_INPUT,
        EXTRANEOUS_INPUT,
        TOKEN_RECOGNITION
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public int getCharNumber() {
        return charNumber;
    }

    public void setCharNumber(int charNumber) {
        this.charNumber = charNumber;
    }

    public String getErrorPrefix() {
        return errorPrefix;
    }

    public void setErrorPrefix(String errorPrefix) {
        this.errorPrefix = errorPrefix;
    }

    public String getErrorSuffix() {
        return errorSuffix;
    }

    public void setErrorSuffix(String errorSuffix) {
        this.errorSuffix = errorSuffix;
    }

    public ErrorType getType() {
        return type;
    }

    public void setType(ErrorType type) {
        this.type = type;
    }
}