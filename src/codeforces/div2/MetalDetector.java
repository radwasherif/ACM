package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MetalDetector {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int N = sc.nextInt();
			int i = sc.nextInt();
			long ans = 0;
			while (true) {
				if (i % 2 == 1) {
					ans += Math.ceil(((double) i) / 2);
					break;
				} else {
					// System.out.println(Math.ceil(((double) N) / 2));
					ans += Math.ceil(((double) i) / 2);
					i = N - (int) Math.ceil(((double) i) / 2);
					N = i;
				}
			}
			sb.append(ans + "\n");
		}
		System.out.print(sb);
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
