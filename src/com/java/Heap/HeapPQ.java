package com.java.Heap;

public class HeapPQ {

	public static void main(String[] args) {
		HeapUsingPriorityQueue heap = new HeapUsingPriorityQueue();
		heap.push(10);
		heap.push(2);
		heap.push(12);
		heap.push(24);
		heap.push(23);
		heap.push(92);
		while (!heap.isEmpty()) {
			System.out.println(heap.top());
			heap.pop();
		}
	}

}
