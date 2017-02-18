package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SkyCode_MSKYCODE {
	static int[] a, count;
	static int n, COUNT;

	public static void main(String[] args) throws NumberFormatException, IOException {

			Scanner sc = new Scanner(System.in);
			PrintWriter out = new PrintWriter(System.out);
			nCr(10000);
			sieve(10000);
//			while (sc.ready()) {
				n = sc.nextInt();
				a = new int[n];
				count = new int[10000 + 1];
				ArrayList<Integer> PF;
				for (int i = 0; i < a.length; i++) {
					a[i] = sc.nextInt();
					PF = primeFactorization(a[i]);
					for (int f : PF)
						count[f]++;
				}
				long ans = nCr[n][4];
				for (int i = 0; i < count.length; i++) {
					ans -= nCr[count[i]][4];
				}
				out.println(ans);
//			}
			out.flush();
			out.close();
	
			}

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
			if (n % prime == 0) {
				PF.add(prime);

			}
			while (n % prime == 0) {
				n /= prime;
			}
			if(i < primes.size() && i >= 0)
			prime = primes.get(i++);
		}
		if (n > 1)
			PF.add(n);
		return PF;
	}

	static long[][] nCr;

	// using the concept of pascal's triangle
	static void nCr(int N) {
		nCr = new long[N + 1][5];
		nCr[0][0] = 1; 
		for (int i = 1; i < nCr.length; i++) {
			nCr[i][0] = 1;
			if(i < 5)
				nCr[i][i] = 1; 
			for (int j = 1; j < 5; j++) {
//				System.out.println(i + " " + j);
				nCr[i][j] = nCr[i - 1][j - 1] + nCr[i - 1][j];

			}
		}
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
