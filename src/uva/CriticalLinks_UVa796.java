package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class CriticalLinks_UVa796 {
	static int[] dfs_num, dfs_low, parent;
	static boolean artPoints[];
	static int root, V, rootChildren, counter;
	static ArrayList<Integer> adjList[];
	static ArrayList<Pair> bridges;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = 4;
		while (sc.ready()) {
			// while (t-- > 0) {

			V = sc.nextInt();
			if (V == 0) {
				sb.append("0 critical links\n\n");
				sc.nextLine();
				continue;
			}
			dfs_num = new int[V];
			dfs_low = new int[V];
			parent = new int[V];
			artPoints = new boolean[V];
			adjList = new ArrayList[V];
			counter = 0;
			bridges = new ArrayList<Pair>();
			for (int i = 0; i < adjList.length; i++)
				adjList[i] = new ArrayList<Integer>();
			for (int i = 0; i < V; i++) {
				int p = sc.nextInt();
				String s = sc.next();
				int children = Integer.parseInt(s.substring(1, s.length() - 1));
				while (children-- > 0) {
					int j = sc.nextInt();
					if (!adjList[p].contains(j))
						adjList[p].add(j);
					if (!adjList[j].contains(p))
						adjList[j].add(p);
				}
			}
			findBridges();
			sb.append(bridges.size() + " critical links\n");
			// bridges.sort(Pair.comp());
			Collections.sort(bridges);
			for (Pair p : bridges)
				sb.append(p.toString() + "\n");
			sb.append('\n');
			if (sc.ready())
				sc.nextLine();
		}
		System.out.print(sb);
	}

	static void findBridges() {
		for (int i = 0; i < V; i++) {
			if (dfs_num[i] == 0) {
				rootChildren = 0;
				dfs(i);
				if (rootChildren <= 1)
					artPoints[i] = false;
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
				if (dfs_low[v] >= dfs_num[u])
					artPoints[u] = true;
				if (dfs_low[v] > dfs_num[u]) {
					int i = Math.min(u, v);
					int j = Math.max(u, v);
					bridges.add(new Pair(i, j));
				}
				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);
			} else if (parent[u] != v)
				dfs_low[u] = Math.min(dfs_low[u], dfs_num[v]);

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

		String nextLine() throws IOException {
			return br.readLine();
		}

		boolean ready() throws IOException {
			return br.ready();
		}
	}
}

