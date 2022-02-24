package com.java.Stack;

import com.java.LinkedList.Node;

public class Stack {
	private Node head;

	public Stack() {
		head = null;
	}

	void push(int data) {
		Node temp = new Node(data);
		temp.next = head;
		head = temp;
	}

	void pop() {
		if (!isEmpty()) {
			Node ret = head;
			head = head.next;
			ret = null;
		}
	}

	int top() {
		return (head.data);
	}

	boolean isEmpty() {
		return head == null;
	}

}
