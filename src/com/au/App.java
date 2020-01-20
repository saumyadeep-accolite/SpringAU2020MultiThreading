package com.au;

public class App {

	static int count=0;

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				count++;
			}
		});
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				count++;
			}
		});

		t1.start();t2.start();

		t1.join();t2.join();

		System.out.println("Count : " + count);
	}
}
