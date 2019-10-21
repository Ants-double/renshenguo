package com.antsdouble.learn.jwt.util;

import org.springframework.security.authentication.AuthenticationServiceException;

/**
 * @author lyy
 * @description
 * @date 2019/7/25
 */
public class AuthMethodNotSupportedException extends AuthenticationServiceException {
    private static final long serialVersionUID = 3705043083010304496L;

    public AuthMethodNotSupportedException(String msg) {
        super(msg);
    }
}
