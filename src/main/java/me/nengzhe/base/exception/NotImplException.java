package me.nengzhe.base.exception;

/**
 * 未实现异常
 *
 * User: bohan
 * Date: 8/22/13
 * Time: 2:09 AM
 */
public class NotImplException extends RuntimeException {

    public NotImplException() {
    }

    public NotImplException(String message) {
        super(message);
    }

    public NotImplException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotImplException(Throwable cause) {
        super(cause);
    }

    public NotImplException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
