package com.test.searchandshort;

public class FindOcuuranceOfNumber {



	public int BinarySearcOcc(int[] arr, int numberToSearch,boolean findMin) {
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		int result =-1;

		while (low <= high) {
			mid = low + (high - low) / 2;
			if (arr[mid] == numberToSearch && findMin==false) { // find max index
				result= mid;
				low=mid+1;
			}else if(arr[mid] == numberToSearch && findMin==true){ // find minimum index 
				result = mid;
				high=mid-1;
			} else if (arr[mid] > numberToSearch) { // find no in lefy half
				high = mid - 1;
			} else { 				// find no in right half
				low = mid + 1;
			}
		}
		return result;

	}

	public static void main(String[] args) {

		int arr[] = { 1, 3, 3, 3,6, 9, 10, 50, 50, 67, 100 };
		FindOcuuranceOfNumber bs = new FindOcuuranceOfNumber();
		int i = bs.BinarySearcOcc(arr, 100,true); //to min index
		if (i == -1) {
			System.out.println("number not found");
		} else {
			int j = bs.BinarySearcOcc(arr, 100,false); // to find max index
			System.out.println("Number of occurance of number "+ (j-i+1));
		}
	}


}
