package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Friends_UVa10608 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			DisjointSet ds = new DisjointSet(n);
			while (m-- > 0) {
				int i = sc.nextInt() - 1;
				int j = sc.nextInt() - 1;
				ds.union(i, j);
			}
			int max = 1;
			for (int i = 0; i < n; i++) {
				max = Math.max(max, ds.size[i]);
			}
			out.println(max);
		}
		out.flush();
		out.close();
	}

	static class DisjointSet {
		int[] p, rank, size;

		public DisjointSet(int n) {
			p = new int[n];
			size = new int[n];
			for (int i = 0; i < n; i++) {
				p[i] = i;
				size[i] = 1;
			}

			rank = new int[n];

		}

		int find(int i) {
			if (p[i] == i)
				return i;
			return p[i] = find(p[i]);
		}

		boolean sameSet(int i, int j) {
			return find(i) == find(j);
		}

		void union(int i, int j) {
			if (sameSet(i, j))
				return;

			int x = find(i);
			int y = find(j);
			if (rank[x] > rank[y]) {
				p[y] = x;
				size[x] += size[y];
//				System.out.println(size[x]);
			} else {
				p[x] = y;
				size[y] += size[x];
//				System.out.println(size[y]);
				if (rank[x] == rank[y])
					rank[y]++;
			}
		}
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
