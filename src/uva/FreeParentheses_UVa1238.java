package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class FreeParentheses_UVa1238 {
	static int[] num;
	static int[] sign;
	static int[][][] dp;
	static int CONST;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		// int c = 20;
		while (br.ready()) {
			// while (c-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num = new int[(st.countTokens() - 1) / 2];
			sign = new int[(st.countTokens() - 1) / 2];
			st.nextToken();
			for (int i = 0; st.hasMoreTokens(); i++) {
				sign[i] = st.nextToken().charAt(0) == '+' ? 1 : -1;
				num[i] = Integer.parseInt(st.nextToken());
			}
			CONST = num.length * 100;
			dp = new int[num.length][2 * CONST][num.length + 1];
			for (int i = 0; i < dp.length; i++) {
				for (int j = 0; j < dp[i].length; j++) {
					Arrays.fill(dp[i][j], -1);
				}
			}
			ts = new TreeSet<>();
			// out.println(CONST);
			dp(0, 0, 0);
			out.println(ts.size());
		}
		out.flush();
		out.close();

	}

	static TreeSet<Integer> ts;

	static int dp(int i, int sum, int neg) {
		// System.out.println(ts.toString());
		// System.out.println(i + " " + sum + " " + neg);
		if (i == num.length) {
			// if (neg == 0) {
			if (!ts.contains(sum)) {
				ts.add(sum);
				return 1;
				// }
			}
			return 0;
		}
		if (dp[i][sum + CONST][neg] != -1)
			return 0;
		int ans = 0;
		if (neg > 0) {
			ans += dp(i + 1, sum + getSign(neg, sign[i], num[i]), neg - 1);
		}
		ans += dp(i + 1, sum + getSign(neg, sign[i], num[i]), neg);
		if (sign[i] == -1)
			ans += dp(i + 1, sum + getSign(neg, sign[i], num[i]), neg + 1);

		return dp[i][sum + CONST][neg] = ans;
	}

	static int getSign(int neg, int sign, int n) {
		return n * sign * (neg % 2 == 0 ? 1 : -1);
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

		String nextLine() throws IOException {
			return br.readLine();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		boolean ready() throws IOException {
			return br.ready();
		}
	}
}
