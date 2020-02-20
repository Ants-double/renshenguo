package com.ants.lock.controller;

import com.ants.lock.util.RedisUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author lyy
 * @Description redis controller
 * @Date 2020-02-20
 **/
@RequestMapping(value = "/redis")
@RestController
public class RedisController {
	// redis中存储的过期时间60s
	private static int ExpireTime = 60;

	@Resource
	private RedisUtil redisUtil;

	@RequestMapping(value = "set",method = RequestMethod.GET)
	public boolean redisSet(String key, String value){
		return redisUtil.set(key,value);
	}

	@RequestMapping("get")
	public Object redisGet(String key){
		return redisUtil.get(key);
	}

	@RequestMapping("expire")
	public boolean expire(String key){
		return redisUtil.expire(key,ExpireTime);
	}
}
