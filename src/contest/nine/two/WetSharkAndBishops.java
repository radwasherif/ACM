package contest.nine.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Codeforces #341 div. 2 B
 */
public class WetSharkAndBishops {
	static int a[][];

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		a = new int[1001][1001];
		int ans = 0;
		int n = sc.nextInt();
		while (n-- > 0) {
			a[sc.nextInt()][sc.nextInt()] = 1;

		}
		int j = 1; // left column

		for (int i = 1; i < a.length; i++) {
			int limit = a.length - i;
			int count = 0;
			for (int d = 0; d < limit; d++) {
				count += a[i + d][j + d];
			}
			// System.out.println(count);
			ans += nC2(count);
		}
		//System.out.println(ans);
		int i = 1; // top row
		for (int k = 2; k < a.length; k++) {
			int count1 = a[i][k], count2 = a[i][k]; 
			for (int d = 1; d < a.length - 1; d++) {
				if (k + d < a.length) {
					count1 += a[i + d][k + d];
				}
				if (k - d >= 0) {
					count2 += a[i + d][k - d];
				}
			}
			//System.out.println(count);
			// System.out.println(nC2(count));
			ans += nC2(count1) + nC2(count2);
		}
		//System.out.println(ans);
		j = 1000; // right column
		for (int k = 2; k < a.length; k++) {
			int limit = a.length - k;
			int count = 0;
			for (int d = 0; d < limit; d++) {
				count += a[k + d][j - d];
			}
			// System.out.println(count);
			// System.out.println(nC2(count));
			ans += nC2(count);
		}

		System.out.println(ans);
	}

	static int nC2(int n) {
		if (n >= 2)
			return n * (n - 1) / 2;
		return 0;
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

		public boolean ready() throws IOException {
			return br.ready();
		}
	}
}
