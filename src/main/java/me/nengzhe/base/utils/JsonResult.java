package me.nengzhe.base.utils;

/**
 * User: bohan
 * Date: 9/16/13
 * Time: 10:10 PM
 */
public class JsonResult<T> {
    public static final String MESSAGE_OK = "OK";

    private boolean success;
    private String message;
    private T data;

    public JsonResult() {
        this.success = true;
        this.message = MESSAGE_OK;
    }

    public JsonResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public JsonResult(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public JsonResult(T data) {
        this();
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
