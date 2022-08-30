package com.java.DynamicProgramming;
// https://www.geeksforgeeks.org/longest-common-substring-dp-29/
public class LongestCommonSubString {

	public static void main(String[] args) {
		String st1 = "GeeksforGeeks";
		String st2 = "GeeksQuiz";
		int l1 = st1.length();
		int l2 = st2.length();
		int res = longestCommonSubStringTD(st1, st2, l1, l2);
		System.out.println(res);
	}

	private static int longestCommonSubStringTD(String s1, String s2, int l1, int l2) {
		int maxLen = Integer.MIN_VALUE;
		int[][] t = new int[l1 + 1][l2 + 1];

		for (int i = 1; i <= l1; i++) {
			for (int j = 1; j <= l2; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					t[i][j] = 1 + t[i - 1][j - 1];
				} else {
					t[i][j] = 0;
				}
				maxLen = Math.max(maxLen, t[i][j]);
			}
		}
		return maxLen;
	}
}
