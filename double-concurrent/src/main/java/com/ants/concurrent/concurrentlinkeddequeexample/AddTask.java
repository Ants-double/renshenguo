package com.ants.concurrent.concurrentlinkeddequeexample;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @Author lyy
 * @Description add task
 * @Date 2019-12-03
 **/
public class AddTask implements Runnable {

	private ConcurrentLinkedDeque<String> list;

	public AddTask(ConcurrentLinkedDeque<String> list) {
		this.list = list;
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		for (int i=0;i<10000;i++){
			list.add(threadName+":Element"+i);
		}
	}
}
