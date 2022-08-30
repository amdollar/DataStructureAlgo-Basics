package com.java.DynamicProgramming;

public class TransformString {
// Heap, pea -> 2 insertion (hp) 1 deletion (p)
	public static void main(String[] args) {
		String s1 = "heap";
		String s2 = "pea";
		int m = s1.length();
		int n = s2.length();
		minInsertionDeletion(s1, s2, m, n);
	}

	private static void minInsertionDeletion(String s1, String s2, int m, int n) {
		int len = longestcommonsybsequence(s1, s2, m, n);
//		System.out.println(len);
		int insertions = s1.length() - len;
		int updations = s2.length() - len;
		System.out.println(insertions +"," + updations);
	}

	private static int longestcommonsybsequence(String text1, String text2, int l1, int l2) {
		int t[][] = new int[l1 + 1][l2 + 1];
		for (int i = 0; i <= l1; i++) {
			t[i][0] = 0;
		}
		for (int i = 0; i <= l2; i++) {
			t[0][i] = 0;
		}
		for (int i = 1; i <= l1; i++) {
			for (int j = 1; j <= l2; j++) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					t[i][j] = 1 + t[i - 1][j - 1];
				} else {
					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
				}
			}
		}

		return t[l1][l2];
	}

}
