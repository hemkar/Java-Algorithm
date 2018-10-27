package com.test.sorting;

import java.util.Arrays;

public class MergeSortAlgo {

	public static void mergeSort(int arr[]) {

		if (arr.length < 2)
			return;

		int mid = arr.length / 2;
		int left[] = new int[mid];
		int right[] = new int[(arr.length) - mid];
		for (int i = 0; i < left.length; i++) {
			left[i] = arr[i];
		}
		int i = mid;
		for (int j = 0; j < right.length; j++) {
			right[j] = arr[i++];
		}

		mergeSort(left);
		mergeSort(right);

		merge(left, right, arr);

	}

	private static void merge(int[] left, int[] right, int[] arr) {
		
		int i=0;
		int j=0;
		int k=0;
		
		while(i<left.length && j<right.length){// keep comparing and adding elements into main array
			if(left[i]<=right[j]){//if left array element is smaller
				arr[k]=left[i]; //add to main array is increment the index
				i++; //increment index of left array not right array
				k++;//increment index of main array to store next smallest element
			}else{ 	//if right array element is smaller.
				arr[k]=right[j];//add to main array is increment the index
				j++;//increment index of right array not left array
				k++; //increment index of main array to store next smallest element
			}
		}
		
		if(i<left.length){	//if Elements are still present in left array than copy all of remaining element directly to main array
			while(k<arr.length){
				arr[k]=left[i];
				k++;
				i++;
			}
		}
		
		if(j<right.length){ //if Elements are still present in right array than copy all of remaining element directly to main array
			while(k<arr.length){
				arr[k]=right[j];
				k++;
				j++;
			}
		}
	}

	public static void main(String[] args) {
		
		int arr[]={3,5,10,44,50,28};
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}

}
