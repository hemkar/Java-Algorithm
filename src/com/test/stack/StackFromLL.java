package com.test.stack;

class LinkedList {

	Node head;

	public void push(Node curr) {
		if (this.head == null) {
			head = curr;
			return;
		}
		curr.next = head;
		head = curr;
		return;
	}

	public Node pop() {
		if(head==null){
		return null;	
		}
		head = head.next;
		return head;
	}

	public void traverse(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data+" ");
			curr = curr.next;
		}
	}
	
	public void reverse(Node head){
		
		
	}

}

class Node {
	Node next;
	int data;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}

}

public class StackFromLL {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		Node n = new Node(10);
		Node n1 = new Node(20);
		Node n2 = new Node(30);
		ll.push(n);
		ll.push(n1);
		ll.push(n2);

		ll.traverse(ll.head);
		/*System.out.println("pop operationss");
		System.out.println(ll.pop().data);
		System.out.println(ll.pop().data);
		System.out.println(ll.pop());
		System.out.println(ll.pop());*/

	}

}
