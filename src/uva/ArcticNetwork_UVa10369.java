package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ArcticNetwork_UVa10369 {
	static int S, P;
	static ArrayList<Edge> edgeList;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			S = sc.nextInt();
			P = sc.nextInt();
			int x[] = new int[P];
			int y[] = new int[P];
			for (int i = 0; i < P; i++) {
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
			}
			edgeList = new ArrayList<Edge>();
			for (int i = 0; i < P; i++) {
				for (int j = i + 1; j < P; j++) {
					double dist = Math.hypot(x[i] - x[j], y[i] - y[j]);
					edgeList.add(new Edge(i, j, dist));
				}
			}
			DecimalFormat df = new DecimalFormat("#.00");
			sb.append(df.format(msf()) + "\n");
		}
		System.out.print(sb);
	}

	static double msf() {
		Collections.shuffle(edgeList);
		Collections.sort(edgeList);
		double max = -1;
		DisjointSet ds = new DisjointSet(P);
		for (Edge e : edgeList) {
			if (!ds.sameSet(e.e, e.s) && (ds.numSets - 1) >= S) {
				max = Math.max(max, e.wt);
				ds.union(e.e, e.s);
			}
		}
		return max;
	}

	static class DisjointSet {
		int[] p, rank;
		int numSets;

		public DisjointSet(int N) {
			p = new int[N];
			rank = new int[N];
			numSets = N;
			for (int i = 0; i < p.length; i++) {
				p[i] = i;
			}
		}

		int findSet(int i) {
			if (p[i] == i)
				return i;
			return p[i] = findSet(p[i]);
		}

		boolean sameSet(int i, int j) {
			return findSet(i) == findSet(j);
		}

		void union(int i, int j) {
			if (sameSet(i, j))
				return;
			numSets--;
			int x = findSet(i);
			int y = findSet(j);
			if (rank[x] > rank[y]) {
				p[y] = x;
			} else {
				p[y] = x;
				if (rank[x] == rank[y])
					rank[y]++;
			}
		}
	}

	static class Edge implements Comparable<Edge> {
		int s, e;
		double wt;

		Edge(int f, int t, double w) {
			s = f;
			e = t;
			wt = w;
		}

		@Override
		public int compareTo(Edge o) {
			if (wt != o.wt) {
				if (wt > o.wt)
					return 1;
				else
					return -1;
			}
			if (s != o.s)
				return s - o.s;
			return e - o.e;
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

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}
	}
}
