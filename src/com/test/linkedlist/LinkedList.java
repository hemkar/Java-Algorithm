package com.test.linkedlist;

import java.util.Stack;

public class LinkedList {

	Node head;

	public void insertFirst(Node node) {
		node.next = head;
		head = node;
	}

	public void insertlast(Node node) {
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
			System.out.println(temp);
		}

		temp.next = node;
	}

	public void iterate(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	private void insertAt(Node node, int i) {
		if(i==1){
			node.next=head;
			head = node;
			return;
		}
		Node temp=head;
		for(int j=1;j<=i-2;j++){
			temp=temp.next;
		}
		node.next=temp.next;
		temp.next=node;
	}
	
	private void deleteAt(int i) {
		
		if(i==1){
			head=head.next;
			return;
		}
		Node temp=head,curr=head;
		for(int j=0;j<i-2;j++){
			temp=temp.next;
		}
		System.out.println("temp :"+temp.data+" curr: "+curr.data);
		
		temp.next= temp.next.next;
	}

	public Node reverseLinkedList(Node head){
		
		Node current=head;
		Node prev=null;
		Node next=head;
		
		while(current !=null){
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		head=prev;
		return head;
		
	}
	
	/**
	 * step 1 : reach till end 
	 * step 2: point head to last node
	 * Step 3: for rest of node reverse the link
	 * @param head
	 * @return
	 */
	
	Node head1;
	public void reverseRecusiverly(Node head){
		Node temp=head;
		
		if(temp.next==null){
			head1=temp;
			return;
		}
		//temp=temp.next;
		reverseRecusiverly(temp.next);
		Node n= temp.next;
		n.next=temp;
		temp.next=null;
	}
	
	Stack<Node> s= new Stack<>();
	public void pushToStack(Node head) {
		while (head != null) {
			s.push(head);
			head = head.next;
		}
	}
	public void reverseUsingStack(){
		
		Node temp= s.pop();
		head=temp;
		temp=temp.next;
		while(!s.isEmpty()){
			temp.next=s.pop();
			temp= temp.next;
		}
		temp.next=null;
	}
	
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		/*
		 * list.head = new Node(10); Node second = new Node(20); Node third =
		 * new Node(30); list.head.next = second; second.next = third;
		 */
		list.insertFirst(new Node(10));
		list.insertFirst(new Node(20));
		list.insertFirst(new Node(30));
		list.insertFirst(new Node(40));
		list.insertlast(new Node(100));
		list.iterate(list.head);
		System.out.println("\n");
		/*System.out.println("going to insert at nth");
		list.insertAt(new Node(200), 1);
		list.insertAt(new Node(300), 2);*/
		
		//list.deleteAt(1);
		
		//Node head=list.reverseLinkedList(list.head);
		list.reverseRecusiverly(list.head);
		System.out.println("After reversing");
		list.iterate(list.head);
		
		list.reverseRecusiverly(list.head);
		list.iterate(list.head);
		
		System.out.println("reverse using stack");
		list.pushToStack(list.head);
		list.reverseUsingStack();
		list.iterate(list.head);
	}


}

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		next = null;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}

}