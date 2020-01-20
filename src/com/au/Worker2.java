package com.au;

public class Worker2 implements Runnable {

	@Override
	public void run() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Hi From Worker 2");

	}

}
