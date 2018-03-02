import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HowDoYouAdd_UVa10943 {
	static int memo[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n, K;
		while (true) {
			n = sc.nextInt();
			K = sc.nextInt();
			if (n == 0 && K == 0)
				break;
			memo = new int[n + 1][K + 1];
			for (int i = 0; i < memo.length; i++) {
				Arrays.fill(memo[i], -1);
			}
			out.println(dp(n, K));
		}
		out.flush();
	}

	static int mod = 1000000;

	static int dp(int n, int K) {
		if (K == 1)
			return 1;
		if (memo[n][K] != -1)
			return memo[n][K];
		int ans = 0;
		for (int i = 0; i <= n; i++) {
			ans = (ans + dp(n - i, K - 1) % mod) % mod;
		}
		return memo[n][K] = ans;
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
