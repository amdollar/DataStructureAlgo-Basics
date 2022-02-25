package com.java.Tree;

import java.util.ArrayList;
import java.util.List;

public class MirrorTree {
	public static void main(String[] args) {
		TreeUtils tree = new TreeUtils();
		Node root = tree.constructTree();
		boolean isMirror = isMirror(root);
		System.out.println(isMirror);
	}

	private static boolean isMirror(Node root) {
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		System.out.println("Preorder: ");
		printPreorder(root.left, left);
		System.out.println("Postorder: ");
		printPostorder(root.right, right);
		return left.equals(right);
	}

	private static void printPostorder(Node right, List<Integer> rightList) {
		if (right == null)
			return;
		System.out.println(right.data + " ");
		rightList.add(right.data);
		printPreorder(right.right, rightList);
		printPreorder(right.left, rightList);

	}

	private static void printPreorder(Node left, List<Integer> leftList) {
		if (left == null)
			return;
		System.out.println(left.data + " ");
		leftList.add(left.data);
		printPreorder(left.left, leftList);
		printPreorder(left.right, leftList);

	}

}
