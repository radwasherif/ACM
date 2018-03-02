package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FormingQuizTeams_UVa10911 {
	static int N;
	static final double INF = 1e9;
	static int x[], y[];
	static double memo[][];

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = 1;
		while (true) {
			N = sc.nextInt() * 2;
			if (N == 0)
				break;
			x = new int[N];
			y = new int[N];
			for (int i = 0; i < N; i++) {
				sc.next();
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
			}
			memo = new double[N][(1 << N)];
			for (int i = 0; i < N; i++)
				Arrays.fill(memo[i], -10);
			double ans = dp(0, 0);
			out.printf("Case %d: %.2f\n", t++, Math.round(ans * 100.0) / 100.0);
		}
		out.flush();
		out.close();
	}

	static double dp(int i, int msk) {
		if (msk == (1 << N) - 1)
			return 0;
		double min = INF;
		if (memo[i][msk] > -5)
			return memo[i][msk];

		if ((msk & (1 << i)) != 0)
			return memo[i][msk] = dp(i + 1, msk);

		for (int j = 0; j < N; j++) {
			if (i != j && (msk & (1 << j)) == 0)
				min = Math.min(min, dist(i, j) + dp(i + 1, msk | (1 << j) | (1 << i)));
		}
		return memo[i][msk] = min;
	}

	static double dist(int i, int j) {
		int dx = x[i] - x[j];
		int dy = y[i] - y[j];
		return Math.sqrt(dx * dx + dy * dy);
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
