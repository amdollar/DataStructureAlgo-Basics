package com.java.Tree;

import java.util.ArrayList;
import java.util.List;

public class RootToLeaf {

	public static void main(String[] args) {
		TreeUtils tree = new TreeUtils();
		Node root = tree.getBinaryTree();
		List<String> paths = printAllRootToLeaf(root);
		paths.stream().forEach(System.out::println);
	}

	private static List<String> printAllRootToLeaf(Node root) {
		List<String> paths = new ArrayList<>();
		if (root == null) {
			return paths;
		}
		dfs(root, "", paths);
		return paths;
	}

	private static void dfs(Node root, String path, List<String> paths) {
		path += root.data;
		if (root.left == null && root.right == null) {
			paths.add(path);
			return;
		}
		if (root.left != null) {
			dfs(root.left, path, paths);
		}
		if (root.right != null) {
			dfs(root.right, path, paths);
		}
	}

}
