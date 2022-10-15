package com.java.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OverlappingSubintervals {

	public static void main(String[] args) {
		ArrayList<List<Integer>> arr = new ArrayList<>();
		arr.add(Arrays.asList(new Integer[] { 1, 3 }));
		arr.add(Arrays.asList(new Integer[] { 2, 4 }));
		arr.add(Arrays.asList(new Integer[] { 2, 6 }));
		arr.add(Arrays.asList(new Integer[] { 8, 9 }));
		arr.add(Arrays.asList(new Integer[] { 8, 10 }));
		arr.add(Arrays.asList(new Integer[] { 9, 11 }));
		arr.add(Arrays.asList(new Integer[] { 15, 18 }));
		arr.add(Arrays.asList(new Integer[] { 16, 17 }));
		ArrayList<List<Integer>> ans = merge(arr);
		System.out.println("Merged Overlapping Intervals are ");
		for (List<Integer> it : ans) {
			System.out.println(it.get(0) + " " + it.get(1));
		}

	}

	private static ArrayList<List<Integer>> merge(ArrayList<List<Integer>> arr) {
		// sort the array;
		Collections.sort(arr, (a, b) -> a.get(0) - b.get(1));
		ArrayList<List<Integer>> res = new ArrayList<>();
		// first condition when no overlapping is happening b/w i and i+1:
		for (int i = 0; i < arr.size(); i++) {
			if (res.isEmpty() || res.get(res.size()-1).get(1) < arr.get(i).get(0)) {
				ArrayList<Integer> curr = new ArrayList<>();
				curr.add(arr.get(i).get(0));
				curr.add(arr.get(i).get(1));
				
				res.add(curr);
			}else {
				res.get(res.size()-1).set(1, Math.max(res.get(res.size() - 1).get(1), arr.get(i).get(0)));
			}
		} 

		return res;
	}

}
