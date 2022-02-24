package com.java.Stack;

import java.util.Stack;

public class InsertAtBottom {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(10);
		stack.push(11);
		stack.push(12);
		stack.push(13);
		stack.push(14);
		System.out.println("After inserting:");
		insertAtBottom(stack, 15);
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

	private static void insertAtBottom(Stack<Integer> stack, int i) {
		if (stack.isEmpty()) {
			stack.push(i);
			return;
		}

		int temp = stack.pop();

		insertAtBottom(stack, i);
		stack.push(temp);
	}
}
