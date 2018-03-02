package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Wormholes_UVa558 {
	static ArrayList<Edge> adjList[];
	static int n;
	static final int INF = (int) 1e9;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int c = sc.nextInt();
		while (c-- > 0) {
			n = sc.nextInt();
			int m = sc.nextInt();
			adjList = new ArrayList[n];

			for (int i = 0; i < n; i++)
				adjList[i] = new ArrayList<>();

			while (m-- > 0) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				int wt = sc.nextInt();
				adjList[u].add(new Edge(v, wt));
			}
			if(bellmanFord(0)) {
				out.println("possible");
			} else {
				out.println("not possible");
			}
			
		}
		out.flush();
		out.close();
	}

	static boolean bellmanFord(int S) {
		int dist[] = new int[n];
		Arrays.fill(dist, INF);
		dist[S] = 0;
		boolean mod = true;
		for (int i = 1; mod && i < n; i++) {
			mod = false;
			for (int u = 0; u < n; u++)
				for (Edge nxt : adjList[u]) {
					if (dist[u] + nxt.wt < dist[nxt.to]) {
						mod = true;
						dist[nxt.to] = dist[u] + nxt.wt;
					}
				}

		}

		boolean negCycle = false;
		for (int u = 0; u < n; u++)
			for (Edge v : adjList[u])
				if (dist[u] + v.wt < dist[v.to])
					negCycle = true;

		return negCycle;
	}

	static class Edge implements Comparable<Edge> {
		int to, wt;

		public Edge(int to, int wt) {
			this.to = to;
			this.wt = wt;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return wt - o.wt;
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
