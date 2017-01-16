package algorithms;

import java.util.Scanner;

public class Sieve {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean primes [] = sieve(n);
		for (int i = 0; i < primes.length; i++) {
			if(primes[i])
				System.out.print(i + " ");
		}
	}
	/*
	 * runs is O(n(logn)(loglogn))
	 */
  static boolean [] sieve(int n) {
	  boolean isPrime  [] = new boolean[n+1]; 
	  for (int i = 0; i < isPrime.length; i++) {
		isPrime[i] = true; 
	} 
	  isPrime[0] = false; 
	  isPrime[1] = false; 
	  int n_sqrt = (int) Math.sqrt(n); 
	  for (int i = 2; i <= n_sqrt; i++) {
		if (isPrime[i]) {
			for(int j = 2; i*j <=n; j++) {
				isPrime[i*j] = false; 
			}
		}
	}
	 return isPrime;  
  }
}
