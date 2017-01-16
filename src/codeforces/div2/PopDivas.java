package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PopDivas {
	static int[][] dp;
	static int N, M;
	static int[] a, b;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		a = new int[N];
		b = new int[M];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < b.length; i++) {
			b[i] = sc.nextInt();
		}
		// dp = new int[N][M];
		// for (int i = 0; i < dp.length; i++) {
		// Arrays.fill(dp, -1);
		// }

		System.out.println(dp(0, 0));
	}

	static Pair dp(int i, int j) {
		System.out.println(i + " " + j);
		if (i == N && j == M)
			return new Pair(1, 1);

		Pair take_i = null;
		if (i < N)
			take_i = new Pair(a[i], 1).mul(dp(i + 1, j));

		Pair take_j = null;
		if (j < M)
			take_j = new Pair(1, b[j]).mul(dp(i, j + 1));
		Pair takeboth = null;

		if (i < N && j < M)
			takeboth = new Pair(a[i], b[j]).mul(dp(i + 1, j + 1));

		Pair leaveboth = null;
		if (i < N && j < M)
			leaveboth = dp(i + 1, j + 1);

		Pair sol = null;

		if (equal(take_i))
			sol = take_i;
		else if (equal(take_j))
			sol = take_j;
		else if (equal(takeboth))
			sol = takeboth;
		else if (equal(leaveboth))
			sol = leaveboth;

		return sol;
	}

	static boolean equal(Pair p) {
		if (p == null)
			return false;
		return p.i == p.j;
	}

	static class Pair {
		int i, j;

		Pair(int ii, int jj) {
			i = ii;
			j = jj;

		}

		Pair mul(Pair p) {
			if (p == null)
				return null;
			return new Pair(i * p.i, j * p.j);
		}

		public String toString() {
			return i + " " + j;
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
