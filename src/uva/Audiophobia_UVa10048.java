package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Audiophobia_UVa10048 {
	static int V;
	static ArrayList<Pair> adjList[];
	static ArrayList<Edge> edgeList;
	static int dest, max;
	static boolean[] vis, mst;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = 1;
		while (true) {
			V = sc.nextInt();
			int E = sc.nextInt();
			int Q = sc.nextInt();
			if (V == 0 && E == 0 && Q == 0)
				break;
			adjList = new ArrayList[V + 1];
			for (int i = 0; i < adjList.length; i++)
				adjList[i] = new ArrayList<Pair>();
			edgeList = new ArrayList<Edge>();
			// for (int i = 0; i < edgeList.length; i++) {
			// edgeList[i] = new ArrayList<Edge>();
			// }
			while (E-- > 0) {
				int i = sc.nextInt();
				int j = sc.nextInt();
				int wt = sc.nextInt();
				edgeList.add(new Edge(i, j, wt));
			}
			mst = new boolean[V + 1];
			vis = new boolean[V + 1];
			mst();
			if (t > 1)
				sb.append("\n");
			sb.append("Case #" + t++ + "\n");
			while (Q-- > 0) {
				vis = new boolean[V + 1];
				int i = sc.nextInt();
				dest = sc.nextInt();
				max = -1;
				if (dfs(i))
					sb.append(max + "\n");
				else
					sb.append("no path\n");
			}

		}
		System.out.print(sb);
	}

	static int mst() {
		int mst = 0;
		Collections.shuffle(edgeList);
		Collections.sort(edgeList);
		DisjointSet ds = new DisjointSet(V);
		for (Edge e : edgeList) {
			if (!ds.sameSet(e.from, e.to)) {
				adjList[e.from].add(new Pair(e.to, e.wt));
				adjList[e.to].add(new Pair(e.from, e.wt));
				ds.union(e.from, e.to);
			}
		}
		return mst;
	}

	static boolean dfs(int u) {
		if (u == dest)
			return true;
		vis[u] = true;
		for (Pair p : adjList[u]) {
			if (!vis[p.to] && dfs(p.to)) {
				max = Math.max(p.wt, max);
				return true;
			}
		}
		return false;
	}

	static class Pair {
		int to, wt;

		Pair(int t, int w) {
			to = t;
			wt = w;
		}
	}

	static class Edge implements Comparable<Edge> {
		int from, to, wt;

		Edge(int from, int to, int wt) {
			this.from = from;
			this.to = to;
			this.wt = wt;
		}

		@Override
		public int compareTo(Edge o) {
			if (wt != o.wt)
				return wt - o.wt;
			return to - o.to;
		}
	}

	static class DisjointSet {
		int[] p, rank, setSize;
		int numSets;

		DisjointSet(int N) {
			p = new int[N + 1];
			rank = new int[N + 1];
			setSize = new int[N + 1];
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
			int x = findSet(i);
			int y = findSet(j);
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

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}
	}
}
