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

public class SpreadingTheNews_UVa924 {
	static ArrayList<Integer> adjList[];
	static int dist[];
	static boolean[] vis;
	static int E;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		E = sc.nextInt();
		adjList = new ArrayList[E];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < E; i++) {
			int c = sc.nextInt();
			while (c-- > 0) {
				int j = sc.nextInt();
				if (!adjList[i].contains(j))
					adjList[i].add(j);
				// if (!adjList[j].contains(i))
				// adjList[j].add(i);
			}

		}
		int T = sc.nextInt();
		while (T-- > 0) {
			int s = sc.nextInt();
			if (adjList[s].isEmpty()) {
				sb.append("0\n");
				continue;
			}
			bfs(s);

			Arrays.sort(dist);
			// System.out.println(Arrays.toString(dist));
			int[] count = new int[dist[dist.length - 1] + 1];
			for (int i = 0; i < dist.length; i++) {
				if (vis[i])
					count[dist[i]]++;
			}
			int max_count = -1;
			int max_day = -1;
			// count[s] = 0;
			for (int i = 0; i < count.length; i++) {
				if (count[i] > max_count) {
					max_count = count[i];
					max_day = i;
				}
			}
			// System.out.println(Arrays.toString(count));
			sb.append(max_count + " " + max_day + "\n");

		}
		System.out.print(sb);
	}

	static void bfs(int s) {
		vis = new boolean[E];
		dist = new int[E];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		vis[s] = true;
		while (!q.isEmpty()) {
			int u = q.remove();
			// System.out.println("u: " + u);
			// vis[u] = true;
			for (int v : adjList[u]) {
				if (!vis[v]) {
					// System.out.println("v: " + v);
					dist[v] = dist[u] + 1;
					q.add(v);
					vis[v] = true;
				}
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
