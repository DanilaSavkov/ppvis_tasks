package exception;

public class OverdueProductException extends Exception {
    public OverdueProductException() {
        super();
    }

    public OverdueProductException(String message) {
        super(message);
    }

    public OverdueProductException(String message, Throwable cause) {
        super(message, cause);
    }

    public OverdueProductException(Throwable cause) {
        super(cause);
    }

    protected OverdueProductException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
