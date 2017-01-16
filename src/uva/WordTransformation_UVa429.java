package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class WordTransformation_UVa429 {
	static TreeMap<String, Integer> dict;
	static String deMap[];
	static int V;
	static ArrayList<Integer> adjList[];
	static int[] p, dist;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		br.readLine();
		while (T-- > 0) {
			V = 0;
			dict = new TreeMap<String, Integer>();
			deMap = new String[500];
			while (true) {
				String s = br.readLine();
				if (s.equals("*"))
					break;
				dict.put(s, V);
				deMap[V++] = s;
			}
			adjList = new ArrayList[V];
			for (int i = 0; i < adjList.length; i++) {
				adjList[i] = new ArrayList<Integer>();
			}
			// System.out.println(V);
			for (int i = 0; i < V; i++) {
				for (int j = i + 1; j < V; j++) {
					if (compare(deMap[i], deMap[j])) {
						adjList[i].add(j);
						adjList[j].add(i);
					}
				}
			}
			String line;

			while (br.ready()) {
				line = br.readLine();
				if (line.trim().isEmpty())
					break;
				p = new int[V];
				dist = new int[V];
				StringTokenizer st = new StringTokenizer(line);
				String s1 = st.nextToken();
				String s2 = st.nextToken();
				int i = dict.get(s1);
				int j = dict.get(s2);
				bfs(i);
				sb.append(s1 + " " + s2 + " " + dist[j] + "\n");

				// System.out.println("YO");
			}
			if (T > 0)
				sb.append("\n");
		}
		System.out.print(sb);
	}

	static boolean vis[];

	static void bfs(int s) {
		vis = new boolean[V];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		while (!q.isEmpty()) {
			int u = q.remove();
			vis[u] = true;
			for (int v : adjList[u]) {
				if (!vis[v]) {
					dist[v] = dist[u] + 1;
					q.add(v);
				}
			}
		}

	}

	static boolean compare(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		int c = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i))
				c++;
		}
		if (c == 1)
			return true;
		return false;
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
