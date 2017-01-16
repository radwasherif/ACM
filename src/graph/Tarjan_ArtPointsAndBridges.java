package graph;

import java.util.ArrayList;

/*
 * To find articulation points and bridges
 */
public class Tarjan_ArtPointsAndBridges {
	static int[] dfs_num, dfs_low, parent;
	static boolean[] artPoints;
	static ArrayList<Integer> adjList[];
	static int V, counter, root, rootChildren;

	static void artPointsAndBridges() {
		for (int i = 0; i < V; i++) {
			if (dfs_num[i] == 0) {
				root = i;
				counter = 0; 
				rootChildren = 0; 
				dfs(i);
				if(rootChildren <= 1)
					artPoints[i] = false; 
			}
		}
	}

	static void dfs(int u) {
		dfs_num[u] = dfs_low[u] = counter++;
		for (int v : adjList[u])
			if (dfs_num[v] == 0) {
				parent[v] = u;
				if (root == u) // just a check for the special case
					++rootChildren;
				dfs(v);
				if (dfs_low[v] >= dfs_num[u])
					artPoints[u] = true;
				if (dfs_low[v] > dfs_num[u])
					System.out.printf("Bridge between nodes %d and %d\n", u, v);
				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);
			} else {
				if (parent[u] != v)
					dfs_low[u] = Math.min(dfs_low[u], dfs_num[v]);
			}
	}
}
