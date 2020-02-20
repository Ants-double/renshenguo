package com.ants.concurrent;

import com.ants.concurrent.concurrentlinkeddequeexample.AddTask;
import com.ants.concurrent.concurrentlinkeddequeexample.RemoveTask;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @Author lyy
 * @Description demo concurrent linked deque
 * @Date 2019-12-03
 **/
public class ConcurrentLinkedDequeDemo {

	public static void main(String[] args) throws InterruptedException {
		ConcurrentLinkedDeque<String> linkedDeque = new ConcurrentLinkedDeque<>();
		Thread[] threads = new Thread[100];
		for (int i = 0; i < 100; i++) {
			AddTask addTask = new AddTask(linkedDeque);
			threads[i] = new Thread(addTask);
			threads[i].start();
		}
		System.out.printf("Main: %d AddTask threads have been launched\n", threads.length);


		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Main: Size of the List: %d\n", linkedDeque.size());
		for (int i = 0; i < threads.length; i++) {
			RemoveTask task = new RemoveTask(linkedDeque);
			threads[i] = new Thread(task);
			threads[i].start();
		}
		System.out.printf("Main: %d RemoveTask threads have been launched\n", threads.length);

		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Main: Size of the List: %d\n", linkedDeque.size());

	}
}
