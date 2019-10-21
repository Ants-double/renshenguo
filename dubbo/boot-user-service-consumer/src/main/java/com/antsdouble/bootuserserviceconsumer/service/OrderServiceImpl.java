package com.antsdouble.bootuserserviceconsumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.antsdouble.bean.UserAddress;
import com.antsdouble.service.OrderService;
import com.antsdouble.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName OrderServiceImpl
 * @Description d
 * @date 3/26/2019
 * @Author liyy
 * @Version 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    //@Autowired
    @Reference
    UserService userService;

    public List<UserAddress> initOrder(String userId) {
        System.out.println("用户ID:"+ userId);
        List<UserAddress> addressList =userService.getUserAddressList(userId);

//        for (UserAddress userAddress:addressList){
//            System.out.println(userAddress.getUserAddress());
//
//        }
        return  addressList;
    }
}
