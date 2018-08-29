package com.test.stringAndArray;

public class MinMaxInArray {

	public static void main(String[] args) {
		int arr[] = new int[] { 10, 2, 4, 5, 90, 100 };
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i : arr) {
			if (i > max) {
				max = i;
			}
			if (i < min) {
				min = i;
			}
		}
		System.out.println("Min: " + min + " Max :" + max);
	}
}