package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Toposort {
	/*
	 * Kahn's algorithm
	 */
	static int N;
	static ArrayList<Integer>[] adjList;
	static int inDegree[];
	static int[] result;
	static boolean taken[];

	public static void main(String[] args) throws IOException {
		// Generate all possible toposorts
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		adjList = new ArrayList[N];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		while (true) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			if (i == 0 && j == 0)
				break;
			adjList[i - 1].add(j - 1);
		}
		inDegree = new int[N];
		for (int i = 0; i < inDegree.length; i++) {
			for (int n : adjList[i])
				++inDegree[n];
		}
		result = new int[N];
		taken = new boolean[N];
		backtrack(0);
	}

	static void backtrack(int idx) {
		if (idx == N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		// pick one of the current nodes with no incoming edges
		for (int u = 0; u < N; ++u)
			if (inDegree[u] == 0 && !taken[u]) {
				// let's try this node to generate some toposorts
				taken[u] = true;
				for (int v : adjList[u])
					--inDegree[v];

				result[idx] = u + 1;

				backtrack(idx + 1);
				// since we are going to pick a different node, restore
				// everything
				taken[u] = false;
				for (int v : adjList[u])
					++inDegree[v];
			}

	}

	static void toposort() {
		int p[] = new int[N];
		for (int i = 0; i < p.length; i++) {
			for (int n : adjList[i])
				++p[n];
		}
		Queue<Integer> roots = new LinkedList<Integer>();
		for (int i = 0; i < p.length; i++) {
			if (p[i] == 0)
				roots.add(i);
		}
		while (!roots.isEmpty()) {
			int u = roots.poll();

			for (int v : adjList[u]) {
				if (--p[v] == 0)
					roots.add(v);
			}
		}
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {

			br = new BufferedReader(new InputStreamReader(s));

		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}
}
