package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * 
 * @author radwa
 * 
 * Traversing the north and south banks with two indices (i, j), we have 3 transitions: 
 * (i, j + 1)--> advance on the south bank only
 * (i + 1, j) --> advance on the north bank only
 * (i+1, j+1) + values both cities --> advance on both if they have the same OS
 * 
 *  The solution is returned as a pair (weight, bridges), and we maximize on the weights, if the weights are equal
 *  then we minimize on the bridges. 
 *
 */

public class TheBridgesOfKolsberg_UVa1172 {
	static long[] nOS, sOS, nVal, sVal;
	static TreeMap<String, Long> tm;
	static int N, S;
	static Pair memo[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = sc.nextInt();
		while (T-- > 0) {
			long os = 0;
			tm = new TreeMap<String, Long>();
			N = sc.nextInt();
			nOS = new long[N];
			nVal = new long[N];
			for (int i = 0; i < N; i++) {
				sc.next();
				String s = sc.next();
				if (!tm.containsKey(s)) {
					tm.put(s, os);
					nOS[i] = os++;
				} else {
					nOS[i] = tm.get(s);
				}
				nVal[i] = sc.nextInt();
			}
			S = sc.nextInt();
			sOS = new long[S];
			sVal = new long[S];
			for (int i = 0; i < S; i++) {
				sc.next();
				String s = sc.next();
				if (!tm.containsKey(s)) {
					tm.put(s, os);
					sOS[i] = os++;
				} else {
					sOS[i] = tm.get(s);
				}
				sVal[i] = sc.nextInt();
			}
			memo = new Pair[N][S];

			out.println(dp(0, 0));

		}
		out.flush();
		out.close();
	}

	static Pair dp(int n, int s) {
		// System.out.println(n + " " + s);
		if (n == N || s == S)
			return new Pair(0, 0);

		if (memo[n][s] != null)
			return memo[n][s];
		Pair p1 = dp(n + 1, s);
		Pair p2 = dp(n, s + 1);
		Pair ret = max(p1, p2);

		if (nOS[n] == sOS[s]) {
			Pair p3 = dp(n + 1, s + 1);
			p3.br += 1;
			p3.wt += (sVal[s] + nVal[n]);
			ret = max(ret, p3);
		}

		return memo[n][s] = ret;
	}

	static class Pair {
		long wt, br;

		Pair(long w, long b) {
			wt = w;
			br = b;
		}

		@Override
		public String toString() {
			return wt + " " + br;
		}

		@Override
		public boolean equals(Object obj) {
			Pair p = (Pair) obj;
			return p.wt == this.wt && p.br == this.br;
		}

	}

	static Pair max(Pair p1, Pair p2) {
		if (p1.wt >= p2.wt) {
			if (p1.wt == p2.wt)
				return new Pair(p1.wt, Math.min(p1.br, p2.br));
			return new Pair(p1.wt, p1.br);
		}
		return new Pair(p2.wt, p2.br);

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
