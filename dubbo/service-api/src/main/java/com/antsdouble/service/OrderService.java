package com.antsdouble.service;

import com.antsdouble.bean.UserAddress;

import java.util.List;

public interface OrderService {

    public List<UserAddress> initOrder(String userId);
}
