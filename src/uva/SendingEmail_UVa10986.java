package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SendingEmail_UVa10986 {
	static int V;
	static ArrayList<Pair> adjList[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= TC; t++) {
			V = sc.nextInt();
			int m = sc.nextInt();
			int S = sc.nextInt();
			int T = sc.nextInt();
			adjList = new ArrayList[V];
			for (int i = 0; i < adjList.length; i++) {
				adjList[i] = new ArrayList<Pair>();
			}
			while (m-- > 0) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int w = sc.nextInt();
				if (!adjList[a].contains(b))
					adjList[a].add(new Pair(b, w));
				if (!adjList[b].contains(a))
					adjList[b].add(new Pair(a, w));
			}
			int d = dijkstra(T, S);
			if (d == -1)
				sb.append("Case #" + t + ": unreachable\n");
			else
				sb.append("Case #" + t + ": " + d + "\n");
		}
		System.out.print(sb);
	}

	static final int INF = 1000000000;

	static int dijkstra(int T, int S) {
		int dist[] = new int[V];
		Arrays.fill(dist, INF);
		dist[S] = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		pq.add(new Pair(S, 0));
		while (!pq.isEmpty()) {
			Pair cur = pq.remove();
			if (cur.node == T)
				return dist[cur.node];
			if (cur.wt > dist[cur.node])
				continue;
			for (Pair nxt : adjList[cur.node]) {
				if (cur.wt + nxt.wt < dist[nxt.node])
					pq.add(new Pair(nxt.node, dist[nxt.node] = cur.wt + nxt.wt));
			}
		}
		return -1;

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
