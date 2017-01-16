package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 11517
 */
public class ExactChange {
	static int s, n;
	static int coins[];
	static int dp[][];
	static int M; 
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			s = sc.nextInt();
			n = sc.nextInt();
			coins = new int[n];
			for (int i = 0; i < n; i++) {
				coins[i] = sc.nextInt();
			}
			dp = new int[n][s + 1];
			for (int i = 0; i < dp.length; i++) {
				for (int j = 0; j < dp[i].length; j++) {
					dp[i][j] = -1;
				}
			}

			 M = count(0, 0);
			 dp = new int[n][M + 1];
			for (int i = 0; i < dp.length; i++) {
				for (int j = 0; j < dp[i].length; j++) {
					dp[i][j] = -1;
				}
			}
			int coins = countCoins(0, 0); 
			sb.append(M + " " + coins);
			sb.append('\n');
		}
		System.out.print(sb);
	}

	static int INF = 100000000;

	static int count(int i, int money) {
		// System.out.println(p.coins + " " + p.money);
		if (money >= s) {
			return money;
		}
		if (i == n)
			return INF;

		if (dp[i][money] != -1) {
			return dp[i][money];
		}
		int take = count(i + 1, money + coins[i]);
		int leave = count(i + 1, money);
		return dp[i][money] = Math.min(take, leave);

	}

	static int countCoins(int i, int money) {
		//System.out.println(i + " " + money );
		if (money == M) 
			return 0;
		if(money > M)
			return INF; 
		if (i == n)
			return INF;
		if (dp[i][money] != -1) {
			return dp[i][money];
		}
		int take = 1 + countCoins(i + 1, money + coins[i]);
		int leave = countCoins(i + 1, money);
		return dp[i][money] = Math.min(take, leave);
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
