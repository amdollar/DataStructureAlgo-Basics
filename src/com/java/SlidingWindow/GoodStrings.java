package com.java.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GoodStrings {
	public static void main(String[] args) {
		String str = new String("aababcabc");
		int ans = countGoodSubstrings(str);
		System.out.println(ans);

	}

	public static int countGoodSubstrings(String s) {		
		int count = 0;
		Map<Character, Integer> data = new HashMap<>();
		int i = 0;
		int j = 0;
		int size = 3;
		while (j < s.length()) {
			char temp = s.charAt(j);
			Integer res = data.get(temp);
			if (res == null) {
				data.put(temp, 1);
			} else {
				data.put(temp, res + 1);
			}
			if (j - i + 1 < size) {
				j++;
			} else if (j - i + 1 == size) {
				if (data.size() == size) {
					count++;
				}
				int curcu = data.get(s.charAt(i));
				data.put(s.charAt(i), curcu - 1);
				if (data.get(s.charAt(i)) == 0) {
					data.remove(s.charAt(i));
				}

				i++;
				j++;
			}
		}
		return count;
	}

}
