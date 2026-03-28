package com.java.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {

	public static void main(String[] args) {
		TreeUtils tree = new TreeUtils();
		Node root = tree.constructTree();

//		inOrder(root);
		List<Node> res = levelOrder(root);
		for (Node node : res)
			System.out.print(node.data);
	}

	private static List<Node> levelOrder(Node root) {
		Queue<Node> q = new LinkedList<>();
		ArrayList<Node> list = new ArrayList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			Node curr = q.poll();
			list.add(curr);
			if (curr.left != null) {
				q.add(curr.left);
			}
			if (curr.right != null) {
				q.add(curr.right);
			}
		}
		return list;
	}

	private static List<Node> zigZag(Node root) {
		Queue<Node> q = new LinkedList<>();
		ArrayList<Node> list = new ArrayList<>();
		boolean flag = false;
		q.offer(root);
		while (!q.isEmpty()) {
			Node curr = q.poll();
			flag = true;
			list.add(curr);
			if (curr.left != null) {
				q.add(curr.left);
			}
			if (curr.right != null) {
				q.add(curr.right);
			}
		}
		return list;
	}

}
