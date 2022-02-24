package com.java.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//program to insert element at bottom of the stack
public class BottomInsertion {

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
		List<Integer> stackdata = new ArrayList<>();
		while (!stack.isEmpty()) {
			stackdata.add(stack.pop());
		}
		stack.push(i);
		for (int temp = stackdata.size() - 1; temp >= 0; temp--) {
			stack.push(stackdata.get(temp));
		}
	}

}
