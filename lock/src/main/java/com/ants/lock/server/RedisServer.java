package com.ants.lock.server;

import com.ants.lock.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author lyy
 * @Description redis service
 * @Date 2020-02-20
 **/
@Service("RedisServer")
public class RedisServer {

	@Resource
	private RedisUtil redisUtil;

}
