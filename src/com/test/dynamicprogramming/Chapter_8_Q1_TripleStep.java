package com.test.dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

/*
 * A child running up a staircase with n steps and can hop either 1 step , 2 step , 3 steps at a time.
 * Implement a method to count how many possible ways the child can up the stairs.
 * 
 * Note: Below solution is generic we can use any number of steps and any set of allowed steps.
 * 
 * */
public class Chapter_8_Q1_TripleStep {

	public static void main(String[] args) {

		System.out.println("Enter the number of total steps");

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		System.out.println("Enter the number of valid steps");
		int c = scn.nextInt();
		int arr[] = new int[c];
		for (int i = 0; i < c; i++) {
			System.out.println("please enter valid steps");
			arr[i] = scn.nextInt();
		}

		FindCombination(n, arr);
	}

	private static void FindCombination(int n, int[] arr2) {
		
		int totalSteps = n + 1;
		int ValidStepsArray = arr2.length;
		int[][] arr = new int[ValidStepsArray + 1][n + 1];
		
		for (int i = 0; i < (ValidStepsArray + 1); i++) {
			arr[i][0] = 1;
		}

		//System.out.println(Arrays.deepToString(arr)); to print the array after initialization
		for (int i = 1; i < (ValidStepsArray + 1); i++) {
			for (int sum = 1; sum < totalSteps; sum++) {
				if (i > sum) {
					System.out.println("in side IF " + "Coin " + i + " Sum " + sum);
					arr[i][sum] = arr[i - 1][sum];
					System.out.println(Arrays.deepToString(arr));
				} else {
					System.out.println("in side ELSE " + "Coin " + i + " Sum " + sum);
					arr[i][sum] = arr[i - 1][sum] + arr[i][sum - i];
					System.out.println(Arrays.deepToString(arr));

				}
			}

		}

		System.out.println("Number of possible way child can go up the stairs of size " + n + " is "
				+ arr[ValidStepsArray][totalSteps - 1]);
	}

}
