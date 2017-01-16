package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RamsesGame {
	static int N;
	static int dp[][][];
	static int[] x, y, z;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		N = sc.nextInt();
		x = new int[N];
		y = new int[N];
		z = new int[N];
		for (int i = 0; i < x.length; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
			z[i] = sc.nextInt();
		}
		dp = new int[N][6][(1 << N)];
		for (int k = 0; k < dp.length; k++) {
			for (int m = 0; m < dp[k].length; m++) {
				Arrays.fill(dp[k][m], -1);
			}
		}
		int ans = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 6; j++) {
				if (j == 3 && x[i] == y[i])
					continue;
				if (j == 4 && x[i] == z[i])
					continue;
				if (j == 5 && y[i] == z[i])
					continue;
				Pair p = dim(i, j);
				// System.out.println("First: " + x[i]);
				ans = Math.max(ans, p.h + dp(i, j, (1 << i)));

			}
		}
		sb.append(ans + "\n");
		System.out.print(sb);
	}

	/*
	 * or = 0 -- xy or = 1 -- xz or = 2 -- yz or = 3 -- yx or = 4 -- zx or = 5
	 * -- zy
	 */
	static int dp(int last, int or, int mask) {
		// System.out.println(last);
		if (mask == (1 << N) - 1)
			return 0;
		if (dp[last][or][mask] != -1)
			return dp[last][or][mask];
		int ans = 0;
		Pair max = dim(last, or);
		for (int i = 0; i < N; i++) {
			if (((1 << i) & mask) == 0) {
				//
				for (int j = 0; j < 6; j++) {
					if (j == 3 && x[i] == y[i])
						continue;
					if (j == 4 && x[i] == z[i])
						continue;
					if (j == 5 && y[i] == z[i])
						continue;

					Pair cur = dim(i, j);
					if (last == -1 || cur.w <= max.w && cur.d <= max.d) {
						// System.out.println(ans+" " + i + " " + j);
						// mask = (mask | (1 << i));
						ans = Math
								.max(ans, cur.h + dp(i, j, (mask | (1 << i))));

					}

				}
			}
		}
		return dp[last][or][mask] = ans;
	}

	static Pair dim(int last, int or) {
		if (or == 0) {
			return new Pair(x[last], y[last], z[last]);
		} else if (or == 1)
			return new Pair(x[last], z[last], y[last]);
		else if (or == 2)
			return new Pair(y[last], z[last], x[last]);
		else if (or == 3)
			return new Pair(y[last], x[last], z[last]);
		else if (or == 4)
			return new Pair(z[last], x[last], y[last]);
		else
			return new Pair(z[last], y[last], x[last]);
	}

	static class Pair {
		int w, d, h;

		Pair(int ww, int dd, int hh) {
			w = ww;
			d = dd;
			h = hh;
		}
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}
	}

}
