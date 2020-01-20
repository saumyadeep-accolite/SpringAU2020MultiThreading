package com.au;

public class App {

	public static void main(String[] args) throws InterruptedException {

		Thread worker = new Worker(Thread.currentThread());

		worker.start();

		worker.join();

		System.out.println("Main finished");
	}
}
