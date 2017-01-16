package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ClawDecomposition_UVa11396 {
	static int V;
	static ArrayList<Integer> adjList[];
	static int color[];

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Scanner sc = new Scanner(System.in);
		int V;
		StringBuilder sb = new StringBuilder();
		while (true) {
			V = sc.nextInt();
			if (V == 0)
				break;
			adjList = new ArrayList[V + 1];
			for (int i = 0; i < adjList.length; i++) {
				adjList[i] = new ArrayList<Integer>();
			}
			color = new int[V + 1];
			Arrays.fill(color, -1);
			while (true) {
				int i = sc.nextInt();
				int j = sc.nextInt();
				if (i == 0 && j == 0)
					break;
				adjList[i].add(j);
				adjList[j].add(i);
			}
			String ans = (bipartite_bfs(1)) ? "YES\n" : "NO\n";
			sb.append(ans);
		}
		System.out.print(sb);
	}

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
