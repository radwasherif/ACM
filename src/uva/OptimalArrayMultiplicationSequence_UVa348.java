package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class OptimalArrayMultiplicationSequence_UVa348 {
	static PrintWriter out;
	static int N;
	static int[] p, q;
	static ArrayList<Integer> a;
	static int memo[][];

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		out = new PrintWriter(System.out);
		int t = 1;
		while (true) {
			N = sc.nextInt();
			if (N == 0)
				break;
			p = new int[N];
			q = new int[N];
			for (int i = 0; i < N; i++) {
				p[i] = sc.nextInt();
				q[i] = sc.nextInt();
			}
			memo = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(memo[i], -1);
			}
			int ans = dp(0, N - 1);
//			out.println(ans);
			out.printf("Case %d: ", t++);
			print(0, N - 1);
			out.println();
		}
		out.flush();
		out.close();
	}

	static int dp(int i, int j) {
		if (i == j)
			return 0;
		int ans = 1000000000;
		if (memo[i][j] != -1)
			return memo[i][j];
		for (int k = i; k < j; k++) {
			ans = Math.min(ans, dp(i, k) + dp(k + 1, j) + p[i] * q[k] * q[j]);
		}

		return memo[i][j] = ans;
	}

	static void print(int i, int j) {
		if (i == j) {
			out.print("A" + (i + 1));
		}
		int ans = dp(i, j);

		for (int k = i; k < j; k++) {
			if (ans == dp(i, k) + dp(k + 1, j) + p[i] * q[k] * q[j]) {
				out.print("(");
				print(i, k);
				out.print(" x ");
				print(k + 1, j);
				out.print(")");
				break;
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

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}
