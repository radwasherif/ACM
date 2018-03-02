package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UnidirectionalTSP_UVa116 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		// int c = 3;
		// while (c-- > 0) {
		while (sc.ready()) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int a[][] = new int[m][n];
			int M[][] = new int[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					a[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < m; i++)
				M[i][n - 1] = a[i][n - 1];

			for (int j = n - 2; j >= 0; j--) {
				for (int i = 0; i < m; i++) {
					M[i][j] = a[i][j]
							+ Math.min(M[i][j + 1], Math.min(M[mod(i - 1, m)][j + 1], M[mod(i + 1, m)][j + 1]));
				}
			}

			int r = 0;
			int min = 1000000000;
			for (int i = 0; i < m; i++) {
				if (M[i][0] < min) {
					r = i;
					min = M[i][0];
				}
			}
			// for(int i = 0; i < m; i++)
			// System.out.println(Arrays.toString(M[i]));
			out.print(r + 1);
			// System.out.println(r);
			for (int j = 0; j < n - 1; j++) {
				// System.out.println(r + " " + j);
				int ans = M[r][j] - a[r][j];
				int up = mod(r - 1, m);
				int down = mod(r + 1, m);
				int idx[] = { up, down, r };
				Arrays.sort(idx);
				if (ans == M[idx[0]][j + 1])
					r = idx[0];
				else if (ans == M[idx[1]][j + 1])
					r = idx[1];
				else
					r = idx[2];

				out.print(" " + (r + 1));
			}
			out.println();
			out.println(min);
		}
		out.flush();
		out.close();
	}

	static int mod(int a, int b) {
		if (a < 0)
			return (a % b + b) % b;
		return a % b;
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
