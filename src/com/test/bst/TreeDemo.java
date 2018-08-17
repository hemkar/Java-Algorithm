package com.test.bst;

import java.util.LinkedList;
import java.util.Queue;

public class TreeDemo {

	public static void main(String[] args) {

		Tree t = new Tree();

		t.findMin();
		t.findMax();

		t.insert(10);
		t.insert(20);
		t.insert(5);
		t.insert(4);
		t.insert(25);
		t.insert(21);
		t.insert(26);
		System.out.println("Tree created.........");

		t.findMin();
		t.findminRecursively(t.root);
		t.findmaxRecursively(t.root);
		t.findMax();

		System.out.println("hight of tree: " + t.getHight(t.root));
		System.out.println("\nBFS traversal");
		t.bfsTraversal(t.root);
		System.out.println("\n\nlevel order BFS traversal");
		t.levelBfsTraversal(t.root);

		System.out.println("\nis tree BST");
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		System.out.println(t.isBst(t.root, min, max));
		System.out.println("\nfind common ancestor");
		System.out.println(t.findAncestor(t.root, new Node(26), new Node(21)));
	}
}

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
	}

}

class Tree {
	Node root;

	public Tree() {
		this.root = null;
	}

	public void findminRecursively(Node root) {

		if (root == null) {
			System.out.println("tree is empty");
			return;
		}
		if (root.left == null) {
			System.out.println("Min value recursively " + root.data);
			return;
		}
		findminRecursively(root.left);

	}

	public void findMax() {
		Node current = root;
		if (current == null) {
			System.out.println("tree is empty");
			return;
		}

		while (current.right != null) {
			current = current.right;
		}
		System.out.println("Max value: " + current.data);
	}

	public void findmaxRecursively(Node root) {
		if (root == null) {
			System.out.println("tree is empty ");
			return;
		}

		if (root.right == null) {
			System.out.println("max value recursively :" + root.data);
		}
		findmaxRecursively(root.right);
	}

	public void findMin() {
		Node current = root;
		if (current == null) {
			System.out.println("tree is empty");
			return;
		}
		while (true) {
			Node parent = current;
			current = current.left;
			if (current == null) {
				System.out.println("Minimum value in tree: " + parent.data);
				return;
			}
		}

	}

	public void insert(int data) {
		Node n = new Node(data);

		if (root == null) {
			root = n;
		} else {
			Node current = root;
			while (true) {
				Node parent = current;
				if (current.data > data) {
					current = current.left;
					if (current == null) {
						parent.left = n;
						return;
					}
				} else {
					current = current.right;
					if (current == null) {
						parent.right = n;
						return;
					}

				}
			}
		}
	}

	public int getHight(Node root) {

		if (root == null) {
			return -1;
		}

		int h1 = getHight(root.left);
		int h2 = getHight(root.right);

		return Math.max(h1, h2) + 1;
	}

	public void bfsTraversal(Node root) {
		if (root == null) {
			return;
		}

		Queue<Node> q = new LinkedList();
		q.add(root);
		while (q.size() != 0) {
			root = (Node) q.poll();
			System.out.print(root.data + ",");
			if (root.left != null) {
				q.add(root.left);
			}

			if (root.right != null) {
				q.add(root.right);
			}
		}

	}

	public void levelBfsTraversal(Node root) {
		if (root == null) {
			return;
		}

		Queue<Node> q = new LinkedList();
		q.add(root);
		q.add(null);
		while (q.size() != 0) {
			root = (Node) q.poll();
			if (root == null) {
				if (q.size() != 0) {
					q.add(null);
					System.out.println();
				}
			} else {
				System.out.print(root.data + " ");

				if (root.left != null) {
					q.add(root.left);
				}

				if (root.right != null) {
					q.add(root.right);
				}
			}
		}

	}

	// method to check if binary tree is BST
	public boolean isBst(Node root, int min, int max) {

		if (root == null) {
			return true;
		}

		if (root.data < min || root.data > max) {
			return false;
		}

		return isBst(root.left, min, root.data) && isBst(root.right, root.data, max);

	}
	
	//method to find lowest common ancestor
	public int findAncestor(Node root,Node n1,Node n2){
		
		if(root.data > Integer.max(n1.data, n2.data)){
			return findAncestor(root.left, n1, n2);
		}else if(root.data < Integer.min(n1.data, n2.data)){
			return findAncestor(root.right, n1, n2);
		 }
		return root.data;
		}
	   

}