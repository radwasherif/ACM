package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ChestOfDrawers_UVa11420 {
	static int n, s;
	static long memo[][][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		while (true) {
			n = sc.nextInt();
			s = sc.nextInt();
			if (n < 0 && s < 0)
				break;
			memo = new long[n][2][n + 1];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < 2; j++)
					Arrays.fill(memo[i][j], -1);
			out.println(dp(0, 1, 0));
		}
		out.flush();
	}

	static long dp(int idx, int last, int sum) {
		if (idx == n)
			return (sum == s) ? 1 : 0;
		if (memo[idx][last][sum] != -1)
			return memo[idx][last][sum];
		long ans = 0;
		if (last == 0) {
			ans += dp(idx + 1, 1, sum);
		} else if (last == 1) {
			ans += dp(idx + 1, 1, sum + 1);
		}
		ans += dp(idx + 1, 0, sum);
		return memo[idx][last][sum] = ans;

	}
	
	static long bottomUp() {
		int dp[][][] = new int[n + 1][2][n + 1];
		for(int i = n; i >= 0; i--) {
			for(int last = 0; last < 2; last++) {
				
			}
		}
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		boolean ready() throws IOException {
			return br.ready();
		}

	}
}
