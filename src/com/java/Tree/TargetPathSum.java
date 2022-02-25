package com.java.Tree;

public class TargetPathSum {

	public static void main(String[] args) {
		TreeUtils tree = new TreeUtils();
		Node root = tree.constructTree();
		System.out.println(pathSum(root, 6));
	}

	private static boolean pathSum(Node root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null && sum - root.data == 0) {
			return true;
		}
		return pathSum(root.left, sum - root.data) || pathSum(root.right, sum - root.data);

	}

}
