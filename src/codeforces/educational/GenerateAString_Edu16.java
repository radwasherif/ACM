package codeforces.educational;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class GenerateAString_Edu16 {
	static int n, x, y;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		long dp[] = new long[n + 1];
		for (int i = 1; i < dp.length; i++) {
			if (i % 2 == 0)
				dp[i] = Math.min(dp[i - 1] + x, dp[i / 2] + y);
			else
				dp[i] = Math.min(x + dp[i - 1], Math.min(dp[i / 2] + x + y, dp[(i + 1 )/ 2]) + y + x);
		}
		System.out.println(dp[n]);
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		Scanner(FileReader r) {
			br = new BufferedReader(r);

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
