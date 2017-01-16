package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTraversal {
	static ArrayList<Integer> adjList[];
	static boolean vis[];

	static void dfs(int u) {
		vis[u] = true;
		for (int v : adjList[u])
			if (!vis[v])
				dfs(v);
	}

	static void bfs(int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		vis[s] = true;
		while (!q.isEmpty()) {
			int u = q.poll();
			for (int v : adjList[u]) {
				if (!vis[v]) {
					vis[v] = true;
					q.add(v);
				}
			}
		}
	}

	// Bipartite graph check
	static int color[]; // to be prefilled with -1

	static boolean bipartite_bfs(int s) {
		color[s] = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		while (!q.isEmpty()) {
			int parent = q.poll();
			for (int child : adjList[parent]) {
				if (color[child] == -1) {
					color[child] = 1 ^ color[parent];
					q.add(child);
				} else if (color[child] == color[parent]) {
					return false;
				}
			}
		}
		return true;
	}
}
