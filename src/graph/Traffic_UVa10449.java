package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import graph.SSSP.Pair;

public class Traffic_UVa10449 {
	static int V;
	static ArrayList<Pair> adjList[];
	static int[] bus, dist;
	static final int INF = 1000000000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int c = 2;
		int t = 1;
		while (c-- > 0) {
			// while (sc.ready()) {
			V = sc.nextInt();
			sb.append("Set #" + t++ + "\n");
			// if (V == 0)
			// continue;
			bus = new int[V];
			for (int i = 0; i < bus.length; i++) {
				bus[i] = sc.nextInt();
			}
			adjList = new ArrayList[V];
			for (int i = 0; i < adjList.length; i++)
				adjList[i] = new ArrayList<Pair>();
			int r = sc.nextInt();
			while (r-- > 0) {
				int i = sc.nextInt();
				i--;
				int j = sc.nextInt();
				j--;
				int cost = (bus[j] - bus[i]);
				cost *= cost * cost;
				adjList[i].add(new Pair(j, cost));
			}
			if (V > 0)
				bellmanFord(0);
			int q = sc.nextInt();

			while (q-- > 0) {
				int d = dist[sc.nextInt() - 1];
				sb.append(((d < 3) ? "?" : d) + "\n");
			}
		}
		System.out.print(sb);
	}

	static void bellmanFord(int S) {
		dist = new int[V];
		Arrays.fill(dist, INF);
		dist[S] = 0;
		boolean modified = true;
		for (int k = 0; modified && k < V - 1; k++) {
			modified = false;
			for (int u = 0; u < V; u++) {
				for (Pair nxt : adjList[u])
					if (dist[u] != INF && dist[u] + nxt.wt < dist[nxt.node]) {
						modified = true;
						dist[nxt.node] = dist[u] + nxt.wt;
					}

			}
			System.out.println("k " + k + " " + Arrays.toString(dist));
		}
		for (int u = 0; u < V; u++)
			for (Pair nxt : adjList[u])
				if (dist[u] + nxt.wt < dist[nxt.node])
					dist[nxt.node] = -INF;
	}

	static class Pair implements Comparable<Pair> {
		int node, wt;

		Pair(int n, int w) {
			node = n;
			wt = w;
		}

		@Override
		public int compareTo(Pair o) {
			if (wt != o.wt)
				return wt - o.wt;
			return node - o.node;
		}
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(System.in));

		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		boolean ready() throws IOException {
			return br.ready();
		}
	}
}
