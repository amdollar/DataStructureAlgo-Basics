package com.java.Recursion;

import java.util.Stack;

public class SortStack {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack();
		st.push(521);
		st.push(123);
		st.push(287);
		st.push(235);
//		while (!st.isEmpty())
//			System.out.println(st.pop());
		sort(st);
		while (!st.isEmpty())
			System.out.println(st.pop());
	}

	private static void sort(Stack<Integer> st) {
		// base condition: if single element is remaining it will be sorted by default;
		if (st.size() == 1) {
			return;
		}
		// Hypothesis: Input smaller
		int last = st.pop();
		sort(st);

		// Induction: put popped element at correct place
		insert(st, last);
	}

	private static void insert(Stack<Integer> st, int last) {
		// base condition:
		if (st.size() == 0 || st.peek() <= last) {
			st.push(last);
			return;
		}
		// Hypothesis: smaller input
		int temp = st.pop();
		insert(st, last);
		// Induction: add at correct place
		st.push(temp);
	}

}
