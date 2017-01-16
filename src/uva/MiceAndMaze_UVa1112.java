package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MiceAndMaze_UVa1112 {
	static int N, T, E;
	static ArrayList<Pair> adjList[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while (TC-- > 0) {
			N = sc.nextInt();
			E = sc.nextInt();
			T = sc.nextInt();
			E--; // to make it zero-based
			adjList = new ArrayList[N];
			for (int i = 0; i < adjList.length; i++) {
				adjList[i] = new ArrayList<Pair>();
			}
			int m = sc.nextInt();
			while (m-- > 0) {
				int a = sc.nextInt();
				a--;
				int b = sc.nextInt();
				b--;
				int cost = sc.nextInt();
				adjList[a].add(new Pair(b, cost));
			}
			// System.out.println(N + " " + E + " " + T);
			int ans = 0;
			for (int i = 0; i < N; i++) {
				int d = dijkistra(i);
				// System.out.println(d);
				if (d >= 0 && d <= T)
					ans++;
			}
			sb.append(ans + "\n");
			if (TC > 0)
				sb.append("\n");
		}
		System.out.print(sb);
	}

	static final int INF = 1000000000;

	static int dijkistra(int S) {
		int dist[] = new int[N];
		Arrays.fill(dist, INF);
		dist[S] = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		pq.add(new Pair(S, 0));
		// System.out.println("Source " + S);
		while (!pq.isEmpty()) {
			Pair cur = pq.remove();
			// System.out.println("Cur " + cur.node);
			if (cur.node == E)
				return dist[cur.node];
			if (cur.wt > dist[cur.node])
				continue;
			// System.out.println("Next: ");
			for (Pair nxt : adjList[cur.node]) {
				if (cur.wt + nxt.wt < dist[nxt.node]) {
					pq.add(new Pair(nxt.node, dist[nxt.node] = cur.wt + nxt.wt));
				}
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
