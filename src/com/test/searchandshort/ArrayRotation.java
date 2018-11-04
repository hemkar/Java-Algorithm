package com.test.searchandshort;

/**
 * 
 * @author Hemkar
 * program to print no of rotation of a sorted array
 *
 */
public class ArrayRotation {

	public static int rotation(int[] arr) {

		int start = 0;
		int end = arr.length - 1;
		

		while (start <= end) { //base condition
			
			if (arr[start] <= arr[end]) {// case 1:  if start and end index are already in ascending order.{1,2,3,4}
				return start;
			}

			int mid = (start + end) / 2; //find mid every time we modify start and end index.
			int next = (mid + 1) % arr.length; //find next of mid and take care if mid is the last element in the array
			int prev = (mid - 1 + arr.length) % arr.length; //find previous element take care if pev is he first element in the array

			if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) { // check if calculated mid is the lowest element in that array, it means or search is over
				return mid;
			}

			// find the part of array which is unsorted.
			if (arr[mid] >= arr[start]) {
				start = mid + 1;
			} else if (arr[mid] < arr[end]) {
				end = mid - 1;
			}
		}

		return -1;

	}

	public static void main(String[] args) {
		int arr[]={4,5,6,7,8,10,11,1,2,3};
		
		System.out.println(rotation(arr));
	}
}
