package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LetMeCountTheWays {
	static int coins[] = { 1, 5, 10, 25, 50 };
	static long dp[][];
	static int n = 5;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		dp = new long[n][30001]; 
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = dp(i, j); 
			}
		}
		int c = 2;
	    //while( c-- > 0 ) {
		while (sc.ready()) {
			int nn = sc.nextInt();
			long ans = dp[0][nn];
			if (ans == 1) {
				sb.append("There is only 1 way to produce ");
				sb.append(nn);
				sb.append(" cents change.\n");
			} else {
				sb.append("There are ");
				sb.append(ans); 
				sb.append(" ways to produce "); 
				sb.append(nn);
				sb.append(" cents change.\n");
			}
			//System.out.println(Arrays.deepToString(dp));
		}
		System.out.print(sb.toString());

	}

	static long dp(int i, int val) {
		if (val == 0)
			return 1;
		if (i == n)
			return 0;
		if (dp[i][val] != -1)
			return dp[i][val];
		long take = 0; 
		if(val >= coins[i])
			take = dp(i, val - coins[i]);
		long leave = dp(i + 1, val); 
		return dp[i][val] = take + leave;
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
