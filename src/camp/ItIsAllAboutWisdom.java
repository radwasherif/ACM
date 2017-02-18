package camp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ItIsAllAboutWisdom {
	static final int INF = 1000000000;
	static ArrayList<Pair> adjList[];
	static int V, K;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out); 
		int T = sc.nextInt();
		while (T-- > 0) {
			V = sc.nextInt();
			int m = sc.nextInt();
			K = sc.nextInt();
			adjList = new ArrayList[V];
			for (int i = 0; i < adjList.length; i++)
				adjList[i] = new ArrayList<>();
			while (m-- > 0) {
				int v = sc.nextInt() - 1;
				int u = sc.nextInt() - 1;
				int wt = sc.nextInt();
				int wis = sc.nextInt();
				adjList[u].add(new Pair(v, wt, wis));
				adjList[v].add(new Pair(u, wt, wis));
			}
			int low = 0;
			int high = INF;
			int mid = 0;
			int ans = -1;
			while (low <= high) {
				mid = (low + high) >> 1;
				int d = dijkstra(0, V - 1, mid);
				// System.out.println("hi " + high + " low " + low );
				if (d != INF) {
					ans = mid;
					high = mid - 1;
					// System.out.println("ok " + mid);
					// System.out.println(d);
				} else {
					low = mid + 1;
					// System.out.println("not ok " + mid);
				}
			}
			out.println(ans);
		}
		out.flush();
		out.close();
	}

	static int dijkstra(int S, int T, int W) {
		int dist[] = new int[V];
		Arrays.fill(dist, INF);
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		pq.add(new Pair(S, 0, 0));
		dist[S] = 0;
		int c = 10;
		while (!pq.isEmpty()) {
			if (c-- > 0) {
				c--;
				// System.out.println(pq.toString());
			}
			Pair cur = pq.remove();
			if (cur.wt >= K)
				return INF;
			if (cur.node == T)
				return dist[cur.node];

			if (cur.wt > dist[cur.node])
				continue;

			for (Pair nxt : adjList[cur.node])
				if (nxt.wis <= W && cur.wt + nxt.wt < dist[nxt.node])
					pq.add(new Pair(nxt.node, dist[nxt.node] = cur.wt + nxt.wt, Math.max(nxt.wis, cur.wis)));
		}
		return INF;

	}

	static class Pair implements Comparable<Pair> {
		int node, wt, wis;

		Pair(int n, int w, int wis) {
			node = n;
			wt = w;
			this.wis = wis;
		}

		@Override
		public int compareTo(Pair o) {
			if (wt != o.wt)
				return wt - o.wt;
			return node - o.node;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return node + " " + wt + " " + wis;
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

	}
}
