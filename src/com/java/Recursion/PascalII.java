package com.java.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PascalII {
	public static void main(String[] args) {
		getRow(3);
	}

	public static List<Integer> getRow(int rowIndex) {

		List<Integer> result = new ArrayList<>();
		long com = 1;
		result.add(1);

		for (int i = 0; i < rowIndex; i++) {
			com *= (rowIndex - i);
			com /= (i + 1);
			result.add((int) com);
		}

		return result;
	}
}
