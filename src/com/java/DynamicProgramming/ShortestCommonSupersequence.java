package com.java.DynamicProgramming;

public class ShortestCommonSupersequence {
// Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. Print the length of that string. 
	public static void main(String[] args) {
		String s1 = "abac";
		String s2 = "cab";
		int m = s1.length(), n = s2.length();
		int res = shortestCommonSupersequence(s1, s2, m, n);
		System.out.println(res);
	}

// abac cab -> cabac 
	// cabac is nothing but longest common subsequence between two (ab) 2 + chars
	// apart from this subsrquence in both strs ac c 3 = 5
	private static int shortestCommonSupersequence(String s1, String s2, int m, int n) {
		int len = findLongestCommonsubsequence(s1, s2, m, n);
		int res = Math.abs(s1.length() - len); //2
		int finalres = Math.abs(s2.length() - len); //1
		return res + finalres + len;
	}

	private static int findLongestCommonsubsequence(String s1, String s2, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
			return 1 + findLongestCommonsubsequence(s1, s2, m - 1, n - 1);
		} else {
			return Math.max(findLongestCommonsubsequence(s1, s2, m - 1, n),
					findLongestCommonsubsequence(s1, s2, m, n - 1));
		}
	}

}
