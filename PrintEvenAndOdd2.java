package com.test.print;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintEvenAndOdd2 {
	//use AtomicInteger to make ++ operator atomic (An int value that may be updated atomically)
	static AtomicInteger ai = new AtomicInteger(1);
	// static volatile Integer ai=1;//We cant use Volatile as ++ operator need
	// to be atomic so use AtomicInteger

	public static void main(String[] args) throws InterruptedException {
		
		Object o = new Object();// Used for locking 

		Even2 e2 = new Even2(o, ai, "EVEN THREAD");//lock, AtomicInteger, Name of thread (parameter passed)
		Odd2 o2 = new Odd2(o, ai, "ODD THREAD");//lock, AtomicInteger, Name of thread (parameter passed)
		e2.start();
		o2.start();
	}
}

class Even2 extends Thread {

	Object object;
	AtomicInteger i;

	Even2(Object o, AtomicInteger i, String name) {
		super(name);// Set Thread name
		this.object = o;
		this.i = i;
	}

	public void run() {
		while (i.get() < 10) {
			synchronized (object) {	// Synchronization
				System.out.println("Even thread line 36 inside synchronized block"); //Just to check id thread got lock or not.
				while (i.get() % 2 != 0) {
					try {
						System.out.println("Even thread line 39 going to wait because no is odd " + i);
						object.wait(); // wait for notification if no is ODD since this thread is suppose to print even no alone.
						System.out.println(Thread.currentThread().getName() + " GOT NOTIFICATION");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " printed :" + i.getAndIncrement());
				object.notifyAll(); //Notify ODD thread for printing odd no.
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
				System.out.println("Odd thread line 66 inside synchronized block");//Just to check id thread got lock or not.
				while (i.get() % 2 == 0) {
					System.out.println("Odd thread line 68 going to wait becaue no is even " + i);
					try {
						object.wait();// wait for notification if no is EVEN since this thread is suppose to print ODD no alone.
						System.out.println(Thread.currentThread().getName() + " GOT NOTIFICATION");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Odd thread line 76");
				System.out.println(Thread.currentThread().getName() + " printed :" + i.getAndIncrement());
				object.notifyAll();//Notify EVEN thread for printing EVEN no.
			}
		}
	}
}
