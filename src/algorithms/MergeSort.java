package algorithms;

public class MergeSort {
   static final int INFINITY = 100000000; 
	public static void mergeSort(int a [], int start, int end) {
    	 if (start < end) {
    		 int mid = (start + end)/2; 
    		 mergeSort(a, start, mid);
    		 mergeSort(a, mid + 1, end);
    		 //merge(a, start, mid, end); 
    	 }
     } 
	
	
}
