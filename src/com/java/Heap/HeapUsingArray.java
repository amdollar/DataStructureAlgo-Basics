package com.java.Heap;

public class HeapUsingArray {

	public static void main(String[] args) {
		Heap heap = new Heap();
		heap.push(1);
		heap.push(10);
		heap.push(20);
		heap.push(23);
		heap.pop();
		System.out.println(heap.top());
		heap.push(43);
		System.out.println(heap.top());
	}

}
/*
 * Heap is also known as Priority queues. Priority queue suppots 3 perations: 1.
 * Insert O(log n) 2. Pop Max/ Min O(log n) 3. Get Max/ Min O(1) Heap as an
 * array can be flaten down. for any node i its childs = i*2 and (i*2)+1 for
 * any node i its parentnode = i/2
 * 
 */