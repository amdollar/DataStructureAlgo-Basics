package com.java.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	Node root;

	public void printLevelOrder() {
		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			int leng = q.size();
			for (int i = 1; i <= leng; i++) {
				Node tempNode = q.poll();
				if (i == 1) {
					System.out.println(tempNode.data);
				}
				if (tempNode.left != null) {
					q.add(tempNode.left);
				}
				if (tempNode.right != null) {
					q.add(tempNode.right);
				}
			}
		}
	}
}
