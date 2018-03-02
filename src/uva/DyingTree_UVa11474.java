package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DyingTree_UVa11474 {
	static final double EPS = 1e-9;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			double k = sc.nextInt();
			double d = sc.nextInt();

			Pair[] doctors = new Pair[m];
			for (int i = 0; i < m; i++) {
				doctors[i] = new Pair(sc.nextInt(), sc.nextInt());
			}
			DisjointSet ds = new DisjointSet(n + m);
			ArrayList<Pair>[] trees = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				trees[i] = new ArrayList<>();
				int b = sc.nextInt();
				while (b-- > 0) {
					Pair p = new Pair(sc.nextInt(), sc.nextInt());
					trees[i].add(p);
					for (int j = 0; j < m; j++) {
						if (doctors[j].dist(p) - d - EPS < 0)
							ds.union(j, i + m);
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = i; j < n; j++) {
					for (Pair v : trees[i])
						for (Pair u : trees[j])
							if (v.dist(u) - k - EPS < 0)
								ds.union(i + m, j + m);
				}
			}
			boolean saved = false;
			for (int i = 0; i < m; i++) {
				if (ds.sameSet(i, m))
					saved = true;
			}
			out.println(saved ? "Tree can be saved :)" : "Tree can't be saved :(");
		}
		out.flush();
		out.close();
	}

	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		double dist(Pair p) {
			int dx = x - p.x;
			int dy = y - p.y;
			return Math.sqrt(dx * dx + dy * dy);
		}
	}

	static class DisjointSet {
		int[] p, rank;

		public DisjointSet(int n) {
			p = new int[n];
			for (int i = 0; i < n; i++)
				p[i] = i;
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
			} else {
				p[x] = y;
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
