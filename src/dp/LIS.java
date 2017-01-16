package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class LIS {
	static Stack<Integer> sol = new Stack<>(); 
	public static int lis (int A [] ) {
		ArrayList<Integer> tails = new ArrayList<>(); //stores last elements in every "active list" we keep track of
		int lis = 0, lis_end = 0; 
		int L_to_A [] = new int[A.length]; //maps each index in L to an index in A 
		int p [] = new int[A.length]; //stores the index of the parent of each element in a LIS
		for (int i = 0; i < A.length; i++) {
			int pos = Collections.binarySearch(tails, A[i]); //finds the position of current elements among the tails
			if(pos < 0) pos = -(pos + 1); //if it is not in the list, find its supposed position
			if(pos >= tails.size()) { //it's larger than all tails
				tails.add(A[i]); //then we extend an existing active list with this number
				lis++; 
				lis_end = i; 
			} else { //it's in between 
				tails.set(pos, A[i]); //replace  
			}
			L_to_A[pos] = i; 
			p[i] = (pos > 0 )? L_to_A[pos - 1]: -1; 
		}
		
		while(lis_end != -1) {
			sol.push(A[lis_end]); 
			lis_end = p[lis_end]; 
		}
		return lis; 
	}
}
