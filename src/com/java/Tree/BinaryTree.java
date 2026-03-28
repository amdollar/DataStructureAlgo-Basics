package com.java.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	public static void printLevelOrder(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			int leng = q.size();
			for (int i = 1; i <= leng; i++) {
				Node tempNode = q.poll();

				System.out.print(tempNode.data);

				if (tempNode.left != null) {
					q.add(tempNode.left);
				}
				if (tempNode.right != null) {
					q.add(tempNode.right);
				}
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		TreeUtils tu = new TreeUtils();
		Node root = tu.constructTree();
//		tu.printInorder(root);
		printLevelOrder(root);
	}
}
