package com.java.BinarySearch;

//	https://www.geeksforgeeks.org/allocate-minimum-number-pages/
// Given a number of pages in N different books and M students. The books are arranged in ascending order of the number of pages. Every student is assigned to read some consecutive books. The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum. 
public class AllocatePages {

	public static void main(String[] args) {
		int pages[] = new int[] { 12, 34, 67, 90 };
		int students = 2;
		int minAllocation = allocatePages(pages, students);
		System.out.println(minAllocation);

	}

	private static int allocatePages(int[] pages, int students) {
		if(pages.length < students) {
			return -1;
		}
		int max = 0;
		int total = 0;
		for (int i : pages) {
			max = Math.max(max, i);
			total += i;
		}
		int start = max;
		int end = total;
		int min = Integer.MAX_VALUE;
		while (start <= end) {
			int mid = start + ((end - start) / 2);
			if (scheamIsValid(pages, mid, students) == true) {
				min = Math.min(min, mid);
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return min == Integer.MAX_VALUE ? -1 : min;
	}

	private static boolean scheamIsValid(int[] pages, int mid, int students) {
		int student = 1;
		int total = 0;
		for (int i = 0; i < pages.length; i++) {
			total += pages[i];
			if (total > mid) {
				student++;
				total = pages[i];
			}
		}
		if (student > students) {
			return false;
		}
		return true;
	}

}
