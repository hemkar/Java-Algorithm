package com.test.linkedlist;

public class LinkedList {

	Node head;

	public void insertFirst(Node node){
		node.link=head;
		head=node;
	}
	
	public void insertlast(Node node){
		Node temp=head;
		while(temp.link!=null){
			temp=temp.link;
			System.out.println(temp);
		}
		
		temp.link=node;
	}

	public void iterate(Node head) {
		while (head != null) {
			System.out.print(head.data+" ");
			head = head.link;
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		/*list.head = new Node(10);
		Node second = new Node(20);
		Node third = new Node(30);
		list.head.next = second;
		second.next = third;*/
		list.insertFirst(new Node(10));
		list.insertFirst(new Node(20));
		list.insertFirst(new Node(30));
		list.insertFirst(new Node(40));
		list.insertlast(new Node(100));
		list.iterate(list.head);

	}

}


class Node {
	int data;
	Node link;

	Node(int data) {
		this.data = data;
		link = null;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + link + "]";
	}
	
	
}