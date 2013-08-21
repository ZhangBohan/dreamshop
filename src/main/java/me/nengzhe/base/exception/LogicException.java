package me.nengzhe.base.exception;

/**
 * User: bohan
 * Date: 8/22/13
 * Time: 1:29 AM
 */
public class LogicException extends Exception {
    public LogicException() {
        super();
    }

    public LogicException(String message) {
        super(message);
    }

    public LogicException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogicException(Throwable cause) {
        super(cause);
    }

    public LogicException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
