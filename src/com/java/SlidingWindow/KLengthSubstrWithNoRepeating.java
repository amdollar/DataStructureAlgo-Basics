package com.java.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class KLengthSubstrWithNoRepeating {

	public static void main(String[] args) {
		String str = new String("abcc");
		int k = 3;
		int count = solve(str, k);
		System.out.println(count);
	}

	private static int solve(String str, int k) {
		Map<Character, Integer> map = new HashMap<>();
		int i = 0;
		int j = 0;
		int res = 0;
		while (j < str.length()) {
			char ch = str.charAt(j);
			// calculate the res
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			// increase if less
			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				if (map.size() == k) {
					res++;
				}
				// slide the win
				char cha = str.charAt(i);
				Integer cur = map.get(cha);
				map.put(cha, cur - 1);
				if (map.get(cha) == 0) {
					map.remove(cha);
				}
				i++;
				j++;
			}
		}
		return res;
	}

// brute force
	/*
	 * private static int solve(String str, int k) { int count = 0; int res = 0;
	 * Map<Character, Integer> feq = new HashMap<>(); for (int i = 0; i <=
	 * str.length() - k; i++) { for (int j = i; j < i + k; j++) { char curr =
	 * str.charAt(j); Integer cf = feq.get(curr); if (cf == null) { count++;
	 * feq.put(curr, 1); } else { break; } } if (count == k) { res++; } feq.clear();
	 * count = 0; } return res; }
	 */

}
