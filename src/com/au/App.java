package com.au;

public class App {

	public static void main(String[] args) {

		System.out.println(
				Thread.currentThread().getName()
		);

		Worker worker = new Worker();

		worker.start();

		for (int i = 0; i < 5; i++) {
			System.out.println("Main : " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}



	}
}
