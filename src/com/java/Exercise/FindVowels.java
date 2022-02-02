package com.java.Exercise;

import java.util.ArrayList;
import java.util.List;

public class FindVowels {

	public static void main(String[] args) {
		String str = new String("aeoibsddaeioudb");
		String vowelsOnly = findVowelsOnly(str);
		System.out.println(vowelsOnly);
	}

	private static String findVowelsOnly(String str) {

		StringBuilder temp = new StringBuilder();
		List<Character> vowelsList = new ArrayList<>();
		vowelsList.add('a');
		vowelsList.add('e');
		vowelsList.add('i');
		vowelsList.add('o');
		vowelsList.add('u');
		for (char ch : str.toCharArray()) {
			if (vowelsList.contains(ch)) {
				temp.append(ch);
			}
		}
		return temp.toString();
	}

}
