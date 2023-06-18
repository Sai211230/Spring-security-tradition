package com.sai.springsecurity.exception;


import org.springframework.security.core.AuthenticationException;

/**
 * @author SAI
 * @create 2023-06-18
 */
public class KaptchaNotMatchException extends AuthenticationException {

    public KaptchaNotMatchException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public KaptchaNotMatchException(String msg) {
        super(msg);
    }
}
