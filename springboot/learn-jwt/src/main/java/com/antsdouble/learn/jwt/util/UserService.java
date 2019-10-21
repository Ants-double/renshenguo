package com.antsdouble.learn.jwt.util;

public interface UserService {
    public Optional<User> getByUsername(String username);
}
