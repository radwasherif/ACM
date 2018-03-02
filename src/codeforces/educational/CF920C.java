package codeforces.educational;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF920C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		int d[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			d[i] = a[i] - 1 - i;
		}
		String s = sc.next();
		int[] c = new int[n - 1];
		for (int i = 0; i < n - 1; i++)
			c[i] = s.charAt(i) - '0';

		for (int i = 1; i < n - 1; i++)
			c[i] += c[i - 1];
		boolean possible = true;
		for (int i = 1; i < n; i++) {
			int start = 0, end = n - 1;
			if (d[i] > 0) {
				start = i + d[i] - 1;
				start %= (n - 1);
				if (i == 0)
					end = 0;
				else
					end = c[i - 1];
				possible = possible && (c[start] - end == d[i]);
			}
			if (d[i] < 0) {
				start = i - 1;
				if (start < 0)
					start = 0;
				if (i - 1 + d[i] < 0)
					end = 0;
				else
					end = c[i - 1 + d[i]];
				possible = possible && (c[start] - end == -d[i]);
			}
		}
		if (possible)
			System.out.println("YES");
		else
			System.out.println("NO");

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
