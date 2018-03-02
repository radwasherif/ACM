package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Traffic_UVa10449 {
	static ArrayList<Edge> adjList[];
	static int n;
	static final int INF = (int) 1e9;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = 1;
		int c = sc.nextInt();
		while (c-- > 0) {
			// while (sc.ready()) {
			n = sc.nextInt();
			int cost[] = new int[n];
			for (int i = 0; i < n; i++)
				cost[i] = sc.nextInt();

			adjList = new ArrayList[n];

			for (int i = 0; i < n; i++)
				adjList[i] = new ArrayList<>();

			int r = sc.nextInt();
			while (r-- > 0) {

				int u = sc.nextInt() - 1;
				int v = sc.nextInt() - 1;
				if (n == 0)
					continue;
				int junc = cost[v] - cost[u];
				adjList[u].add(new Edge(v, junc * junc * junc));
			}
			int dist[] = new int[n];
			if (n > 0)
				dist = bellmanFord(0);
			int q = sc.nextInt();
			out.printf("Set #%d\n", t++);
			while (q-- > 0) {
				if (n == 0) {
					sc.nextInt();
					out.printf("?\n");
					continue;
				}
				int d = dist[sc.nextInt() - 1];
				if (d == INF || d < 3)
					out.println("?");
				else
					out.println(d);
			}
		}
		out.close();

	}

	static int[] bellmanFord(int S) {
		int[] dist = new int[n];
		Arrays.fill(dist, INF);
		dist[S] = 0;
		boolean mod = true;
		for (int i = 1; mod && i < n; i++) {
			mod = false;
			for (int u = 0; u < n; u++) {
				for (Edge v : adjList[u])
					if (dist[u] + v.wt < dist[v.node]) {
						mod = true;
						dist[v.node] = dist[u] + v.wt;
					}
			}
		}
		return dist;
	}

	static class Edge {
		int node, wt;

		public Edge(int node, int wt) {
			this.node = node;
			this.wt = wt;
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
