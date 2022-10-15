package com.java.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

//Given a string s, find the length of the longest substring without repeating characters.

public class LongestSubStringWithoutRepeatingChars {
	public static void main(String[] args) {
		String s = "eeydgwdykpv";
		int res = longestSubStringWithoutRepeatingChars(s, s.length());
		System.out.println(res);
	}

//	private static int longestSubStringWithoutRepeatingChars(String s, int length) {
//		int res = 0;
//		
//		for (int i = 0; i < length; i++) {
//			boolean[] visited = new boolean[256];
//			for (int j = i; j < length; j++) {
//				if (visited[s.charAt(j)] == true)
//					break;
//				else {
//					res = Math.max(res, j - i + 1);
//					visited[s.charAt(j)] = true;
//				}
//			}
//			visited[s.charAt(i)] = false;
//		}
//
//		return res;
//	}
// This solution is not working because we are missing the element that we have already iterated with i : dvdf
	// sliding window should be there.
	private static int longestSubStringWithoutRepeatingChars(String s, int length) {
		Map<Character, Integer> map = new HashMap<>();
		int i = 0;
		int j = 0;
		int max = Integer.MIN_VALUE;

		while (j < length && i < length) {
			char curr = s.charAt(j);
			Integer temp = map.get(curr);
			if (temp == null) {
				map.put(curr, 1);
			} else {
				map.put(curr, temp + 1);
			}
			if (map.size() < j - i + 1) {
				while (map.size() < j - i + 1) {
					map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
					if (map.get(s.charAt(i)) == 0) {
						map.remove(s.charAt(i));
					}
					i++;
				}
				j++;
			} else if (map.size() == j - i + 1) {
				max = Math.max(max, j - i + 1);
				j++;
			}
		}

		return max == Integer.MIN_VALUE ? 0 : max;
	}
}
