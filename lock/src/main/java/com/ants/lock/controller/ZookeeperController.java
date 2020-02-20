package com.ants.lock.controller;

import com.ants.lock.Zklock;
import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lyy
 * @Description zk lock
 * @Date 2020-02-20
 **/
@RestController
@RequestMapping(value = "/zk")
public class ZookeeperController {
	@Autowired
	private CuratorFramework zkClient;

	@Autowired
	private Zklock zklock;

	@GetMapping("/lock")
	public Boolean getLock() throws Exception{

		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					zklock.lock();
					zklock.unlock();
				} }).start(); }


		return true; }
}
