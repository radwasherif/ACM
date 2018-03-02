package codeforces.educational;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CF920B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int l[] = new int[n];
			int r[] = new int[n];

			for (int i = 0; i < n; i++) {
				l[i] = sc.nextInt();
				r[i] = sc.nextInt();
			}

			int time = l[0]; 
			if (l[0] <= r[0]) {
				out.print(l[0]);
				time++; 
			} else {
				out.print(0);
			}
			for (int i = 1; i < n; i++) {
				if (time > r[i])
					out.printf(" %d", 0);
				else {
					if (time < l[i]) {
						out.printf(" %d", l[i]);
						time = l[i] + 1;
					} else {
						out.printf(" %d", time++);
					}
				}
			}
			out.println();
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
