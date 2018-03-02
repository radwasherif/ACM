package codeforces.educational;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF920A {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int ans[] = new int[n];
			Arrays.fill(ans, 300);
			while (k-- > 0) {
				int water = sc.nextInt() - 1;
				ans[water] = 1;
				for (int i = 1; i < n; i++) {
					int r = water + i;
					int l = water - i;
					if (r < n) {
						ans[r] = Math.min(ans[r], i + 1);
					}
					if (l >= 0) {
						ans[l] = Math.min(ans[l], i + 1);
					}
				}
			}
			int sol = ans[0];
			for (int i = 1; i < n; i++)
				sol = Math.max(ans[i], sol);

			out.println(sol);
		}
		out.flush();
		out.close();
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
