package com.java.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderUsingStack {
	public static void main(String[] args) {
		TreeUtils tree = new TreeUtils();
		Node root = tree.constructTree();
		tree.printPreorder(root);
		System.out.println();
		List<Node> res = preOrderUsingStack(root);
		for (Node node : res) {
			System.out.print(node.data + " ");
		}

	}

	public static List<Node> preOrderUsingStack(Node root) {
		List<Node> res = new ArrayList<>();
		Stack<Node> st = new Stack<Node>();
		st.add(root);

		while (!st.isEmpty()) {
			Node curr = st.pop();
			res.add(curr);
			if (curr.right != null) {
				st.add(curr.right);
			}
			if (curr.left != null) {
				st.add(curr.left);
			}
		}

		return res;
	}

}
