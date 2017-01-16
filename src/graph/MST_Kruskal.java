package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MST_Kruskal {
	static ArrayList<Edge> edgeList;
	static int V;
/*
 * O(ElogV) 
 */
	static int mst() {
		int mst = 0;
		Collections.shuffle(edgeList);
		Collections.sort(edgeList);
		DisjointSet ds = new DisjointSet(V);
		for (Edge e : edgeList) {
			if (!ds.sameSet(e.s, e.e)) {
				mst += e.wt;
				ds.union(e.s, e.e);
			}
		}
		return mst;
	}

	static class Edge implements Comparable<Edge> {
		int s, e, wt;

		Edge(int f, int t, int w) {
			s = f;
			e = t;
			wt = w;
		}

		@Override
		public int compareTo(Edge o) {
			if (wt != o.wt)
				return wt - o.wt;
			if (s != o.s)
				return s - o.s;
			return e - o.e;
		}

	}

	static class DisjointSet {
		int[] rank, p, setSize;
		int numSets;

		public DisjointSet(int N) {
			rank = new int[N];
			p = new int[N];
			setSize = new int[N];
			numSets = N;
			Arrays.fill(setSize, 1); // initially all sets are of size 1
			for (int i = 0; i < p.length; i++) {
				p[i] = i; // each node is a parent of itself at the beginning
			}
		}

		int findSet(int i) {
			if (p[i] == i)
				return i;
			return p[i] = findSet(p[i]);
		}

		boolean sameSet(int i, int j) {
			return findSet(i) == findSet(j);
		}

		void union(int i, int j) {
			if (sameSet(i, j))
				return;
			numSets--; 
			int x = findSet(i);
			int y = findSet(j);
			if (rank[x] > rank[y]) {
				p[y] = x;
				setSize[x] += setSize[y];
			} else {
				p[x] = y;
				setSize[y] += setSize[x];
				if (rank[x] == rank[y])
					rank[y]++;
			}
		}
	}

}
