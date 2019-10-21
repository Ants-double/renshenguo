package com.antsdouble.service;

import com.antsdouble.bean.UserAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName OrderServiceImpl
 * @Description impl
 * @date 3/25/2019
 * @Author liyy
 * @Version 1.0
 */
@Service
public class OrderServiceImpl implements  OrderService {

    @Autowired
    UserService userService;

    public void initOrder(String userId) {

        System.out.println("用户ID:"+ userId);
        List<UserAddress> addressList =userService.getUserAddressList(userId);
        for (UserAddress userAddress:addressList){
            System.out.println(userAddress.getUserAddress());

        }
    }
}
