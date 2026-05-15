package com.java.RecursionChapter2;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/problems/print-n-bit-binary-numbers-having-more-1s-than-0s0252/1
public class NBitbinaryMore1than0 {

	public static void main(String[] args) {
		int n = 3;
		int zero = 0;
		int one = 0;
		String output = "";

		List<String> ans = new ArrayList<>();

		generateBinaryBits(ans, n, zero, one, output);
		for (String temp : ans) {
			System.out.println(temp);
		}

	}

	private static void generateBinaryBits(List<String> ans, int n, int zero, int one, String output) {
		if (n == 0) {
			ans.add(output);
			return;
		}
		String output1 = output + "1";
		generateBinaryBits(ans, n - 1, zero, one + 1, output1);

		if (one > zero) {
			String output2 = output + "0";
			generateBinaryBits(ans, n - 1, zero + 1, one, output2);
		}

	}

}
