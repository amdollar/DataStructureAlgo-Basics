package com.java.Exercise;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;

public class SubArrayWithSum {

	static void printLargest(Vector<String> arr) {
		Collections.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String s, String s2) {
				String XY = s + s2;
				String YX = s2 + s;

				return XY.compareTo(YX) > 0 ? -1 : 1;

			}
		});
		StringBuilder biggestNum = new StringBuilder();
		Iterator<String> it = arr.iterator();
		while (it.hasNext()) {
			biggestNum.append(it.next());
		}
		System.out.println(biggestNum);
	}

	// Driver code
	public static void main(String[] args) {

		Vector<String> arr;
		arr = new Vector<>();

		// output should be 6054854654
		arr.add("1");
		arr.add("3");
		arr.add("4");
		printLargest(arr);
	}
	// This code is contributed by Shubham Juneja
}
