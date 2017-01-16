package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DivisibleGroupSums {
	static int a[];
	static long dp[][][];
	static boolean vis[][][];
	static int d, m;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n, q;
		int set = 1;
		while (true) {
			n = sc.nextInt();
			q = sc.nextInt();
			// System.out.println(n + " " + q);
			if (n == 0 && q == 0)
				break;
			a = new int[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = sc.nextInt();
			}
			System.out.println("SET " + set++ + ":");
			for (int i = 1; i <= q; i++) {
				d = sc.nextInt();
				m = sc.nextInt();
				dp = new long[n][m + 1][d];
				vis = new boolean[n][m + 1][d];

				System.out.println("QUERY " + i + ": " + dp(0, m, 0));
			}

		}
	}

	static long dp(int id, int rem, int sum) {
		if (rem == 0) {
			if (mod(sum, d) == 0)
				return 1;
			else
				return 0;
		}
		if (id >= a.length) {
			return 0;
		}
		if (vis[id][rem][sum])
			return dp[id][rem][sum];
		long take = dp(id + 1, rem - 1, mod(sum + a[id], d));
		long leave = dp(id + 1, rem, sum);
		vis[id][rem][sum] = true;
		return dp[id][rem][sum] = take + leave;
	}

	static int mod(int a, int n) {
		if (a >= 0)
			return a % n;
		return (a % n + n) % n;
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
