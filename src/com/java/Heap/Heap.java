package com.java.Heap;

import java.util.Collections;
import java.util.Vector;

public class Heap {
	Vector<Integer> heap = new Vector<>();

	Heap() {
		heap.add(-1);
	}

	// to add new data into the heap
	public void push(int data) {
		// first add the data into the array;
		heap.add(data);
		// do the swapping of data with parent node;
		int index = heap.size() - 1;// current
		int parent = index / 2;

		while (parent > 0 && heap.get(parent) < heap.get(index)) {
			// do the swapping of parent and current;
			Collections.swap(heap, index, parent);
			// change the references of parent
			index = parent;
			parent = parent / 2;
		}
	}

	// to get top element of the heap min/max
	public int top() {
		return heap.get(1);
	}

	// to perform pop on heap;
	public void pop() {
		// first find the last element and swap it with the first one.
		int last = heap.size() - 1;
		Collections.swap(heap, last, 1);
		// after swapping remove the last element;
		heap.remove(last);
		// now do heapify on top element;
		heapify(1);
	}

	private void heapify(int i) {
		// compare ith element with its left and right then swap and repeat
		int size = heap.size();
		int left = 2 * i;
		int right = 2 * i + 1;
		// we will do three element swapping here:
		int maxInd = i;
		if (left < size && heap.get(left) > heap.get(i)) {
			maxInd = left;
		}
		if (right < size && heap.get(maxInd) < heap.get(right)) {
			maxInd = right;
		}
		// if we need to swap
		if (maxInd != i) {
			Collections.swap(heap, maxInd, i);
			heapify(maxInd);
		}
	}
}
