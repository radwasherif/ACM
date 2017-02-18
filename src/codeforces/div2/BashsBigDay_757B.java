package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BashsBigDay_757B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		sieve(100000);
		int count[] = new int [100000 + 1]; 
		ArrayList <Integer> PF; 
		for(int i = 0; i < a.length; i++) {
			PF = primeFactorization(a[i]); 
			for(int f : PF)
				count[f]++; 
			
			
		}
		int max = 0;
		for (int i = 0; i < count.length; i++)
			max = Math.max(count[i], max);
		System.out.println(max < 1 ? 1 : max);

	}

	static ArrayList<Integer> primes;
	static boolean isPrime[];

	static void sieve(int n) {
		primes = new ArrayList<>();
		isPrime = new boolean[n + 1];
		for (int i = 0; i < isPrime.length; i++) {
			isPrime[i] = true;
		}
		isPrime[0] = false;
		isPrime[1] = false;
		int n_sqrt = (int) Math.sqrt(n);
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
			if(n % prime == 0)
				PF.add(prime);
			while (n % prime == 0) {
//				PF.add(prime);
				n /= prime;
			}
			prime = primes.get(i++);
		}
		if (n > 1)
			PF.add(n);
		return PF;
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		boolean ready() throws IOException {
			return br.ready();
		}

	}
}
