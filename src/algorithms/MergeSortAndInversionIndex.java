package algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortAndInversionIndex {
	static final int INFINITY = 100000000;
	public static long mergeSort(int a[], int start, int end) {
		long inv = 0; 
		if (start >= end) 
			return 0; 
		
		int mid = (start + end) / 2;
		inv += mergeSort(a, start, mid);
		inv += mergeSort(a, mid + 1, end);
		inv += merge(a, start, mid, end);
			
		return inv; 
		 
	}

	static long merge(int a[], int low, int mid, int high) {
		int i = low;
		int j = mid + 1;
		int k = 0;
		long inv = 0; 
		int tmp[] = new int[high - low + 1];
		while (i <= mid && j <= high) {
			if (a[i] <= a[j]) {
				tmp[k] = a[i];
				i++;
				
			} else {
				tmp[k] = a[j];
				j++;
				inv = inv + (mid - i + 1); 
			}
			k++;
		}

		while (i <= mid) {
			tmp[k++] = a[i++];
		}
		while (j <= high) {
			tmp[k++] = a[j++];
		}
		for (int m = low, n = 0; m <= high; n++, m++)
			a[m] = tmp[n];

		return inv; 
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); 
		int a [] = new int [n]; 
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt(); 
		}
		
		long inv = mergeSort(a, 0, a.length - 1);
		System.out.println(inv);
	}

}
