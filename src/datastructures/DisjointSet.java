package datastructures;

import java.util.Arrays;

public class DisjointSet {
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
