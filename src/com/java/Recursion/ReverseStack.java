package com.java.Recursion;

import java.util.Stack;

public class ReverseStack {
	/*
	 * 232 235 287 123 521
	 */

	/*
	 * 232 235 287 123 521
	 */
	public static void main(String[] args) {
		Stack<Integer> st = new Stack();
		st.push(521);
		st.push(123);
		st.push(287);
		st.push(235);
		st.push(232);
		reverse(st);
		while (!st.isEmpty())
			System.out.println(st.pop());

	}

	private static void reverse(Stack<Integer> st) {
		if (st.size() == 0) {
			return;
		}
		int top = st.pop();
		reverse(st);
		insertAtLast(st, top);

	}

	private static void insertAtLast(Stack<Integer> st, int top) {
		if (st.size() == 0) {
			st.push(top);
			return;
		}
		int curr = st.pop();
		insertAtLast(st, top);
		st.push(curr);

	}

}
