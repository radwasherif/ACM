package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class TransportationSystem_UVa112288 {
	static int[] x, y;
	static int V;
	static double r;
	static ArrayList<Edge> edgeList;
	static DisjointSet ds;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Scanner sc = new Scanner(System.in);
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
		// StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {

			V = sc.nextInt();
			r = sc.nextInt();
			x = new int[V];
			y = new int[V];
			for (int i = 0; i < V; i++) {
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
			}
			edgeList = new ArrayList<Edge>();
			ds = new DisjointSet(V);
			for (int i = 0; i < V; i++) {
				for (int j = i + 1; j < V; j++) {
					int dx = Math.abs(x[i] - x[j]);
					int dy = Math.abs(y[i] - y[j]);
					double dist = Math.sqrt(dx * dx + dy * dy);
					if (dist <= r)
						ds.union(i, j);
					edgeList.add(new Edge(i, j, dist));
				}
			}
			int states = ds.numSets;
			mstLong = 0;
			mstShort = 0;
			mst();
			sb.append("Case #" + t + ": " + states + " " + Math.round(mstShort)
					+ " " + Math.round(mstLong) + "\n");

		}
		System.out.print(sb);
	}

	static double mstLong, mstShort;

	static void mst() {

//		Collections.shuffle(edgeList);
		Collections.sort(edgeList);
		ds = new DisjointSet(V);
		for (Edge e : edgeList) {
			if (!ds.sameSet(e.from, e.to)) {
				if (e.wt <= r)
					mstShort += e.wt;
				else
					mstLong += e.wt;
				ds.union(e.from, e.to);
			}
		}

	}

	static class DisjointSet {
		int[] p, rank, setSize;
		int numSets;

		DisjointSet(int N) {
			p = new int[N];
			rank = new int[N];
			setSize = new int[N];
			numSets = N;
			Arrays.fill(setSize, 1);
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
				setSize[x] += setSize[y];
			} else {
				p[x] = y;
				setSize[y] += setSize[x];
				if (rank[x] == rank[y])
					rank[y]++;
			}
		}
	}

	static class Edge implements Comparable<Edge> {
		int from, to;
		double wt;

		Edge(int f, int t, double w) {
			from = f;
			to = t;
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
			if (from != o.from)
				return from - o.from;
			return to - o.to;
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
