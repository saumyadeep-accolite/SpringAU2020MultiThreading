package com.au;

public class App {

	public static void main(String[] args) {

		Thread worker = new Thread(new Worker2());
		worker.start();


	}
}
