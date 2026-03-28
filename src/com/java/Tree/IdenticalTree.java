package com.java.Tree;

public class IdenticalTree {

	public static void main(String[] args) {
		TreeUtils tu = new TreeUtils();
		Node root = tu.constructTree();
		Node dup = tu.constructTree();
		boolean ifIdentical = isIdentical(root, dup);
		System.out.println(ifIdentical);
	}

	private static boolean isIdentical(Node p, Node q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		if (p.data != q.data) {
			return false;
		}

		return isIdentical(p.left, q.left) && isIdentical(p.right, q.right);
	}

}
