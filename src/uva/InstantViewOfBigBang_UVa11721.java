package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class InstantViewOfBigBang_UVa11721 {
	static int n;
	static ArrayList<Edge>[] adjList;
	static ArrayList<Integer>[] revList; // reversed graph

	static int INF = (int) 1e9;
	static int[] dist;
	static boolean[] vis;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int c = sc.nextInt();
		int t = 1;
		while (c-- > 0) {
			n = sc.nextInt();
			int m = sc.nextInt();
			adjList = new ArrayList[n];
			revList = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				adjList[i] = new ArrayList<>();
				revList[i] = new ArrayList<>();
			}

			while (m-- > 0) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				int wt = sc.nextInt();
				adjList[u].add(new Edge(v, wt));
				revList[v].add(u);
			}
			vis = new boolean[n];
			bellmanFord(0);
			out.printf("Case %d:", t++);
			boolean found = false;
			for (int i = 0; i < vis.length; i++) {
				if (vis[i]) {
					out.printf(" %d", i);
					found = true;
				}
			}
			if (!found)
				out.print(" impossible");
			out.println();
		}
		out.flush();
		out.close();
	}

	static void bellmanFord(int S) {
		dist = new int[n];
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
		System.out.println(Arrays.toString(dist));

		for (int u = 0; u < n; u++)
			for (Edge v : adjList[u])
				if (dist[u] + v.wt < dist[v.to] && !vis[v.to]) {
					System.out.println(u + " " + v.to);
					dfs(u);
				}

	}

	static void dfs(int u) {
		vis[u] = true;
		for (int v : revList[u])
			if (!vis[v])
				dfs(v);
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
