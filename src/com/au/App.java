package com.au;

public class App {

	public static void main(String[] args) throws InterruptedException {

		Thread a = new Worker("A");
		Thread b = new Worker("B");
		Thread c = new Worker("C");

		a.setPriority(Thread.MIN_PRIORITY);
		b.setPriority(Thread.NORM_PRIORITY);
		c.setPriority(Thread.MAX_PRIORITY);



		a.start();b.start();c.start();

		a.join();b.join();c.join();



		System.out.println(Thread.currentThread().getPriority());
	}
}
