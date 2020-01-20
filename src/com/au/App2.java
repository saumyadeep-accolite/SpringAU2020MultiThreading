package com.au;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

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

		Thread producer2 = new Thread(() -> {
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

		producer.start();producer2.start();consumer.start();
	}

}

class ProducerConsumer {

	private final Object lock = new Object();
	BlockingQueue<Integer> buffer = new LinkedBlockingDeque<>(10);

	void produce() throws InterruptedException {
		int value = 0;

		while(true) {
			buffer.put(value++);
		}
	}

	void consume() throws InterruptedException {
		while (true) {

			Integer item = buffer.poll();

			System.out.print("Size of Buffer : " + buffer.size() + " ");
			System.out.println("Took item " + item);

			Thread.sleep(new Random().nextInt(1000));
		}
	}

}