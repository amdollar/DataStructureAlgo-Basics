package com.java.Tree;

public class TreeUtils {

	public Node constructTree() {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		return root;
	}

	public Node constructTreeTwo() {
		Node root = new Node(2);
		root.right = new Node(1);
//		root.right = new Node(3);
//		root.left.left = new Node(4);
//		root.left.right = new Node(5);
//		root.right.left = new Node(6);
//		root.right.right = new Node(7);

		return root;
	}

	public Node constructUnBalancedTree() {
		Node root = new Node(-10);
		root.left = new Node(9);
		root.right = new Node(20);
		root.right.right = new Node(7);
		root.right.left = new Node(15);
		return root;
	}

	public Node getBinaryTree() {
		Node root = new Node(8);
		root.left = new Node(3);
		root.right = new Node(10);
		root.left.left = new Node(1);
		root.left.right = new Node(6);
		root.left.right.left = new Node(4);
		root.left.right.right = new Node(7);

		root.right.left = null;
		root.right.right = new Node(14);
		root.right.right.left = new Node(13);
		return root;
	}

	public void printPreorder(Node node) {
		if (node == null)
			return;

		System.out.print(node.data + " ");
		printPreorder(node.left);
		printPreorder(node.right);

	}

	public void printInorder(Node node) {

		if (node == null)
			return;
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);

	}

	public void printPostorder(Node node) {

		if (node == null)
			return;
		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.data + " ");

	}
}
