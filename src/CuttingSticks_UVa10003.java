import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CuttingSticks_UVa10003 {
	static int A[];
	static int memo[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		while (true) {
			int l = sc.nextInt();
			if (l == 0)
				break;
			int n = sc.nextInt();
			A = new int[n + 2];
			A[n + 1] = l;
			for (int i = 1; i <= n; i++)
				A[i] = sc.nextInt();
			memo = new int[n + 2][n + 2];
			for (int i = 0; i < n + 2; i++)
				Arrays.fill(memo[i], -1);
			out.printf("The minimum cutting is %d.\n", dp(0, n + 1));
		}
		out.flush();
	}

	static int INF = 1000000000;

	static int dp(int start, int end) {
		if (end == start + 1)
			return 0;
		if (memo[start][end] != -1)
			return memo[start][end];
		int ans = INF;
		for (int i = start + 1; i <= end - 1; i++) {
			ans = Math.min(ans, A[end] - A[start] + dp(start, i) + dp(i, end));
		}
		return memo[start][end] = ans;
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
