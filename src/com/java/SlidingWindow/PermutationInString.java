package com.java.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

	public static void main(String[] args) {
		String s1 = "ab";
		String s2 = "eidbaooo";
		boolean res = checkInclusion(s1, s2);
		System.out.println(res);

	}

	private static boolean checkInclusion(String s1, String s2) {
		if (s1.length() > s2.length())
			return false;
		// pattern
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : s1.toCharArray()) {
			Integer occ = map.get(ch);
			if (occ == null) {
				map.put(ch, 1);
			} else {
				map.put(ch, occ + 1);
			}
		}
		// big one
		Map<Character, Integer> map2 = new HashMap<>();
		int i = 0;
		int j = 0;
		while (j < s2.length()) {
			Integer occ = map2.get(s2.charAt(j));
			if (occ == null) {
				map2.put(s2.charAt(j), 1);
			} else {
				map2.put(s2.charAt(j), occ + 1);
			}
			if (j - i + 1 < s1.length()) {
				j++;
			} else if (j - i + 1 == s1.length()) {
				if (matches(map, map2)) {
					return true;
				}
				Integer ith = map2.get(s2.charAt(i));
				map2.put(s2.charAt(i), ith - 1);
				if (map2.get(s2.charAt(i)) == 0) {
					map2.remove(s2.charAt(i));
				}
				i++;
				j++;
			}
		}

		return false;
	}

	private static boolean matches(Map<Character, Integer> pattern, Map<Character, Integer> bigstr) {
		for (char ch : pattern.keySet()) {
			int f1 = pattern.getOrDefault(ch, 0);
			int f2 = bigstr.getOrDefault(ch, 0);
			if (f1 != f2)
				return false;

		}
		return true;
//		for (int i = 0; i <= 26; i++) {
//			char ch = (char) (i + 'a');
//			int f1 = pattern.getOrDefault(ch, 0);
//			int f2 = bigstr.getOrDefault(ch, 0);
//			if (f1 != f2)
//				return false;
//		}
//		return true;
	}
//		for (Entry<Character, Integer> temp : map.entrySet()) {
//			char key = temp.getKey();
//			if (map2.get(key) == map.get(key)) {
//				count += map2.get(key);
//			}
//		}
//		if (count == s1.length()) {
//			return true;
//		}
//		
//		

// brute force / two loops / n2
// time limit exceeding for very big inputs.
	/*
	 * public static boolean checkInclusion(String s1, String s2) {
	 * 
	 * boolean res = false; for (int i = 0; i < s2.length(); i++) { for (int j = i;
	 * j < s2.length(); j++) { if (chechInclusing(s1, s2.substring(i, j + 1))) {
	 * return true; } } } return res; }
	 * 
	 * private static boolean chechInclusing(String s1, String substring) {
	 * Map<Character, Integer> map = new HashMap<>(); for (char ch :
	 * s1.toCharArray()) { Integer occ = map.get(ch); if (occ == null) { map.put(ch,
	 * 1); } else { map.put(ch, occ + 1); } }
	 * 
	 * for (char ch : substring.toCharArray()) { Integer oc = map.get(ch); if (oc ==
	 * null) { return false; } else { map.put(ch, oc - 1); if (map.get(ch) == 0) {
	 * map.remove(ch); } } }
	 * 
	 * return map.size() == 0 ? true : false;
	 * 
	 * }
	 */
}
