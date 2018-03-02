package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FrequentValues_UVa11235 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	}

	static class SparseTable {
		int A[];
		Pair SpT[][];

		public SparseTable(int[] A) {
			int n = A.length;
			int k = log2floor(n) + 1;
			SpT = new Pair[n][k];

			for (int i = 0; i < n; i++)
				SpT[i][0] = new Pair(i, 1);

			for (int j = 1; (1 << j) <= n; j++)
				for (int i = 0; i + (1 << j) - 1 < n; i++) {
					Pair p1 = SpT[i][j - 1];
					Pair p2 = SpT[i + (1 << (j - 1))][j - 1];
					if (A[p1.idx] == A[p2.idx])
						SpT[i][j] = new Pair(p1.idx, p1.freq + p2.freq);
					else if(p1.freq > p2.freq)
						SpT[i][j] = new Pair(p1.idx, p1.freq); 
				}

		}

	}

	static class Pair {
		int freq, idx;

		Pair(int i, int f) {
			freq = f;
			idx = i;
		}
	}

	static int log2floor(int n) {
		return (int) Math.floor(Math.log(n) / Math.log(2));
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
