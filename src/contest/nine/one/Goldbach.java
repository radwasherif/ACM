package contest.nine.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Goldbach {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		TreeSet<Integer> primes = sieve(1000000);
		int n;
		int p1 = -1, p2 = -1;
		while (true) {
			n = sc.nextInt();
			if (n == 0)
				break;
			for (int i : primes) {
				if(i > n/2)
					break; 
				if(primes.contains(n-i)) {
				   p1 = i; 
				   p2 = n-i;
				   break; 
				}
			}
			if (p1 == -1) {
				System.out.println("Goldbach's conjecture is wrong.");
			} else {
				System.out.println(n + " = " + p1 + " + " + p2);
			}
		}
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {

			br = new BufferedReader(new InputStreamReader(s));

		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}

	static TreeSet<Integer> sieve(int n) {
		boolean isPrime[] = new boolean[n + 1];
		for (int i = 0; i < isPrime.length; i++) {
			isPrime[i] = true;
		}
		isPrime[0] = false;
		isPrime[1] = false;
		
		TreeSet <Integer> primes = new TreeSet<Integer>(); 
		for (int i = 2; i <= n; i++) {
			if (isPrime[i]) {
				primes.add(i); 
				for (int j = 2; i * j <= n; j++) {
					isPrime[i * j] = false;
				}
			}
		}
		return primes;
	}

	static boolean isPrime(int n) {
		if (n == 2)
			return true;
		int sqrt = (int) Math.sqrt(n);
		for (int i = 2; i <= sqrt; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

}
