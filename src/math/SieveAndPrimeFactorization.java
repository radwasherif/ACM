package math;

import java.util.ArrayList;
import java.util.Scanner;

public class SieveAndPrimeFactorization {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sieve(n);
		System.out.println(primeFactorization(n).toString());
	}

	/*
	 * runs is O(n(logn)(loglogn))
	 */
	static ArrayList<Integer> primes;

	static void sieve(int n) {
		primes = new ArrayList<>();
		boolean isPrime[] = new boolean[n + 1];
		for (int i = 0; i < isPrime.length; i++) {
			isPrime[i] = true;
		}
		isPrime[0] = false;
		isPrime[1] = false;
		int n_sqrt = (int) Math.sqrt(n);
		// to be changed to n when we need all the numbers to be added to
		// ArrayList
		for (int i = 2; i <= n; i++) {
			if (isPrime[i]) {
				primes.add(i);
				for (int j = 2; i * j <= n; j++) {
					isPrime[i * j] = false;
				}
			}
		}
	}

	static ArrayList<Integer> primeFactorization(int n) {
		int sqrt_n = (int) Math.sqrt(n) + 1;
		int i = 0;
		int prime = primes.get(i++);
		ArrayList<Integer> PF = new ArrayList<>();
		while (prime < sqrt_n) {
			while (n % prime == 0) {
				PF.add(prime);
				n /= prime;
			}
			prime = primes.get(i++);
		}
		if (n > 1)
			PF.add(n);
		return PF;
	}
}
