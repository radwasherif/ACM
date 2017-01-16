package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class DarkRoads_UVa11631 {
	static int V;
	static ArrayList<Edge> edgeList;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (true) {
			V = sc.nextInt();
			int n = sc.nextInt();
			if (n == 0 && V == 0)
				break;
			edgeList = new ArrayList<Edge>();
			int totalWt = 0;
			for (int i = 0; i < n; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int z = sc.nextInt();
				edgeList.add(new Edge(x, y, z));
				totalWt += z;
			}
			int mst = mst();
			sb.append((totalWt - mst) + "\n");
		}
		System.out.print(sb);
	}

	static int mst() {
		int mst = 0;
		// Collections.shuffle(edgeList);
		Collections.sort(edgeList);
		DisjointSet ds = new DisjointSet(V);
		for (Edge e : edgeList) {
			if (!ds.sameSet(e.from, e.to)) {
				mst += e.wt;
				ds.union(e.from, e.to);
			}
		}
		return mst;
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
		int wt;

		Edge(int f, int t, int w) {
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
