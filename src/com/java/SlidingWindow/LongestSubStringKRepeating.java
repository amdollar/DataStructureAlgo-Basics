package com.java.SlidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LongestSubStringKRepeating {

	public static void main(String[] args) {
		String str = new String("ababacb");
		int k = 2;
		int res = longestSubstring(str, k);
		System.out.println(res);

	}

	private static int longestSubstring(String str, int k) {
		Map<Character, Integer> map = new HashMap<>();
//		int feq[] = new int[26];
//		for (char ch : str.toCharArray()) {
//			feq[ch - 'a']++;
//		}
		int i = 0;
		int j = 0;
		int res = 0;
		int totalK = 0;
		while (j < str.length()) {
			char curr = str.charAt(j);
			map.put(curr, map.getOrDefault(curr, 0) + 1);
			if (j - i + 1 >= k) {
				// result could be found
				int allK = 0;
				for (Map.Entry<Character, Integer> ent : map.entrySet()) {
					if (ent.getValue() >= k) {
						allK++;
					}
				}
				if (allK == map.size()) {
					res = Math.max(res, j - i + 1);
					j++;
				}
			} else {
				j++;
			}

		}

		return 0;
	}

	// using feq array
	/*
	 * public static int longestSubstring(String s, int k) { int feq[] = new
	 * int[26]; for (char ch : s.toCharArray()) { feq[ch - 'a']++; } int i = 0; int
	 * j = 0; int max = 0; while (j < s.length()) { char curr = s.charAt(j); int
	 * cfeq = feq[curr - 'a']; if (cfeq < k) { i = j + 1; j++; } else if (cfeq >= k)
	 * { max = Math.max(max, j - i + 1); j++; } }
	 * 
	 * return max; }
	 */
}
