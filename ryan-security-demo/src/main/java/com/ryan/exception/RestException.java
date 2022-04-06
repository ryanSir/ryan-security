package com.ryan.exception;

/**
 * @author Ryan
 * @version Id: RestException, v 0.1 2021/10/27 下午4:27 ryan Exp $
 */
public class RestException extends RuntimeException {
    private static final long serialVersionUID = -2511775289270340114L;

    private String            message;

    private Object[]          args;

    public RestException(String message) {
        this.message = message;
    }

    public RestException(String message, Object... args) {
        this.args = args;
        this.message = message;
    }

    public RestException(String message, Throwable cause) {
        super(cause);
        this.message = message;
    }

    public RestException(Throwable cause) {
        super(cause);
    }
}