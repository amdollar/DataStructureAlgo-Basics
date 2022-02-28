package com.java.Heap;

import java.util.PriorityQueue;

public class HeapUsingPriorityQueue {
	PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a, b) -> b - a);

	public void push(int data) {
		heap.offer(data);
	}

	public int top() {
		return heap.peek();
	}

	public boolean isEmpty() {
		return heap.isEmpty();
	}

	public void pop() {
		heap.poll();
	}
}
