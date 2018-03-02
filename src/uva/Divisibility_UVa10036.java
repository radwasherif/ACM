package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Divisibility_UVa10036 {
	static int N, M, K;
	static int a[];
	static int memo[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		M = sc.nextInt();
		while (M-- > 0) {
			N = sc.nextInt();
			K = sc.nextInt();
			a = new int[N];
			for (int i = 0; i < N; i++)
				a[i] = mod(sc.nextInt(), K);

			memo = new int[N][K];
			for (int i = 0; i < N; i++) {
				Arrays.fill(memo[i], -1);
			}
			int div = dp(1, a[0]);
			if (div == 1)
				out.println("Divisible");
			else
				out.println("Not divisible");
		}
		out.flush();
	}

	static int dp(int i, int sumSoFar) {
//		System.out.println(i + " " + sumSoFar);
		if (i == N)
			return mod(sumSoFar, K) == 0 ? 1 : 0;
		if (memo[i][sumSoFar] != -1)
			return memo[i][sumSoFar];
		return memo[i][sumSoFar] = (dp(i + 1, mod(sumSoFar - a[i], K)) == 1 || dp(i + 1, mod(sumSoFar + a[i], K)) == 1)
				? 1
				: 0;
	}

	static int mod(int a, int n) {
		if (a >= 0)
			return a % n;
		return (a % n + n) % n;
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
