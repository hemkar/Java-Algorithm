package com.test.threaddemo;

/**
 * 
 * @author hemkar program to print even and odd number to using volatile
 *         variable
 */
public class EvevOddVolatile {
	static volatile Integer ai = 1;

	public static synchronized Integer getAndIncrementAi() { // to make increment operator atomic
		return ai++;
	}

	public static synchronized Integer getAi() {
		return ai;
	}

	public static void setAi(Integer ai) {
		EvevOddVolatile.ai = ai;
	}

	public static void main(String[] args) throws InterruptedException {

		Object o = new Object();

		Even2 e2 = new Even2(o, ai, "EVEN THREAD");
		Odd2 o2 = new Odd2(o, ai, "ODD THREAD");
		o2.start();
		e2.start();

	}
}

class Even2 extends Thread {

	Object object;
	Integer i;

	Even2(Object o, Integer i, String name) {
		super(name);
		this.object = o;
		this.i = i;
	}

	public void run() {
		while (EvevOddVolatile.ai < 10) {
			synchronized (object) {
				// i = EevOddVolatile.getAi();
				System.out.println(
						Thread.currentThread().getName() + " Inside syncronized block with ai=" + EvevOddVolatile.ai);
				while (EvevOddVolatile.ai % 2 != 0) {
					try {
						System.out.println(
								Thread.currentThread().getName() + " Inside while loop with ai=" + EvevOddVolatile.ai);
						object.wait();
						System.out.println(
								Thread.currentThread().getName() + " GOT NOTIFICATION With ai=" + EvevOddVolatile.ai);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out
						.println(Thread.currentThread().getName() + " printed :" + EvevOddVolatile.getAndIncrementAi());
				object.notifyAll();
			}
		}
	}
}

class Odd2 extends Thread {
	Object object;
	Integer i;

	Odd2(Object o, Integer i, String name) {
		super(name);
		this.object = o;
		this.i = i;
	}

	public void run() {
		while (EvevOddVolatile.ai < 10) {
			synchronized (object) {
				// i = EevOddVolatile.getAi();
				System.out.println(
						Thread.currentThread().getName() + " Inside syncronized block with ai=" + EvevOddVolatile.ai);
				while (EvevOddVolatile.ai % 2 == 0) {
					System.out.println(
							Thread.currentThread().getName() + " Inside while loop with ai=" + EvevOddVolatile.ai);
					try {
						object.wait();
						System.out.println(
								Thread.currentThread().getName() + " GOT NOTIFICATION With ai=" + EvevOddVolatile.ai);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out
						.println(Thread.currentThread().getName() + " printed :" + EvevOddVolatile.getAndIncrementAi());
				object.notifyAll();
			}
		}
	}
}