package com.java.DynamicProgramming;

public class TransformToPalindrome {

	public static void main(String[] args) {
		String str = new String("geeksforgeeks");
		int res = longestPalindromeSubseq(str, str.length());
		System.out.println(res);

	}

	private static int longestPalindromeSubseq(String str, int length) {
		StringBuilder sb = new StringBuilder(str);
		String str2 = sb.reverse().toString();
		int res = findLongestCommonSubsequence(str, str2, length, str2.length());
		
		return length - res;
	}

	private static int findLongestCommonSubsequence(String text1, String text2, int l1, int l2) {
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
