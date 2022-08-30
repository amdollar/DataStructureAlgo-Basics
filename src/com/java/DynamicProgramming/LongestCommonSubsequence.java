package com.java.DynamicProgramming;

public class LongestCommonSubsequence {

	static int[][] t = new int[20][20];

	public static void main(String[] args) {
		String text1 = "aaaaaaaa";
		String text2 = "aaaaaaaa";
//		fillMatrix();
		int lcsl = longestCommonSubsequence(text1, text2);
		System.out.println(lcsl);
	}

	private static void fillMatrix() {
		for (int i = 0; i < t[0].length; i++) {
			for (int j = 0; j < t.length; j++) {
				t[i][j] = -1;
			}
		}
	}

	public static int longestCommonSubsequence(String text1, String text2) {
		return finalMethod(text1, text1.length(), text2, text2.length());

	}

	private static int finalMethod(String text1, int l1, String text2, int l2) {
		int t[][] = new int[l1 +1][l2+1];
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

	// memoization
	/*
	 * private static int finalMethod(String text1, int l1, String text2, int l2) {
	 * if (l1 == -1 || l2 == -1) { return 0; } if (t[l1][l2] != -1) { return
	 * t[l1][l2]; }
	 * 
	 * if (text1.charAt(l1) == text2.charAt(l2)) { t[l1][l2] = 1 +
	 * finalMethod(text1, l1 - 1, text2, l2 - 1); return t[l1][l2]; } else {
	 * t[l1][l2] = Math.max(finalMethod(text1, l1 - 1, text2, l2),
	 * finalMethod(text1, l1, text2, l2 - 1)); return t[l1][l2]; } }
	 */

	/*
	 * private static int finalMethod(String text1, int length, String text2, int
	 * length2) { if (length == -1 || length2 == -1) return 0; if
	 * (text1.charAt(length) == text2.charAt(length2)) { return 1 +
	 * finalMethod(text1, length - 1, text2, length2 - 1); } else { return
	 * Math.max(finalMethod(text1, length - 1, text2, length2), finalMethod(text1,
	 * length, text2, length2 - 1)); } }
	 */

}