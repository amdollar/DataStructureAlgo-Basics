package com.java.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueCharacters {

	public static void main(String[] args) {
		String str = new String("aabbcc");
		int k = 2;
		int res = solve(str, k);
		System.out.println(res);

	}

// instead of set use map to store the frequency of chars also, it would be used in case of removing the elements 
	private static int solve(String str, int k) {
		int max = 0;
		Map<Character, Integer> data = new HashMap<>();
		int i = 0;
		int j = 0;
		while (j < str.length() && i < str.length()) {
			char temp = str.charAt(j);
			Integer count = data.get(temp);
			if (count == null) {
				data.put(temp, 1);
			} else {
				data.put(temp, count + 1);
			}
			if (data.size() < k) {
				j++;
			} else if (data.size() == k) {
				max = Math.max(max, j - i + 1);
				j++;
			} else if (data.size() > k) {
				// remove an element in such a way that the count of that will become 0;
				while (data.size() > k) {
					char currchar = str.charAt(i);
					int currcount = data.get(currchar);
					data.put(currchar, currcount - 1);
					if (data.get(currchar) == 0) {
						data.remove(currchar);
					}
					i++;
				}
			}
		}

		return max;
	}

}
