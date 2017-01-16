package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
public class SSSP {
	static final int INF = 1000000000;
	static ArrayList<Pair> adjList[];
	static int V;

	/*
	 * O(ElogV)
	 */
	int dijkstra(int S, int T) {
		int dist[] = new int[V];
		Arrays.fill(dist, INF);
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		pq.add(new Pair(S, 0));
		while (!pq.isEmpty()) {
			Pair cur = pq.remove();
			if (cur.node == T)
				return dist[cur.node];
			if (cur.wt > dist[cur.node])
				continue;
			for (Pair nxt : adjList[cur.node])
				if (cur.wt + nxt.wt < dist[nxt.node])
					pq.add(new Pair(nxt.node, dist[nxt.node] = cur.wt + nxt.wt));
		}
		return -1;

	}

	/*
	 * O(EV)
	 */
	static boolean bellmanFord(int S) {
		int dist[] = new int[S];
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
		for (int u = 0; u < V; u++)
			for (Pair nxt : adjList[u])
				if (dist[u] + nxt.wt < dist[nxt.node])
					negCycle = true;
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
}
