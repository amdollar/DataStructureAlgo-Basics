package com.java.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderUsingStack {

	public static void main(String[] args) {
		TreeUtils tree = new TreeUtils();
		Node root = tree.constructTree();
		tree.printInorder(root);
		System.out.println();
		List<Node> res = inorderUsingStack(root);
		for (Node node : res) {
			System.out.print(node.data + " ");
		}

	}

	private static List<Node> inorderUsingStack(Node root) {
		List<Node> res = new ArrayList<>();
		Stack<Node> st = new Stack<>();
//		st.add(root);
		while (true) {
			if (root != null) {
				st.add(root);
				root = root.left;
			} else {
				if (st.isEmpty()) {
					break;
				}
				root = st.pop();
				res.add(root);
				root = root.right;
			}
		}

		return res;
	}

}
