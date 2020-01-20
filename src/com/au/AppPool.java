package com.au;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AppPool {

	public static void main(String[] args) throws InterruptedException {

		ExecutorService executorService = Executors.newFixedThreadPool(2);

		for (int i = 0; i < 5; i++) {
			executorService.submit(new Worker5(i));
		}

		executorService.shutdown();

		executorService.awaitTermination(1, TimeUnit.DAYS);


	}
}

class Worker5 implements Runnable {

	int id;

	public Worker5(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Thread Name : " + Thread.currentThread().getName());
		System.out.println("Worker " + id +"  started");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Worker " + id +"  finished");
	}
}