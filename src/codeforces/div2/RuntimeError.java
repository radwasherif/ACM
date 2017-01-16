package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class RuntimeError {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			int k = sc.nextInt();
			int a[] = new int[N];

			TreeSet<Integer> ts = new TreeSet<Integer>();
			for (int i = 0; i < a.length; i++) {
				a[i] = sc.nextInt();
				ts.add(a[i]);
			}
			Arrays.sort(a);
			boolean f = false;
			for (int i = 0; i < a.length; i++) {
				if (a[i] != 0 && k % a[i] == 0) {
					ts.remove(a[i]);
					if (ts.contains(k / a[i])) {
						f = true;
						sb.append(a[i] + " " + (k / a[i]) + "\n");
						break;
					}
					ts.add(a[i]);
				}

			}
			if (!f)
				sb.append("-1\n");
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
