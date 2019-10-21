package com.antsdouble.service;

import com.antsdouble.bean.UserAddress;

import java.util.List;

public interface UserService {
    public List<UserAddress> getUserAddressList(String userId);
}
