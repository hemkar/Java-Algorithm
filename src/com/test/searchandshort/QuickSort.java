package com.test.sorting;


import java.util.Arrays;

public class QuickSort {

	public static void quickSort(int arr[], int start, int end) {

		if (start < end) { //do this only if start index is less than end
			int partitionIndex = partition(arr, start, end); //call partition function to get partition so that all element less than partition are to the left
																// and larger are at the right.
			quickSort(arr, start, partitionIndex - 1);// call quickSort on  left partition
			quickSort(arr, partitionIndex + 1, end); // call quickSort on right partition
		}
	}

	public static int partition(int arr[], int start, int end) {

		int pivot = end;
		int pindex = 0;

		for (int i = 0; i < end; i++) {
			if (arr[i] < arr[pivot]) { //swap number at index i with partition index if it is smaller than pivot.
				int temp = arr[i];
				arr[i] = arr[pindex];
				pindex++;
			}
		}

		int temp = arr[pindex]; // swap partition index with pivot because pivot is smaller and it is still at the right
		arr[pindex] = arr[end];
		arr[end] = temp;

		return pindex;

	}

	public static void main(String[] args) {

		int arr[] = { 2, 2, 6, 10, 8 };

		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}
