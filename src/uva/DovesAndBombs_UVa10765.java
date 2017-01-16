package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class DovesAndBombs_UVa10765 {
	static int V, m, counter, root, rootChildren, CC, ConnectedC;
	static ArrayList<Integer>[] adjList, adjList2;
	static ArrayList<Pair> artPoints;
	static int[] dfs_num, dfs_low, parent;
	static int ap[];

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (true) {
			V = sc.nextInt();
			m = sc.nextInt();
			if (V == 0 && m == 0)
				break;
			adjList = new ArrayList[V];
			for (int i = 0; i < adjList.length; i++) {
				adjList[i] = new ArrayList<Integer>();
			}
			adjList2 = new ArrayList[V];
			for (int i = 0; i < adjList2.length; i++) {
				adjList2[i] = new ArrayList<Integer>();
			}
			artPoints = new ArrayList<Pair>();
			dfs_num = new int[V];
			dfs_low = new int[V];
			parent = new int[V];
			ap = new int[V];
			Arrays.fill(ap, 1);
			vis = new boolean[V];
			while (true) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				if (u == -1 && v == -1)
					break;
				if (!adjList[u].contains(v))
					adjList[u].add(v);
				if (!adjList[v].contains(u))
					adjList[v].add(u);
			}
			artPoints();
			for (int i = 0; i < ap.length; i++) {
				artPoints.add(new Pair(i, ap[i]));
			}
			Collections.sort(artPoints);
			for (int i = 0; i < m; i++) {

				sb.append(artPoints.get(i) + "\n");
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}

	static void artPoints() {
		for (int i = 0; i < V; i++) {
			if (dfs_num[i] == 0) {
				ConnectedC++;
				counter = 0;
				root = i;
				rootChildren = 0;
				dfs(i);
				if (rootChildren <= 1)
					ap[i]--;

			}
		}
	}

	static void dfs(int u) {
		dfs_num[u] = dfs_low[u] = ++counter;
		for (int v : adjList[u]) {
			if (dfs_num[v] == 0) {
				parent[v] = u;
				if (root == u)
					rootChildren++;
				dfs(v);
				if (dfs_low[v] >= dfs_num[u]) {
					ap[u]++;
				}

				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);
			} else if (parent[u] != v)
				dfs_low[u] = Math.min(dfs_low[u], dfs_num[v]);
		}
	}

	static boolean vis[];

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

class Pair implements Comparable {
	int idx, p;

	Pair(int x, int y) {
		idx = x;
		p = y;
	}

	@Override
	public int compareTo(Object o) {
		Pair pr = (Pair) o;
		if (p == pr.p)
			return idx - pr.idx;
		return -p + pr.p;
	}

	public String toString() {
		return idx + " " + p;
	}
}
