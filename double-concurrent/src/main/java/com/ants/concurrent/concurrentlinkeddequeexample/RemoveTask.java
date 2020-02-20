package com.ants.concurrent.concurrentlinkeddequeexample;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @Author lyy
 * @Description remove task
 * @Date 2019-12-03
 **/
public class RemoveTask implements Runnable {

	private ConcurrentLinkedDeque<String> list;

	public RemoveTask(ConcurrentLinkedDeque<String> list) {
		this.list = list;
	}

	@Override
	public void run() {
		for (int i=0;i<5000;i++){
			list.pollFirst();
			list.pollLast();
		}
	}
}
