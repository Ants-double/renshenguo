package com.antsdouble.bootuserserviceconsumer.controller;

import com.antsdouble.bean.UserAddress;
import com.antsdouble.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName OrderController
 * @Description d
 * @date 3/26/2019
 * @Author liyy
 * @Version 1.0
 */
@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @ResponseBody
    @RequestMapping("/initorder")
    public List<UserAddress> initOrder(@RequestParam("uid") String userId){
      return  orderService.initOrder(userId);
    }

}
