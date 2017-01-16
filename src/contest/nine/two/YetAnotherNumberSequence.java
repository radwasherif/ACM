package contest.nine.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 10689 UVa
 */

public class YetAnotherNumberSequence {
	static int[] f;
	static int a, b, m, mod;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		f = new int[100000 + 1];
		Arrays.fill(f, -1);
		while (t-- > 0) {
			a = sc.nextInt();
			b = sc.nextInt();
			int n = sc.nextInt();
			m = sc.nextInt();
			mod = pow(10, m);
			if (n == 0)
				System.out.println(a);
			else if (n == 1)
				System.out.println(b);
			else
				System.out.println(add(mul(a, fib(n - 1)), mul(fib(n), b)));

		}

	}

	static int fib(int n) {
		if (n == 0)
			return 0;
		if (n <= 2)
			return 1;

		int k = n >> 1;
		int a = fib(k), b = fib(k + 1);

		if (n % 2 == 0)
			return mul(a, add(mul(2, b), -a));

		return add(mul(a, a), mul(b, b));
	}

	static int pow(int a, int e) // O(log e)
	{
		int res = 1;
		while (e > 0) {
			if ((e & 1) == 1) {
				res *= a;

			}
			a *= a;
			e >>= 1;
		}
		return res;
	}

	static int mul(int a, int b) {
		return (a % mod * b % mod) % mod;
	}

	static int add(int a, int b) {
		return (a % mod + b % mod) % mod;
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
}
