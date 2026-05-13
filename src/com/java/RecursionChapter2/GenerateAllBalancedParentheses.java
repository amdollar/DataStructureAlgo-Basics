package com.java.RecursionChapter2;

import java.util.ArrayList;
import java.util.List;

//https://www.interviewbit.com/problems/generate-all-parentheses-ii/

/*Given an integer A pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*A.
*/
public class GenerateAllBalancedParentheses {

	public static void main(String[] args) {
		int a = 2;
		String input = "";
		String output = "";

		int open = a;
		int close = a;
		List<String> res = new ArrayList<>();

		generateParenthesis(open, close, output, res);
		for (String temp : res) {
			System.out.println(temp);
		}
	}

	private static void generateParenthesis(int open, int close, String output, List<String> res) {
		if (open == 0 && close == 0) {
			res.add(output);
			return;
		}
		if (open > 0) {
			String output1 = output + "(";
			generateParenthesis(open -1, close, output1, res);
		}
		if (close > open) {
			String output2 = output + ")";
			generateParenthesis(open, close - 1, output2, res);
		}

	}

}
