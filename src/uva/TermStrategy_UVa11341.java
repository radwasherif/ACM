package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TermStrategy_UVa11341 {
	static int L[][];
	static int N, M;
	static int memo[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = sc.nextInt();
		while (T-- > 0) {
			N = sc.nextInt();
			M = sc.nextInt();
			L = new int[N][M];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					L[i][j] = sc.nextInt();
				}
			}
			memo = new int[N + 1][M + 1];
			for (int i = 0; i < N + 1; i++) {
				Arrays.fill(memo[i], -1);
			}
			int max = dp(0, M);
			if (max < 0)
				out.println("Peter, you shouldn't have played billiard that much.");
			else
				out.printf("Maximal possible average mark - %.2f.\n", max * 1.0 / N);
		}
		out.flush();

	}

	static int INF = 1000000000;

	static int dp(int i, int hoursLeft) {
		if (hoursLeft < 0)
			return -INF;
		if (i == N)
			return 0;
		if (memo[i][hoursLeft] != -1)
			return memo[i][hoursLeft];
		int ans = -INF;
		for (int j = 0; j < M; j++) {
			if (L[i][j] >= 5)
				ans = Math.max(ans, L[i][j] + dp(i + 1, hoursLeft - j - 1));
		}
		return memo[i][hoursLeft] = ans;
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
