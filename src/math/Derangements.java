package math;

import java.math.BigInteger;

public class Derangements {
	static int D[]; 
	static void der (int N) {
		D = new int [N + 1]; 
		D[0] = 1; 
		D[1] = 0; 
		for (int i = 2; i < D.length; i++) {
			D[i] = (i - 1) * (D[i - 1] + D[i - 2]);  
		}
	}
	static BigInteger d  [] ; 
	static void der2 (int N) {
		d = new BigInteger[N + 1]; 
		d[0] = new BigInteger("1"); 
		d[1] = new BigInteger("0"); 
		for (int i = 2; i < d.length; i++) {
			d[i] = new BigInteger((i - 1) + "").multiply(d[i - 1].add(d[i - 2]));  
		}
	}
}
