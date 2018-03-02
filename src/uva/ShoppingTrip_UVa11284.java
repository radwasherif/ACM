package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ShoppingTrip_UVa11284 {
	static int N, M, P;
	static double[][] dist;
	static final double inf = 9e9;
	static int[] storeOp;
	static double[] save;
	static double memo[][];

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = sc.nextInt();
		while (T-- > 0) {
			N = sc.nextInt() + 1;
			M = sc.nextInt();
			dist = new double[N][N];

			for (int i = 0; i < dist.length; i++) {
				Arrays.fill(dist[i], inf);
				dist[i][i] = 0;
			}

			while (M-- > 0) {
				int i = sc.nextInt();
				int j = sc.nextInt();
				dist[j][i] = dist[i][j] = Math.min(dist[i][j], sc.nextDouble());
			}

			floyd(); // get all-pair shortest path

			P = sc.nextInt();
			storeOp = new int[N];
			Arrays.fill(storeOp, -1);
			save = new double[N];
			for (int k = 0; k < P; k++) {
				int store = sc.nextInt();
				storeOp[store] = k;
				save[store] += sc.nextDouble();
			}

			memo = new double[N][(1 << P)];
			for (int i = 0; i < memo.length; i++)
				Arrays.fill(memo[i], -inf);
			double ans = dp(0, 0);
			if (ans - 1e-16 < 0.0)
				out.println("Don't leave the house");

			else
				out.printf("Daniel can save $%.2f\n", ans);

			// print(0, 0);
		}
		out.flush();
	}

	static void floyd() {

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

	}

	static double dp(int i, int msk) {
		if (msk == (1 << P) - 1)
			return -dist[i][0];
		if (memo[i][msk] > -inf)
			return memo[i][msk];
		double max = -dist[0][i];
		for (int j = 0; j < N; j++) {
			if (i != j && storeOp[j] != -1 && ((msk & (1 << storeOp[j])) == 0))
				max = Math.max(max, -dist[i][j] + save[j] + dp(j, (msk | (1 << storeOp[j]))));
		}

		return memo[i][msk] = max;
	}

	static void print(int i, int msk) {
		System.out.print(i + " ");
		if (msk == (1 << P) - 1)
			return;
		double max = dp(i, msk);
		for (int j = 0; j < N; j++) {
			if (i != j && storeOp[j] != -1 && ((msk & (1 << storeOp[j])) == 0)
					&& -dist[i][j] + save[j] + dp(j, (msk | (1 << storeOp[j]))) - max < 1e-9) {
				print(j, msk | (1 << storeOp[i]));
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
