package exception;

public class StudentNotStudyingException extends Exception {
    public StudentNotStudyingException() {
    }

    public StudentNotStudyingException(String message) {
        super(message);
    }

    public StudentNotStudyingException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotStudyingException(Throwable cause) {
        super(cause);
    }

    public StudentNotStudyingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
