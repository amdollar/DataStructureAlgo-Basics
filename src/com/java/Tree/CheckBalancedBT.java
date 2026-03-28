package com.java.Tree;

/*
 * A Binary Tree is a Balanced BT if the diff 
 * b/w it's left subtree and right subtree is not greater than 1;
 *  if(abs(lh - rh) > 1) == false 
 */
public class CheckBalancedBT {

	public static void main(String[] args) {
		TreeUtils tree = new TreeUtils();
		Node root = tree.constructUnBalancedTree();
		int isBalanced = checkIfBalancedBT(root);
		System.out.println(isBalanced);
		System.out.println(isBalanced != -1);

	}

	private static int checkIfBalancedBT(Node root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = checkIfBalancedBT(root.left);
		if (leftHeight == -1) {
			return -1;
		}
		int rightHeight = checkIfBalancedBT(root.right);
		if (rightHeight == -1)
			return -1;

		if (Math.abs(rightHeight - leftHeight) > 1) {
			return -1;
		}
		return 1 + Math.max(leftHeight, rightHeight);
	}

}
