package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumOfMSLCM {
	static int N;
	static int n;
	static long dp[][];

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(bf.readLine());
		long ans = 0;
		
		for (n = 2; n <= N; n++) {
			dp = new long[n + 1][n + 1];
			for (int i = 0; i < dp.length; i++) {
				Arrays.fill(dp[i], -1);
			}
			ans += dp(1, 1);
		}
		sb.append(ans + "\n");

		System.out.print(sb);
	}
	static final int l = 20000001; 
	static long INF = (long) 1e12;

	static long dp(int lcm, int i) {
		// System.out.println(lcm + " " + i);
		if (lcm == n)
			return 0;
		if (i > n)
			return -INF;
		if (lcm > n)
			return -INF;
		if(dp[lcm][i] != -1) {
			System.out.println("YO");
			return dp[lcm][i];
		}
		long leave = dp(lcm, i + 1);
		long take = i + dp(lcm(lcm, i), i + 1);
		return Math.max(leave, take);
	}

	static int gcd(int x, int y) {
		return y == 0 ? x : gcd(y, (x % y));
	}

	static int lcm(int a, int b) {
		return a * (b / gcd(a, b));
	}
}
