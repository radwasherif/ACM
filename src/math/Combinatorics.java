package math;

import java.util.Arrays;

public class Combinatorics {
	public static void main(String[] args) {
		nCr(10); 
		System.out.println(Arrays.deepToString(nCr));
	}
	static int [] [] nCr; 
	//using the concept of pascal's triangle
	static void nCr (int N) {
		nCr = new int[N + 1][N + 1]; 
		nCr[0][0] = 1; 
		for (int i = 1; i < nCr.length; i++) {
			nCr[i][0] = nCr[i][i] = 1;
			for (int j = 1; j < nCr.length; j++) {
				if(i > 0)
				nCr[i][j] = nCr[i - 1][j - 1] + nCr[i - 1][j]; 
				
			}
		}
	}
	
	//Factorial 
	static int [] fac; 
	static void fac(int N ) {
		fac = new int[N + 1]; 
		fac[0] = 1; 
		fac[1] = 1; 
		for (int i = 2; i < fac.length; i++) {
			fac[i] = i * fac[i - 1]; 
		}
	}
}
