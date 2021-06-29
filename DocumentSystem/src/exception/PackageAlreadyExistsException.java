package exception;

public class PackageAlreadyExistsException extends Exception {
    public PackageAlreadyExistsException() {
        super();
    }

    public PackageAlreadyExistsException(String message) {
        super(message);
    }

    public PackageAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public PackageAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    protected PackageAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
