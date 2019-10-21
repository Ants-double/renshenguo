package com.antsdouble.bootuserserviceprovider.service;



import com.alibaba.dubbo.config.annotation.Service;
import com.antsdouble.bean.UserAddress;
import com.antsdouble.service.UserService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description d
 * @date 3/26/2019
 * @Author liyy
 * @Version 1.0
 */
@Service//发布服务
@Component
public class UserServiceImpl implements UserService {

    public List<UserAddress> getUserAddressList(String userId) {
        UserAddress address1=new UserAddress(1,"北京市","1","李老师","152","Y");
        UserAddress address2=new UserAddress(2,"河南省","1","张老师","187","N");
        return  Arrays.asList(address1,address2);
    }
}
