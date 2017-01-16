package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 10819
 */

public class TroubleOf13Dots {
	static int n, m;
	static int price[], fav[];
	static int dp[][];
	static final int INF = 5000; 
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int c = 10; 
		 while (sc.ready()) {
		//while(c-- > 0) {
		m = sc.nextInt();
		n = sc.nextInt();
		dp = new int[n][m + 201];
		price = new int[n];
		fav = new int[n];
		for (int i = 0; i < n; i++) {
			price[i] = sc.nextInt();
			fav[i] = sc.nextInt();
		}
		for (int i = 0; i < dp.length; i++) {
			
				Arrays.fill(dp[i], -1);
			
		}
		// System.out.println("YO");
		sb.append(dp(0, 0));
		sb.append('\n'); 
		}
		System.out.print(sb.toString());
	}

	static int dp(int i, int moneySpent) {
		
		if (i == n) {
			if (moneySpent <= m)
				return 0; 

			if (moneySpent > 2000 && moneySpent <= m + 200)
				return 0;
			return -INF;
		}

		if (dp[i][moneySpent] != -1)
			return dp[i][moneySpent];
		int take = -INF;
		if (moneySpent + price[i] <= m + 200 )
			take = fav[i] + dp(i + 1, moneySpent + price[i]);
		int leave = dp(i + 1, moneySpent);
		return dp[i][moneySpent] = Math.max(take, leave);
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
