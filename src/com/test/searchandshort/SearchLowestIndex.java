package com.test.searchandshort;

public class SearchLowestIndex {

	public int BinarySearcLowestIndex(int[] arr, int numberToSearch) {
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		int result =-1;

		while (low <= high) {
			mid = low + (high - low) / 2;
			if (arr[mid] == numberToSearch) {
				result= mid;
				high=mid-1;
			} else if (arr[mid] > numberToSearch) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return result;

	}

	public static void main(String[] args) {

		int arr[] = { 1, 3, 3, 3,6, 9, 10, 50, 50, 67, 100 };
		SearchLowestIndex bs = new SearchLowestIndex();
		int i = bs.BinarySearcLowestIndex(arr, 3);
		if (i == -1) {
			System.out.println("number not found");
		} else {
			System.out.println("Minimum inde for Number is " + i);
		}
	}

}
