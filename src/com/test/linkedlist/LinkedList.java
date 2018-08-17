package com.test.linkedlist;

public class LinkedList {

	Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public void iterate(Node head) {
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.head = new Node(10);
		Node second = new Node(20);
		Node third = new Node(30);
		list.head.next = second;
		second.next = third;
		list.iterate(list.head);

	}

}
