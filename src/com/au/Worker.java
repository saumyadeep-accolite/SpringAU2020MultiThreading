package com.au;

public class Worker extends Thread {

	public void run() {
		System.out.println("Worker Started");
		for (int i = 0; i < 5; i++) {
			System.out.println("Worker : " + i);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Thread t = new Thread(new Worker2());
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Worker Finished");

	}

}
