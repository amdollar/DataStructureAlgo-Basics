package com.java.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderUsingStack {

	public static void main(String[] args) {
		TreeUtils tree = new TreeUtils();
		Node root = tree.constructTree();
		tree.printPostorder(root);
		System.out.println();
		List<Node> res = postOrderUsingStack(root);
		for (Node node : res) {
			System.out.print(node.data + " ");
		}

	}

	private static List<Node> postOrderUsingStack(Node root) {
		List<Node> res = new ArrayList<>();
		Stack<Node> st = new Stack();
		Node curr = root;
		while (!st.isEmpty() || curr != null) {
			if (curr != null) {
				st.add(curr);
				curr = curr.left;
			} else {
				Node temp = st.peek().right;
				if (temp == null) {
					temp = st.pop();
					res.add(temp);
					while (!st.isEmpty() && temp == st.peek().right) {
						temp = st.peek();
						st.pop();
						res.add(temp);
					}
				} else {
					curr = temp;
				}

			}
		}

		return res;
	}

}
