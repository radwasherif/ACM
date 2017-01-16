package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AlexadnriasOracle {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int Q = sc.nextInt();
		while (Q-- > 0) {
			String s = sc.next();
			String nn = "";
			long k = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '!') {
					k++;
				} else {
					nn += s.charAt(i);
				}
			}
			long n = Integer.parseInt(nn);
			sb.append(fac(n, k) + "\n");
			// long x = (long) 1e18;
			// System.out.println(x);
		}
		System.out.print(sb);
	}

	static long fac(long n, long k) {
		long res = 1;
		while (n > 0) {
			res *= n;
			// System.out.println(res);
			n -= k;
		}
		return res;
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

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}
	}
}
