package exception;

public class DocumentAlreadyExistsException extends Exception {
    public DocumentAlreadyExistsException() {
        super();
    }

    public DocumentAlreadyExistsException(String message) {
        super(message);
    }

    public DocumentAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public DocumentAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    protected DocumentAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
