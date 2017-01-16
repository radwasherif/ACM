package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 
 */

public class eCoins {
	static int m, S;
	static int coins[][];
	static long dp[][][];

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			m = sc.nextInt();
			 S = sc.nextInt();
			dp = new long[m][S + 1][S + 1];
			coins = new int[m][2];
			for (int i = 0; i < dp.length; i++) {
				for (int j = 0; j < dp[i].length; j++) {
					Arrays.fill(dp[i][j], -1);
				}
				
			}
			for (int i = 0; i < m; i++) {
				coins[i][0] = sc.nextInt();
				coins[i][1] = sc.nextInt();
			}
			long ans = dp(0, 0, 0);
			if (ans < INF)
				sb.append(ans);
			else
				sb.append("not possible");
			sb.append('\n');
		}
		System.out.print(sb.toString());
	}

	static int INF = 10000000;

	static long dp(int i, int x, int y) {
		
		if (x*x + y*y == S*S)
			return 0;
		if (x*x + y*y > S*S)
			return INF;

		if (i == m)
			return INF;
		if (dp[i][x][y] != -1)
			return dp[i][x][y];

		int x1 = coins[i][0];
		int y1 = coins[i][1];
		
		long take = 1 + dp(i, x + x1, y + y1);
		long leave = dp(i + 1, x, y);
		return dp[i][x][y] = Math.min(take, leave);
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
