package com.au;

public class App {

	public static void main(String[] args) throws InterruptedException {

		Thread worker = new Worker();

		worker.start();

		worker.join();

		System.out.println("Main finished");
	}
}
