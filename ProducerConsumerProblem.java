package com.test.print;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerProblem {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();

		Integer i = 0;
		Producer producer = new Producer(q, i);
		Consumer consumer = new Consumer(q, i);

		producer.start();
		consumer.start();
	}

}

class Producer extends Thread {

	Queue<Integer> q;
	Integer i;

	public Producer(Queue<Integer> q, Integer i) {
		super();
		this.q = q;
		this.i = i;
	}

	public void run() {
		while (true) {
			synchronized (q) {
				while (q.size() > 5) {
					try {
						System.out.println("Q is Full " + Thread.currentThread().getName() + " is waiting.");
						q.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					System.out.println(Thread.currentThread().getName() + " " + " added " + i + " " + q.add(i++));
					q.notifyAll();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}

	}
}

class Consumer extends Thread {
	Queue<Integer> q;
	Integer i;

	public Consumer(Queue<Integer> q, Integer i) {
		super();
		this.q = q;
		this.i = i;
	}

	public void run() {

		while (true) {
			synchronized (q) {
				while (q.size() == 0) {
					try {
						System.out.println("Q is empty " + Thread.currentThread().getName() + " is waiting.");
						q.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				try {
					System.out.println(Thread.currentThread().getName() + " removed: " + q.poll());
					q.notifyAll();
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}

	}
}
