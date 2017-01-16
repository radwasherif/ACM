        package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class HighestPaidToll_UVa12047 {
	static int N, M, p;
	static ArrayList<Pair> adjList1[], adjList2[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		while (T-- > 0) {
			N = sc.nextInt();
			N++;
			M = sc.nextInt();
			int s = sc.nextInt();
			int t = sc.nextInt();
			p = sc.nextInt();
			adjList1 = new ArrayList[N];
			adjList2 = new ArrayList[N];
			for (int i = 0; i < adjList1.length; i++) {
				adjList1[i] = new ArrayList<Pair>();
				adjList2[i] = new ArrayList<Pair>();
			}
			while (M-- > 0) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				int c = sc.nextInt();
				adjList1[u].add(new Pair(v, c));
				adjList2[v].add(new Pair(u, c));
			}
			int max = (s == t) ? 0 : -1;
			int dist_s[] = dijkstra(s, t, adjList1);
			int dist_t[] = dijkstra(t, s, adjList2);
//			System.out.println(Arrays.toString(dist_s));
//			System.out.println(Arrays.toString(dist_t));
			for (int u = 1; u < N; u++)
				for (Pair nxt : adjList1[u])
					if (dist_s[u] + dist_t[nxt.node] + nxt.wt <= p)
						max = Math.max(max, nxt.wt);
			sb.append(max + "\n");
		}
		System.out.print(sb);
	}

	static class Pair implements Comparable<Pair> {
		int node, wt;

		Pair(int n, int w) {
			node = n;
			wt = w;
		}

		@Override
		public int compareTo(Pair arg0) {
			if (wt != arg0.wt)
				return wt - arg0.wt;
			return node - arg0.wt;
		}

	}

	static int INF = (int) 1e9;

	static int[] dijkstra(int S, int T, ArrayList<Pair> adjList[]) {
		int dist[] = new int[N];
		Arrays.fill(dist, INF);
		dist[S] = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		pq.add(new Pair(S, 0));
		while (!pq.isEmpty()) {
			Pair cur = pq.remove();
			// System.out.println(cur.node + " " + cur.wt + " " + cur.max);
			if (cur.wt > dist[cur.node])
				continue;
			for (Pair nxt : adjList[cur.node]) {
				if (cur.wt + nxt.wt < dist[nxt.node]) {
					pq.add(new Pair(nxt.node, dist[nxt.node] = cur.wt + nxt.wt));
				}
			}
		}
		return dist;
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
