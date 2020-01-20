package com.au;

public class Worker extends Thread {

	String name;

	public Worker(String name) {
		this.name = name;
	}
	public void run() {
		System.out.println("Worker " + name + " Started");
		for (int i = 0; i < 5; i++) {
			System.out.println("Worker : "  + name + " : " + i);

//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}

		System.out.println("Worker " + name + " Finished");

	}

}
