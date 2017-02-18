package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class WhereAreMyFlakes_60A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Integer> a = new ArrayList<>();
		int[] dir = new int[n + 1];
		int l = 1;
		int r = n;
		for (int i = 0; i < m; i++) {
			sc.next();
			sc.next();
			String s = sc.next();
			sc.next();
			int d = sc.nextInt();
			a.add(d);
			if (s.equals("right")) {
				dir[d] = 1;
			} else {
				dir[d] = -1;
			}
		}
		// System.out.println(Arrays.toString(dir));
		Collections.sort(a);
		// System.out.println(a.toString());
		int count = 0;
		for (int d : a) {
			if (dir[d] == 1) {
				if (l <= d)
					l = d + 1;

			} else {
				if (r >= d)
					r = d - 1;

			}

			if (l < 0 || r > n || l > r) {
				System.out.println(-1);
				return;
			}
		}
		// System.out.println("YO");
		System.out.println(r - l + 1);
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

		String nextLine() throws IOException {
			return br.readLine();
		}

	}
}
