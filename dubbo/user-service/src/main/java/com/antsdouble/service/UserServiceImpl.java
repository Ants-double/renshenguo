package com.antsdouble.service;

import com.antsdouble.bean.UserAddress;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description impl
 * @date 3/25/2019
 * @Author liyy
 * @Version 1.0
 */
public class UserServiceImpl implements UserService {
    public List<UserAddress> getUserAddressList(String userId) {
        UserAddress address1=new UserAddress(1,"北京市","1","李老师","152","Y");
        UserAddress address2=new UserAddress(2,"河南省","1","张老师","187","N");
        return Arrays.asList(address1,address2);
    }
}
