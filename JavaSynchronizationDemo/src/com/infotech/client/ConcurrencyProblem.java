package com.infotech.client;
public class ConcurrencyProblem {
	static int[] array = { 0 };
	public static void main(String[] args) throws InterruptedException {
		
		final ConcurrencyProblem concurrencyProblem = new ConcurrencyProblem();
		Thread a = new Thread("A") {
			public void run() {
				for (int i = 1; i <= 1000; i++) {
					concurrencyProblem.increase();
				}
			}
		};
		Thread b = new Thread("B") {
			public void run() {
				for (int i = 1; i <= 1000; i++) {
					concurrencyProblem.decrease();
				}
			}
		};
		a.start();
		b.start();
		a.join();
		b.join();
		System.out.println(array[0]);
	}
	public synchronized  void increase() {
			array[0]++;
	}
	public synchronized void decrease() {
			array[0]--;
	}
}