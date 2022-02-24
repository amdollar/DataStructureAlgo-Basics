package com.java.Stack;

public class Driver {
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(12);
		stack.push(23);
		stack.push(43);
		stack.push(53);
		stack.push(13);
		while (!stack.isEmpty()) {
			System.out.println(stack.top());
			stack.pop();
		}

	}
}
