package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class LiftHopping_UVa10801 {
	static int n, k;
	static int T[];
	static ArrayList<Integer> nodeOfElev[]; // the nodes that every elevator can
											// go to
	static ArrayList<Integer> elevOfNode[]; // every elevator that stops at a
											// certain node

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int c = 1;
		while (sc.ready()) {
			n = sc.nextInt();
			k = sc.nextInt();
			T = new int[n];
			for (int i = 0; i < T.length; i++)
				T[i] = sc.nextInt();
			nodeOfElev = new ArrayList[n];
			elevOfNode = new ArrayList[100];
			for (int i = 0; i < elevOfNode.length; i++) {
				elevOfNode[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < nodeOfElev.length; i++) {
				StringTokenizer st = new StringTokenizer(sc.nextLine());
				nodeOfElev[i] = new ArrayList<Integer>();
				while (st.hasMoreTokens()) {
					int node = Integer.parseInt(st.nextToken());
					nodeOfElev[i].add(node);
					elevOfNode[node].add(i);
				}
			}
			// System.out.println(Arrays.toString(elevOfNode));
			int d = dijkstra(0);
			sb.append(((d > -1) ? d : "IMPOSSIBLE") + "\n");
		}
		System.out.print(sb);
	}

	static final int INF = 1000000000;

	static int dijkstra(int S) {
		int[] dist = new int[100];
		Arrays.fill(dist, INF);
		dist[S] = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		pq.add(new Pair(0, 0, -1));
		while (!pq.isEmpty()) {
			Pair cur = pq.remove();
			if (cur.node == k)
				return dist[cur.node];
			if (cur.wt > dist[cur.node])
				continue;
			// System.out.println("Cur " + cur.node);
			for (int e : elevOfNode[cur.node]) {
				// System.out.println("e " + e);
				for (int nxt : nodeOfElev[e]) {
					// System.out.println("nxt " + nxt);
					int cost = cur.wt + Math.abs(nxt - cur.node) * T[e];
					if (cur.elev != -1 && cur.elev != e)
						cost += 60;
					if (cost < dist[nxt]) {
						// System.out.println(nxt + " " + cost);
						pq.add(new Pair(nxt, dist[nxt] = cost, e));
					}
				}
			}
		}
		return -1;
	}

	static class Pair implements Comparable<Pair> {
		int node, wt, elev;

		Pair(int n, int w, int e) {
			node = n;
			wt = w;
			elev = e;
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

		String nextLine() throws IOException {
			return br.readLine();
		}

		boolean ready() throws IOException {
			return br.ready();
		}

	}
}
