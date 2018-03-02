package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class FreeParentheses_UVa1238_2 {
	static int memo[][][];
	static char[] sign;
	static int[] num;
	static int N;
	static TreeSet<Integer> ts;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int c = 1;
		while (c-- > 0) {
			// while (sc.ready()) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			N = (st.countTokens() - 1) / 2;
			sign = new char[N];
			num = new int[N];
			st.nextToken();
			for (int i = 0; i < N; i++) {
				sign[i] = st.nextToken().charAt(0);
				num[i] = Integer.parseInt(st.nextToken());
			}
			memo = new int[N][N][N * 200];
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					Arrays.fill(memo[i][j], -1);
			ts = new TreeSet<Integer>();
			System.out.println(dp(0, 0, 0));
			out.println(ts.size());
		}
		out.close();

	}

	static int dp(int i, int neg, int sum) {
		//
		if (i == N) {
			System.out.println(i + " " + neg + " " + sum);
			
			if (ts.contains(sum)) {
				System.out.println("0");
				System.out.println(ts.toString());
				return 0;
			
			} else {
				System.out.println("1");
				
				ts.add(sum);
				System.out.println(ts.toString());
				return 1;
			}
			
		}
		if (memo[neg][i][sum + N * 100] != -1) {
			System.out.println("DP " + i + " " + neg + " " + sum);
			return memo[neg][i][sum + N * 100];
		}
		int eval = sum + eval(num[i], sign[i], neg);
		int ans = dp(i + 1, neg, eval);
		if (sign[i] == '-')
			ans += dp(i + 1, neg + 1, eval);
		if (neg > 0)
			ans += dp(i + 1, neg - 1, eval);

		return memo[neg][i][sum + N * 100] = ans;

	}

	static int eval(int n, char sign, int neg) {
		int ans = (sign == '-') ? -n : n;
		if (neg % 2 == 1)
			return -ans;
		return ans;
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

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}
