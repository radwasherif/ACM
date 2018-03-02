package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class History_137C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 0;
		Pair a[] = new Pair[n];
		
		for (int i = 0; i < n; i++) {
			a[i] = new Pair(sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(a);
		int max = a[0].b;
		for (int i = 0; i < n; i++) {
			if (a[i].b < max)
				ans++;
			if (a[i].b > max)
				max = a[i].b;
		}
		System.out.println(ans);
	}

	static class Pair implements Comparable {
		int a, b;

		Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Object o) {
			Pair p = (Pair) o;
			int diff = this.a - p.a;
			if (diff == 0)
				return this.b - b;
			return diff;
		}
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}

			return st.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}
	}
}
