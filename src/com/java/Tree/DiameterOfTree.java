package com.java.Tree;

/*
 * Diameter of a tree is nothing but the maximum path between two nodes.
 * This may or may not pass via the Root node.
 */
public class DiameterOfTree {

	public static void main(String[] args) {
		TreeUtils tree = new TreeUtils();
		Node root = tree.constructUnBalancedTree();
		int[] max = new int[1];
		findDiameterOfTree(root, max);
		System.out.println(max[0]);
	}

	private static int findDiameterOfTree(Node root, int[] max) {
		if (root == null)
			return 0;
		// grab the left height for current node
		int leftH = findDiameterOfTree(root.left, max);
		// grab the right height for current node
		int rightH = findDiameterOfTree(root.right, max);
		// using left and right heights calculate the path for current left and right
		// and assign it to max if current max is > than old max
		max[0] = Math.max(max[0], rightH + leftH);
		return 1 + Math.max(leftH, rightH);
	}

}
