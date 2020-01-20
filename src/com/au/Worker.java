package com.au;

public class Worker extends Thread {

	public void run() {

		System.out.println(
				Thread.currentThread().getName()
		);

		for (int i = 0; i < 5; i++) {
			System.out.println("Worker : " + i);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
