package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LetsYumCha {
	static int n, x, t, k, maxMoney, maxDishes;
	static int price[];
	static int fav[], dp[][][];

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (true) {
			n = sc.nextInt();
			x = sc.nextInt();
			t = sc.nextInt();
			k = sc.nextInt();
			if (n == 0 && x == 0 && t == 0 && k == 0)
				break;
			n++; // to include "me"
			maxMoney = (n) * x;
			maxDishes = 2 * n;
			price = new int[k];
			fav = new int[k];
			for (int i = 0; i < k; i++) {
				price[i] = sc.nextInt();
				int sum = 0;
				for (int j = 0; j < n; j++) {
					sum += sc.nextInt();
				}
				fav[i] = sum;
			}
			dp = new int[k + 1][maxMoney + 1][maxDishes + 1];
			for (int i = 0; i < dp.length; i++) {
				for (int j = 0; j < dp[i].length; j++) {
					Arrays.fill(dp[i][j], -1);
				}
			}
			sb.append(format((dp(0, 0, 0) * 1.0) / n));
			sb.append('\n');

		}
		System.out.print(sb);
	}

	static String format(double d) {
		return new DecimalFormat("0.00").format(Math.round(d * 100) / 100.0);
	}

	static final int INF = 20000;

	static int dp(int i, int money, int dishes) {
		if (i == k) {
			// System.out.println(i);
			if (money + n * t + round(0.1 * (money + n * t)) > maxMoney)
				return -INF;
			if (dishes > maxDishes)
				return -INF;
			return 0;
		}
		if (money + t + round(0.1 * (money + n * t)) > maxMoney)
			return -INF;
		if (dishes > maxDishes)
			return -INF;
		if (dp[i][money][dishes] != -1)
			return dp[i][money][dishes];
		int leave = dp(i + 1, money, dishes);

		int take1 = fav[i] + dp(i + 1, money + price[i], dishes + 1);

		int take2 = fav[i] * 2 + dp(i + 1, money + 2 * price[i], dishes + 2);

		return dp[i][money][dishes] = Math.max(Math.max(take1, take2), leave);
	}

	static int round(double d) {
		return (int) Math.ceil(d);
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
