package com.java.Tree;

public class HeightOfTree {

	public static void main(String[] args) {
		TreeUtils tree = new TreeUtils();
		Node root = tree.constructTree();
		int height = getHeight(root);
		System.out.println(height);
	}

	private static int getHeight(Node root) {
		if (root == null) {
			return 0;
		}
		int h1 = getHeight(root.left);
		int h2 = getHeight(root.right);
		return 1 + Math.max(h1, h2);
	}

}
