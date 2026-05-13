package com.java.RecursionChapter2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://www.geeksforgeeks.org/problems/power-set-using-recursion/1?track=sp-recursion&batchId=105
public class PowerSetUsingRecursion {

	public static void main(String[] args) {

		String input = "abc";

		Set<String> powerset = new HashSet();

		String output = "";
		generatePowerSet(input, output, powerset);
		for (String ans : powerset) {
			System.out.println(ans);
		}

	}

	private static void generatePowerSet(String input, String output, Set<String> powerset) {

		if (input == null || input.length() == 0) {
			powerset.add(output);
			return;
		}
		String output1 = output;
		String output2 = output;

		output2 = input.charAt(0) + output2;
		input = input.substring(1);

		generatePowerSet(input, output1, powerset);
		generatePowerSet(input, output2, powerset);

	}

}
