package com.test.searchandshort;

/**
 * 
 * @author Hemkar
 *	program to find a number in a circularly rotated array
 */
public class FindNoInRotatedArray {

	public static int findNumber(int arr[], int lenght, int num) {

		int start = 0;
		int end = lenght - 1;
		int mid = 0;

		while (start <= end) {
			mid = (start + end) / 2;			 //find mid of array
			if (arr[mid] == num) {				 // return index if mid contains that element
				return mid;
			}

			if (arr[mid] < arr[end]) { 					      //case 1: if right of mid is sorted 
				if (num > arr[mid] && num <= arr[end]) {      //case 1A: when number to be searched is present in right half which is sorted
					start = mid + 1;
				} else { 								      // else prepare to search in left half.
					end = mid - 1;
				}
			} else if (num < arr[mid] && num >= arr[start]) { //case 2: if left of mid is sorted 
															  //case 2A: when number to be searched is present in left half which is sorted
				end = mid - 1;
			} else {										  // else prepare to search in right half.
				start = mid + 1;
			}
		}

		return -1;

	}

	public static void main(String[] args) {
		int arr[] = { 4, 5, 6, 7, 8, 1, 2 };
		int n = findNumber(arr, arr.length, 8);
		System.out.println(n);
	}

}
