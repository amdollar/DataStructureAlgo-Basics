package com.java.Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LargestElement {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, 4, 5, 6 };
		List<Integer> ars = Arrays.stream(arr).boxed().collect(Collectors.toList());
//		Collections.reverse(ars);
		Collections.swap(ars, 4, 3);

		ars.stream().forEach(System.out::println);
//		int res = largestEle(arr);
//		System.out.println(res);
	}

//	 Linear solution -> Time complexity : n space : 1
	private static int largestEle(int[] arr) {
		int largest = 0;
		for (int i = 0; i < arr.length; i++) {
			largest = Math.max(arr[i], largest);
		}
		return largest;
	}

}
