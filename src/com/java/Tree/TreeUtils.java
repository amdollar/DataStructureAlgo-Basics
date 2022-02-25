package com.java.Tree;

import java.util.List;

public class TreeUtils {

	public Node constructTree() {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(4);
		root.right.right = new Node(3);

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
		root.right.right.left = new Node(15);
		return root;
	}

	public void printPreorder(Node node) {
		if (node == null)
			return;
		printPreorder(node.left);
		System.out.print(node.data + " ");
		printPreorder(node.right);

	}
}
