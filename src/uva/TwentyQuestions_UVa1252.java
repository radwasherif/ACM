package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class TwentyQuestions_UVa1252 {
	static int m, n;
	static String s[];
	static int memo[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		while (true) {
			m = sc.nextInt();
			n = sc.nextInt();
			if (m == 0 && n == 0)
				break;
			s = new String[n];
			for (int i = 0; i < s.length; i++) {
				s[i] = sc.nextLine();
			}
			// System.out.println(m + " " + (1 << m));
			memo = new int[m][(1 << (m + 1))];
			for (int i = 0; i < memo.length; i++) {
				Arrays.fill(memo[i], -1);
			}
			out.println(dp(0, 0));
		}
		out.flush();
		out.close();
	}

	static TreeSet<String> ts;
	static final int INF = 1000000000;

	static int dp(int i, int msk) {
		if (i == m) {
			String bit = "";
			ts = new TreeSet<String>();
			for (int j = 0; j < s.length; j++) {
				bit = "";
				for (int k = 0; k < m; k++) {
//					System.out.println("mask " + Integer.toBinaryString(msk) + " " + Integer.toBinaryString((1 << k)));
					if ((msk & (1 << k)) != 0) {
						bit += s[j].charAt(k);
//						System.out.println("YOOOO  " + s[j].charAt(k));
					}
				}
				ts.add(bit);
			}
			if (ts.size() != n)
				return INF;
			return Integer.bitCount(msk); 
		}
		if (memo[i][msk] != -1)
			return memo[i][msk];
		int take = dp(i + 1, (msk | (1 << i)));
		int leave = dp(i + 1, msk);
		// System.out.println("take " + take + " leave " + leave);
		return memo[i][msk] = Math.min(take, leave);
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
