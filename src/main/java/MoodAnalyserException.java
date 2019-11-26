public class MoodAnalyserException extends Exception {
    enum ExceptionType {
        ENTERED_NULL, ENTERED_EMPTY, NO_SUCH_FIELD, NO_SUCH_METHOD, NO_SUCH_CLASS, OBJECT_CREATION_ISSUE, METHOD_INVOCATION_ISSUE, FIELD_SETTING_ISSUE
    }
    ExceptionType type;

    public MoodAnalyserException(ExceptionType type, String message) {
        super(message);
        this.type=type;
    }

    public MoodAnalyserException(ExceptionType type, Throwable cause) {
        super(cause);
        this.type=type;
    }

    public MoodAnalyserException(ExceptionType type, String message, Throwable cause) {
        super(message,cause);
        this.type=type;
    }
}