package com.java.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
	public static void main(String[] args) {
		TreeUtils tree = new TreeUtils();
		Node root = tree.constructTree();

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
