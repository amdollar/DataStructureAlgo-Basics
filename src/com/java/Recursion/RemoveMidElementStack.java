package com.java.Recursion;

import java.util.Stack;

public class RemoveMidElementStack {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack();
		st.push(521);
		st.push(123);
		st.push(287);
		st.push(235);
		st.push(232);
		int mid = st.size() / 2 + 1;
		System.out.println(mid);
		removeMid(st, mid);

		while (!st.isEmpty())
			System.out.println(st.pop());
	}

	private static void removeMid(Stack<Integer> st, int mid) {
		// base condition
		if (mid == 1) {
			st.pop();
			return;
		}
		// Hypothesis
		int cur = st.pop();
		removeMid(st, mid - 1);

		// Induction
		st.push(cur);

	}

}
/*
 * 232 235 287 123 521
 */

/*
 * 232 235 287 521
 */
