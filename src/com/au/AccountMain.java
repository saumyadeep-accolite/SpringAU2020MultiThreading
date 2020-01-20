package com.au;

public class AccountMain {

	private static Object lock = new Object();
	public static void main(String[] args) throws InterruptedException {

		Account account = new Account(50);

		Thread t1 = new Thread(() -> {
			while(account.getBalance() > 0) {
				withdraw(account, 10);
			}
		});

		Thread t2 = new Thread(() -> {
			while(account.getBalance() > 0) {
				withdraw(account, 10);
			}
		});

		t1.start();t2.start();
		t1.join();t2.join();

		System.out.println("Final Balance : " + account.getBalance());

	}

	static void withdraw(Account account, int amount) {

		synchronized (lock) {
			if(account.getBalance() >= amount) {
				account.withdraw(amount);
			}
		}
	}
}
