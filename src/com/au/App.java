package com.au;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {

	private final Object lock1 = new Object();
	private final Object lock2 = new Object();

	private List<Integer> list1 = new ArrayList<>();
	private List<Integer> list2 = new ArrayList<>();

	private void stageOne() {
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list1.add(new Random().nextInt());
		}
	}
	private void stageTwo() {

		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list2.add(new Random().nextInt());
		}
	}

	private void process() {
		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}
	}

	public static void main(String[] args) throws InterruptedException {

		App app = new App();
		app.doWork();
	}

	public void doWork() throws InterruptedException {

		Long start = System.currentTimeMillis();

		Thread t1 = new Thread(() -> process());
		Thread t2 = new Thread(() -> process());

		t1.start();t2.start();

		t1.join();t2.join();

		Long end = System.currentTimeMillis();

		System.out.println("List 1 size: " + list1.size());
		System.out.println("List 2 size: " + list2.size());
		System.out.println("Took " + (end - start) + " ms");
	}

}
