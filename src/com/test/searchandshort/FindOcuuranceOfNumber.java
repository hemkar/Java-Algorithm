package com.test.searchandshort;

public class FindOcuuranceOfNumber {



	public int BinarySearcOcc(int[] arr, int numberToSearch,boolean findMin) {
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		int result =-1;

		while (low <= high) {
			mid = low + (high - low) / 2;
			if (arr[mid] == numberToSearch && findMin==false) {
				result= mid;
				low=mid+1;
			}else if(arr[mid] == numberToSearch && findMin==true){
				result = mid;
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
		FindOcuuranceOfNumber bs = new FindOcuuranceOfNumber();
		int i = bs.BinarySearcOcc(arr, 100,true);
		if (i == -1) {
			System.out.println("number not found");
		} else {
			int j = bs.BinarySearcOcc(arr, 100,false);
			System.out.println("Number of occurance of number "+ (j-i+1));
		}
	}


}
