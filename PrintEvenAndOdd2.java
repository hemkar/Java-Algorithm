package com.test.print;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintEvenAndOdd2 {
	static AtomicInteger ai = new AtomicInteger(1);
	// static volatile Integer ai=1;//We cant use Volatile as ++ operator need
	// to be atomic so use AtomicInteger

	public static void main(String[] args) throws InterruptedException {

		Object o = new Object();

		Even2 e2 = new Even2(o, ai, "Even");
		Odd2 o2 = new Odd2(o, ai, "Odd");
		e2.start();
		o2.start();
	}
}

class Even2 extends Thread {

	Object object;
	AtomicInteger i;

	Even2(Object o, AtomicInteger i, String name) {
		super(name);
		this.object = o;
		this.i = i;
	}

	public void run() {
		while (i.get() < 10) {
			synchronized (object) {
				System.out.println("Even thread line 35 inside synchronized block");
				while (i.get() % 2 != 0) {
					try {
						System.out.println("Even thread line 38 going to wait because no is odd " + i);
						object.wait();
						System.out.println(Thread.currentThread().getName() + " GOT NOTIFICATION");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " printed :" + i.getAndIncrement());
				object.notifyAll();
			}
		}
	}
}

class Odd2 extends Thread {
	Object object;
	AtomicInteger i;

	Odd2(Object o, AtomicInteger i, String name) {
		super(name);
		this.object = o;
		this.i = i;
	}

	public void run() {
		while (i.get() < 10) {
			synchronized (object) {
				System.out.println("Odd thread line 65 inside synchronized block");
				while (i.get() % 2 == 0) {
					System.out.println("Odd thread line 67 going to wait becaue no is even " + i);
					try {
						object.wait();
						System.out.println(Thread.currentThread().getName() + " GOT NOTIFICATION");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Odd thread line 75");
				System.out.println(Thread.currentThread().getName() + " printed :" + i.getAndIncrement());
				object.notifyAll();
			}
		}
	}
}
