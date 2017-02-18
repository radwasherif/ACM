package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CD_UVa624 {
	static int N, k, max;
	static int[] a;
	static boolean found;
	static boolean[] taken;
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		while (sc.ready()) {
			N = sc.nextInt();
			k = sc.nextInt();
			a = new int[k];
			taken = new boolean[k];
			for (int i = 0; i < k; i++)
				a[i] = sc.nextInt();
			max = backtrack(0, 0);
			found = true;
			backtrack(0, 0);
			out.println("sum:" + max);
		}
		out.close();
	}

	static int backtrack(int i, int sumSoFar) {
		if (sumSoFar == max) {
			if (found) {
				for (int j = 0; j < k; j++)
					if (taken[j])
						out.print(a[j] + " ");
				found = false;
				return 0;
			}
		}
		if (sumSoFar > N)
			return -1000000000;
		if (sumSoFar == N) {
			return sumSoFar;
		}
		if (i == k)
			return sumSoFar;
		int take = -1;
		if (a[i] <= N) {
			taken[i] = true;
			take = backtrack(i + 1, sumSoFar + a[i]);
			taken[i] = false;
		}

		int leave = backtrack(i + 1, sumSoFar);
		return Math.max(take, leave);
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

		boolean ready() throws IOException {
			return br.ready();
		}
	}
}
