package com.etechon.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Multi-threading using Executor Framework. Programme will create 4 threads and
 * finish when all 4 threads execution done.
 * This source code you can use when your project is using JAVA 7  
 */
public class ExecutorFrameworkExample {
	public static void main(String[] args) {
		final int PROCESS_COUNT = 4;
		ExecutorService executorService = Executors.newFixedThreadPool(PROCESS_COUNT);
		/*
		 * Enter Executors, A framework for creating and managing threads. Executors
		 * framework helps you with - Thread Creation - Thread management - Task
		 * submission and execution
		 */
		final CountDownLatch countDownLatch = new CountDownLatch(PROCESS_COUNT);

		/*
		 * When we create an object of CountDownLatch, we specify the number of threads
		 * it should wait for here is 4, all such thread are required to do count down
		 * by calling CountDownLatch.countDown() once they are completed or ready to the
		 * job. As soon as count reaches zero, the waiting task starts running.
		 */

		executorService.submit(new Runnable() {
			public void run() {
				try {
					updateProgramDataStoreGeography(1, "getRecord1");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				countDownLatch.countDown();
			}
		});

		executorService.submit(new Runnable() {
			public void run() {
				updateProgramDataStoreBoundry(2, "getRecord2");
				countDownLatch.countDown();
			}
		});

		executorService.submit(new Runnable() {
			public void run() {
				updateProgramDataStoreRegion(3, "getRecord3");
				countDownLatch.countDown();
			}
		});

		executorService.submit(new Runnable() {
			public void run() {
				updateProgramDataStoreDataCode(4, "getRecord4");
				countDownLatch.countDown();
			}
		});

		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executorService.shutdown();
		System.out.println("Done...");
	}

	public static void updateProgramDataStoreGeography(int count, String programeName) throws InterruptedException {

		Thread.sleep(1000);
		System.out.println("Programe Name :" + count + "Praogramme name :" + programeName);
	}

	public static void updateProgramDataStoreBoundry(int count, String programeName) {
		System.out.println("Programe Name :" + count + "Praogramme name :" + programeName);
	}

	public static void updateProgramDataStoreRegion(int count, String programeName) {
		System.out.println("Programe Name :" + count + "Praogramme name :" + programeName);
	}

	public static void updateProgramDataStoreDataCode(int count, String programeName) {
		System.out.println("Programe Name :" + count + "Praogramme name :" + programeName);
	}


}
