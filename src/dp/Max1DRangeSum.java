package dp;

public class Max1DRangeSum {
	public static void main(String[] args) {
		int a [] = {9, 9, 10, 1, 2, 3, -100, -4, -5, -1}; 
		System.out.println(max1D(a));
		System.out.println(start + " " + end);
	}
	
	/* Kadane's algorithm
	 * O(n) find the maximum range sum in an array
	 */
	static int start = 0, end = 0; 
	static int max1D( int a []) {
		int sum = 0, max = 0; 
		int currStart = 0; 
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			if( sum > max) {
				max = sum;  
				start = currStart; 
			}
			if(sum < 0) {
				sum = 0; 
				currStart = i+1; 
				
			}
			
		}
		return max; 
	}
	
	
	
}
