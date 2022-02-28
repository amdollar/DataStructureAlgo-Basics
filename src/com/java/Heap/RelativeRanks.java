package com.java.Heap;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class RelativeRanks {
	// 5,4,3,2,1
	public static void main(String[] args) {
		int[] rankar = new int[] { 5, 4, 3, 2, 1, 6 };
		Set<String> res = getRelativeRanks(rankar);
		res.stream().forEach(System.out::println);
	}

	private static Set<String> getRelativeRanks(int[] rankar) {
		Set<String> ranksString = new HashSet<>();
		Comparator<Integer> rankCom = ((a, b) -> b - a);
//		List<Integer> ranksList = Arrays.stream(rankar).boxed().sorted().collect(Collectors.toList());
		PriorityQueue<Integer> ranks = new PriorityQueue<>(rankCom);
		int len = rankar.length - 1;
		while (len >= 0) {
			ranks.offer(rankar[len--]);
		} // O(log n)
		int i = 1;
		while (!ranks.isEmpty()) {
			int val = ranks.poll();
			if (i == 1) {
				ranksString.add("Gold medalist");
				i++;
			} else if (i == 2) {
				ranksString.add("Silver medalist");
				i++;
			} else if (i == 3) {
				ranksString.add("Bronz medalist");
				i++;
			} else {
				ranksString.add(i++ + "th");
			}
		}
		return ranksString;
	}

}
