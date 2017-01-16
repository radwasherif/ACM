package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Wormholes_UVa558 {
	static int V;
	static ArrayList<Pair> adjList[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int TC = sc.nextInt();
		while (TC-- > 0) {
			V = sc.nextInt();
			int m = sc.nextInt();
			adjList = new ArrayList[V];
			for (int i = 0; i < adjList.length; i++) {
				adjList[i] = new ArrayList<Pair>();
			}
			while (m-- > 0)
				adjList[sc.nextInt()].add(new Pair(sc.nextInt(), sc.nextInt()));
			boolean f = bellmanFord(0);
			if (f)
				sb.append("possible\n");
			else
				sb.append("not possible\n");
		}
		System.out.print(sb);

	}

	static final int INF = 1000000000;

	static boolean bellmanFord(int S) {
		int dist[] = new int[V];
		Arrays.fill(dist, INF);
		dist[S] = 0;
		boolean modified = true;
		for (int k = 0; modified && k < V - 1; k++) {
			modified = false;
			for (int u = 0; u < V; u++)
				for (Pair nxt : adjList[u])
					if (dist[u] + nxt.wt < dist[nxt.node]) {
						modified = true;
						dist[nxt.node] = dist[u] + nxt.wt;
					}

		}
		boolean negCycle = false;
		for (int u = 0; u < V; u++) {
			for (Pair nxt : adjList[u])
				if (dist[u] + nxt.wt < dist[nxt.node])
					negCycle = true;
		}
		return negCycle;
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
	}

}
