package com.au;

public class App {

	public static void main(String[] args) {

		Thread worker = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Inner Says Hi!");
			}

		});
		worker.start();

		Thread worker2 = new Thread(() -> System.out.println("Inner Says Hi!"));
		worker2.start();
		
	}
}
