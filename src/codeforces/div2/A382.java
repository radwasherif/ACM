package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A382 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		char[] c = sc.next().toCharArray();
		int start = 0, end = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 'G')
				start = i;
			if (c[i] == 'T')
				end = i;

		}
		if (start > end)
			k = -k;
		String ans = "";
		for (int i = start; (start > end) ? i >= end : i <= end; i += k)
			if (c[i] == '#') {
				ans = "NO";
				break;
			} else if (c[i] == 'T') {
				ans = "YES";
			}
		if (!ans.equals("YES"))
			ans = "NO";
		System.out.println(ans);
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		boolean ready() throws IOException {
			return br.ready();
		}

	}
}
