package com.antsdouble.learn.jwt.util;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author lyy
 * @description
 * @date 2019/7/25
 */
public class AjaxAuthenticationProvider implements AuthenticationProvider {
    private final BCryptPasswordEncoder encoder;
    private final DatabaseUserService userService;

    public AjaxAuthenticationProvider(BCryptPasswordEncoder encoder, DatabaseUserService userService) {
        this.encoder = encoder;
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
