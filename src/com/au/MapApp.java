package com.au;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MapApp {
	public static void main(String[] args) throws InterruptedException {

		Object lock = new Object();
		ConcurrentMap<Integer, Integer> map = new ConcurrentHashMap<>();

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				map.put(i,i);
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 1000; i < 2000; i++) {
				map.put(i, i);
			}
		});

		t1.start();t2.start();

		t1.join();t2.join();

		System.out.println("Size of Map " + map.size());
	}

}

