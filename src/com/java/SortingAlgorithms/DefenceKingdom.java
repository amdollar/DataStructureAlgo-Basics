package com.java.SortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefenceKingdom {

	public static void main(String[] args) {
		int width = 15;
		int heigth = 8;
		List<List<Integer>> positions = new ArrayList<>();
		createPositionsData(positions);
		int panelty = defKingdom(width, heigth, positions);
		System.out.println(panelty);
	}

	private static int defKingdom(int width, int heigth, List<List<Integer>> positions) {
		// find max position higth and width
		List<Integer> widthArr = sortWidthList(positions, true);
		List<Integer> heigthArr = sortWidthList(positions, false);
		int maxdiffinhight = findMaxDifference(heigthArr, heigth);
		int maxdiffinwidth = findMaxDifference(widthArr, width);
		return (maxdiffinhight - 1) * (maxdiffinwidth - 1);
	}

	private static int findMaxDifference(List<Integer> arr, int var) {
		int maxdiff = var - arr.get(0);
		for (int i = 1; i < arr.size(); i++) {
			int temp = arr.get(i - 1) - arr.get(i);
			if (temp > maxdiff) {
				maxdiff = temp;
			}
		}
		return maxdiff;
	}

	private static List<Integer> sortWidthList(List<List<Integer>> positions, boolean flag) {
		List<Integer> wigthArr = new ArrayList<>();
		for (List<Integer> inlist : positions) {
			if (flag)
				wigthArr.add(inlist.get(0));
			else {
				wigthArr.add(inlist.get(1));
			}
		}
		Collections.sort(wigthArr, Collections.reverseOrder());
		return wigthArr;
	}

	private static void createPositionsData(List<List<Integer>> positions) {
		List<Integer> point1 = new ArrayList<>();
		point1.add(3);
		point1.add(8);
		positions.add(point1);
		List<Integer> point2 = new ArrayList<>();
		point2.add(11);
		point2.add(2);
		positions.add(point2);
		List<Integer> point3 = new ArrayList<>();
		point3.add(8);
		point3.add(6);
		positions.add(point3);

	}
}
