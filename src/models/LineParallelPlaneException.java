package models;

public class LineParallelPlaneException extends Exception{
    public LineParallelPlaneException() {
        super();
    }

    public LineParallelPlaneException(String message) {
        super(message);
    }

    public LineParallelPlaneException(String message, Throwable cause) {
        super(message, cause);
    }

    public LineParallelPlaneException(Throwable cause) {
        super(cause);
    }

    protected LineParallelPlaneException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
