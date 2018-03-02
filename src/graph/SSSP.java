
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
	static int dijkstra(int S, int T) {
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
	 * Each iteration generates the shortest path with length i, so at the last iteration, we generate the shortest possible path
	 * with length V-1
	 * 
	 * https://www.geeksforgeeks.org/dynamic-programming-set-23-bellman-ford-algorithm/
	 * 
	 */

	static boolean bellmanFord(int S) {
		int dist[] = new int[V];

		Arrays.fill(dist, INF);
		dist[S] = 0;
		boolean modified = true;
		for (int i = 1; modified && i < V; i++) { // repeat V - 1, since the longest simple path is of length V - 1, O(V)
			modified = false;
			
			//these two loops, enumerate all edges in O(E)
			for (int u = 0; u < V; u++) { 
				for (Pair v : adjList[u]) {
					if (dist[v.node] > dist[u] + v.wt) {
						dist[v.node] = dist[u] + v.wt;
						modified = true;
					}
				}
			}
		}

		/**
		 * Since the previous step generates the shortest possible path, 
		 * then if a shorter path still exists, then there's a negative cycle 
		 */
		boolean hasNegCycle = false;
		for (int u = 0; u < V; u++)
			for (Pair v : adjList[u])
				if (dist[v.node] > dist[u] + v.wt)
					hasNegCycle = true;

		return hasNegCycle;
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
