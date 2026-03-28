package com.java.Tree;

public class MaximumPathSum {

	public static void main(String[] args) {
		TreeUtils tree = new TreeUtils();
		Node root = tree.constructUnBalancedTree();
		maxsum = Integer.MIN_VALUE;
		findMaxSum(root);
		System.out.println(maxsum);
	}

	private static int maxsum = 0;

	private static int findMaxSum(Node root) {
		if (root == null)
			return 0;
		// to ignore the -ve values in path, we need to take 0 as input if path sum is
		// -ve
		int left = Math.max(findMaxSum(root.left), 0);
		int right = Math.max(findMaxSum(root.right), 0);

		maxsum = Math.max(maxsum, root.data + left + right);

		return Math.max(root.data + left, root.data + right);
	}
}
