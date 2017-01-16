package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MST_Prim {
	static ArrayList<Edge> edgeList[];
	static int V;
	static boolean vis[];

	int mst() {
		int mst = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.add(new Edge(0, 0)); // This is a non-existent edge which ends in the
								// node 0 and has 0 weight, we could start at
								// any node
		while (!pq.isEmpty()) {
			Edge cur = pq.remove();
			if (vis[cur.to])
				continue;
			vis[cur.to] = true;
			mst += cur.wt;
			for (Edge nxt : edgeList[cur.to]) {
				if (!vis[nxt.to])
					pq.add(nxt);
			}
		}

		return mst;
	}

	static class Edge implements Comparable<Edge> {
		int to, wt;

		Edge(int t, int w) {
			to = t;
			wt = w;
		}

		@Override
		public int compareTo(Edge o) {
			if (wt != o.wt)
				return wt - o.wt;
			return to - o.to;
		}

	}
}
