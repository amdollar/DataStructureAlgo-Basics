package com.java.Arrays;
// changing this file for next commit
import java.util.ArrayList;
import java.util.List;

public class ClosestSum {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, 4, 7, 10 };
		int sum = 15;
		List<Integer> pairsum = (findClosestPair(arr, sum));
		System.out.println(pairsum);

	}

	private static List<Integer> findClosestPair(int[] arr, int sum) {
		List<Integer> ans = new ArrayList<>();
		int mindiff = Integer.MAX_VALUE;
		int var1 = 0;
		int var2 = 0;
		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			int temp = arr[left] + arr[right];
			int temp2 = Math.abs(temp - sum);
			if (temp2 < mindiff) {
				var1 = arr[left];
				var2 = arr[right];
				mindiff = temp2;
			}
			if (temp < sum) {
				left++;
			} else if (temp > sum) {
				right--;
			}

		}
		ans.add(var1);
		ans.add(var2);
		return ans;
	}

}
