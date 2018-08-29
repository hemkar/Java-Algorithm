package com.test.searchandshort;

public class BinarySearchDemo {

	public int BinarySearc(int[] arr, int numberToSearch) {
		
		int low=0;
		int high=arr.length-1;
		int mid=0;
		
		while(low<=high){
		mid= low+(high-low)/2;
		if(arr[mid]==numberToSearch){
			return mid;
		}else if(arr[mid]>numberToSearch){
			high=mid-1;
		}else{
			low=mid+1;
		}
		}
		return -1;

	}

	public static void main(String[] args) {

		int arr[]={1,3,6,9,10,67,100};
		BinarySearchDemo bs= new BinarySearchDemo();
		int i=bs.BinarySearc(arr,10);
		if(i==-1){
			System.out.println("number not found");
		}else{
			System.out.println("Number found at index "+i);
		}
	}
}
