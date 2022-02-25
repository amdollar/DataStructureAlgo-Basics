package com.java.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
	public static void main(String[] args) {
		Node root = new Node(1);
		Node left = new Node(2);
		Node right = new Node(3);
		root.left = left;
		root.right = right;

		Node left1 = new Node(4);
		Node right1 = new Node(5);
		left.left = left1;
		left.right = right1;

		Node right2 = new Node(6);
		right.right = right2;
		Node left3 = new Node(7);
		right1.left = left3;

//		inOrder(root);
		levelOrder(root);
	}

	private static void levelOrder(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.println(temp.data);
			if (temp.left != null) {
				queue.offer(temp.left);
			}
			if (temp.right != null) {
				queue.offer(temp.right);
			}
		}

	}

	private static void inOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.println(root.data);
		inOrder(root.left);
		inOrder(root.right);
	}
}
