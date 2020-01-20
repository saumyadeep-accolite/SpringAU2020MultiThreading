package com.au;

import java.util.LinkedList;
import java.util.Random;

public class App2 {

	public static void main(String[] args) throws InterruptedException {
		ProducerConsumer pc = new ProducerConsumer();

		Thread producer = new Thread(() -> {
			try {
				pc.produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		Thread consumer = new Thread(() -> {
			try {
				pc.consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		producer.start();consumer.start();
	}

}

class ProducerConsumer {

	private final Object lock = new Object();
	LinkedList<Integer> buffer = new LinkedList<Integer>();
	private final int SIZE = 10;

	void produce() throws InterruptedException {
		int value = 0;

		while(true) {
			synchronized (lock) {

				if(buffer.size() == SIZE) {
					lock.wait();
				}
				buffer.add(value++);
				lock.notify();
			}
		}
	}

	void consume() throws InterruptedException {
		while (true) {
			synchronized (lock) {
				if(buffer.isEmpty()) {
					lock.wait();
				}
				int item = buffer.removeFirst();
				System.out.print("Size of Buffer : " + buffer.size() + " ");
				System.out.println("Took item " + item);
				lock.notify();
			}
			Thread.sleep(new Random().nextInt(1000));
		}
	}

}