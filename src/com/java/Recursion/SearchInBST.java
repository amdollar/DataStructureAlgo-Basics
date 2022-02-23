package com.java.Recursion;

public class SearchInBST {

	public static void main(String[] args) {
		TreeNode root = createTree();
//		printTreeInOrder(root);
		int searchval = 14;
		TreeNode subTree = searchBST(root, searchval);
		printTreeInOrder(subTree);
	}

	private static TreeNode searchBST(TreeNode root, int searchval) {
		if (root != null) {
			if (searchval > root.val) {
				return searchBST(root.right, searchval);
			} else if (searchval < root.val) {
				return searchBST(root.left, searchval);
			} else if (searchval == root.val) {
				return root;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	private static void printTreeInOrder(TreeNode root) {
		if (root != null) {
			System.out.println(root.val);
			printTreeInOrder(root.left);
			printTreeInOrder(root.right);
		}
	}

	private static TreeNode createTree() {
		TreeNode root = new TreeNode(4);
		TreeNode one = new TreeNode(2);
		TreeNode two = new TreeNode(7);
		root.left = one;
		root.right = two;

		TreeNode one1 = new TreeNode(1);
		TreeNode two2 = new TreeNode(3);
		one.left = one1;
		one.right = two2;

		return root;
	}

}
