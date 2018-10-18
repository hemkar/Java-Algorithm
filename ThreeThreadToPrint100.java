package com.test.threaddemo;

/**
 * 
 * @author hemkar program to print even and odd number to using volatile
 *         variable
 */
public class ThreeThreadToPrint100 {
	static volatile Integer ai = 1;

	public static synchronized Integer getAndIncrementAi() { // to make
																// increment
																// operator
																// atomic
		return ai++;
	}

	public static synchronized Integer getAi() {
		return ai;
	}

	public static void setAi(Integer ai) {
		ThreeThreadToPrint100.ai = ai;
	}

	public static void main(String[] args) throws InterruptedException {

		Object o = new Object();

		Thread1 t1 = new Thread1(o, ai, "Thread1");
		Thread2 t2 = new Thread2(o, ai, "Thread2");
		Thread3 t3 = new Thread3(o, ai, "Thread3");
		t1.start();
		t2.start();
		t3.start();

	}
}

class Thread1 extends Thread {

	Object object;
	Integer i;

	Thread1(Object o, Integer i, String name) {
		super(name);
		this.object = o;
		this.i = i;
	}

	public void run() {
		while (ThreeThreadToPrint100.ai < 100) {
			synchronized (object) {
				System.out.println(Thread.currentThread().getName() + " Inside syncronized block with ai="
						+ ThreeThreadToPrint100.ai);
				while (ThreeThreadToPrint100.ai % 3 != 1
						&& Thread.currentThread().getName().equalsIgnoreCase("Thread1")) {
					try {
						System.out.println(Thread.currentThread().getName() + " Inside while loop with ai="
								+ ThreeThreadToPrint100.ai);
						object.wait();
						System.out.println(Thread.currentThread().getName() + " GOT NOTIFICATION With ai="
								+ ThreeThreadToPrint100.ai);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " printed===============> :"
						+ ThreeThreadToPrint100.getAndIncrementAi());
				object.notifyAll();
			}
		}
	}
}

class Thread2 extends Thread {
	Object object;
	Integer i;

	Thread2(Object o, Integer i, String name) {
		super(name);
		this.object = o;
		this.i = i;
	}

	public void run() {
		while (ThreeThreadToPrint100.ai < 100) {
			synchronized (object) {
				System.out.println(Thread.currentThread().getName() + " Inside syncronized block with ai="
						+ ThreeThreadToPrint100.ai);
				while (ThreeThreadToPrint100.ai % 3 != 2
						&& Thread.currentThread().getName().equalsIgnoreCase("Thread2")) {
					System.out.println(Thread.currentThread().getName() + " Inside while loop with ai="
							+ ThreeThreadToPrint100.ai);
					try {
						object.wait();
						System.out.println(Thread.currentThread().getName() + " GOT NOTIFICATION With ai="
								+ ThreeThreadToPrint100.ai);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " printed===============> :"
						+ ThreeThreadToPrint100.getAndIncrementAi());
				object.notifyAll();
			}
		}
	}
}

class Thread3 extends Thread {
	Object object;
	Integer i;

	Thread3(Object o, Integer i, String name) {
		super(name);
		this.object = o;
		this.i = i;
	}

	public void run() {
		while (ThreeThreadToPrint100.ai < 100) {
			synchronized (object) {
				System.out.println(Thread.currentThread().getName() + " Inside syncronized block with ai="
						+ ThreeThreadToPrint100.ai);
				while (ThreeThreadToPrint100.ai % 3 != 0
						&& Thread.currentThread().getName().equalsIgnoreCase("Thread3")) {
					System.out.println(Thread.currentThread().getName() + " Inside while loop with ai="
							+ ThreeThreadToPrint100.ai);
					try {
						object.wait();
						System.out.println(Thread.currentThread().getName() + " GOT NOTIFICATION With ai="
								+ ThreeThreadToPrint100.ai);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " printed===============> :"
						+ ThreeThreadToPrint100.getAndIncrementAi());
				object.notifyAll();
			}
		}
	}
}