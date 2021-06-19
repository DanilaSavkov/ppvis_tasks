package exception;

public class BoardAlreadyExistsException extends Exception {
    public BoardAlreadyExistsException() {
        super();
    }

    public BoardAlreadyExistsException(String message) {
        super(message);
    }

    public BoardAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public BoardAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    protected BoardAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
