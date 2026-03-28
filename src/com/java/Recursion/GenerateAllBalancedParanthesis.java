package com.java.Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllBalancedParanthesis {
	public static void main(String[] args) {
		int n = 3;
		String output = "";
		List<String> ans = new ArrayList<>();
		int open = n;
		int close = n;
		generateParanthesis(open, close, output, ans);
		System.out.println(ans);
	}

	private static void generateParanthesis(int open, int close, String output, List<String> ans) {
		if (open == 0 && close == 0) {
			ans.add(output);
			return;
		}
		if (open != 0) {
			// one open one close
			String output1 = output + "(";
			generateParanthesis(open - 1, close, output1, ans);
		}
		if (close > open) {
			// only open bracket
			String output1 = output;
			output1 = output1 + ")";
			generateParanthesis(open, close - 1, output1, ans);
		}
	}
}
