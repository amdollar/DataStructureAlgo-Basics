package com.java.Tree;

public class PrintRange {

	public static void main(String[] args) {
		TreeUtils tree = new TreeUtils();
		Node root = tree.getBinaryTree();
		tree.printPreorder(root);
		System.out.println("Printing Range");
		printRange(root, 5, 12);
	}

//1
	private static void printRange(Node root, int start, int end) {
		if (root == null) {
			return;
		}
		if (root.data >= start && root.data <= end) {
			printRange(root.left, start, end);
			System.out.print(root.data + " , ");
			printRange(root.right, start, end);
		} else if (root.data > start) {
			printRange(root.left, start, end);
		} else if (root.data < start) {
			printRange(root.right, start, end);
		}
	}

}
