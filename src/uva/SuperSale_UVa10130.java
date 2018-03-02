package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SuperSale_UVa10130 {
	static int w[], p[];
	static int Wperson[];
	static int N, G;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = sc.nextInt();

		while (T-- > 0) {
			N = sc.nextInt();
			w = new int[N];
			p = new int[N];
			for (int i = 0; i < N; i++) {
				p[i] = sc.nextInt();
				w[i] = sc.nextInt();
			}

			G = sc.nextInt();
			int ans = 0; 
			for (int i = 0; i < G; i++) {
				int remW = sc.nextInt(); 
				memo = new int[N][remW + 1]; 
				for(int j = 0; j < N; j++)
					Arrays.fill(memo[j], -1);
				ans += dp(0, remW); 
			}
			out.println(ans);
			
		}
		out.flush();
	}

	static int memo[][];

	static int dp(int i, int remW) {
		if (remW < 0)
			return -1000000000;
		if (i == N || remW == 0)
			return 0;
		if (memo[i][remW] != -1)
			return memo[i][remW];
		int take = dp(i + 1, remW - w[i]) + p[i];
		int leave = dp(i + 1, remW);

		return memo[i][remW] = Math.max(take, leave);
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
