package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Journey {
	static int n, m, T;
	static ArrayList<Pair> adjList[];
	static long[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		T = sc.nextInt();
		adjList = new ArrayList[n];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<Pair>();
		}
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;
			int t = sc.nextInt();
			adjList[v].add(new Pair(u, t));
		}
		dp = new long[n][n];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		for (int j = n - 1; j >= 0; j--) {
			long x = dp(n - 1, j);
			// System.out.printl n(x);
			if (x <= T) {
				System.out.println(j + 1);
				sol = new ArrayList<>();
				print(n - 1, j);
				sol.add(1);
				for (int i = sol.size() - 1; i >= 0; i--) {
					if (i < sol.size() - 1)
						System.out.print(" ");
					System.out.print(sol.get(i));
				}
				System.out.println();
				break;
			}
		}
	}

	static final int INF = 2000000000;

	static long dp(int i, int j) {
		// System.out.println(i + " "+ j );
		if (i == 0 && j == 0)
			return dp[i][j] = 0;
		if (j < 0)
			return INF;
		if (dp[i][j] != -1)
			return dp[i][j];
		long min = INF;
		for (Pair p : adjList[i]) {
			min = Math.min(min, dp(p.to, j - 1) + p.wt);
		}

		return dp[i][j] = min;
	}

	static ArrayList<Integer> sol;

	static void print(int i, int j) {
		if (i == 0 && j == 0)
			return;
		long optimal = dp(i, j);

		for (Pair p : adjList[i]) {
			if (optimal == dp(p.to, j - 1) + p.wt) {
				sol.add(i + 1);
				print(p.to, j - 1);
				break;
			}
		}
	}

	static class Pair {
		int to, wt;

		Pair(int t, int w) {
			to = t;
			wt = w;
		}
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(System.in));

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
