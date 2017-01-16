package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Beverages_UVa11060 {
	static ArrayList<Integer>[] adjList;
	static int N;
	static ArrayList<Integer> sortedArray;
	static int inDegree[];
	static TreeMap<String, Integer> map;
	static String[] deMap;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = 1;
		int c = 3;
		while (sc.ready()) {
			// while (c-- > 0) {
			N = sc.nextInt();
			map = new TreeMap<String, Integer>();
			deMap = new String[N];
			inDegree = new int[N];
			sortedArray = new ArrayList<Integer>();
			for (int i = 0; i < N; i++) {
				String s = sc.next();
				map.put(s, i);
				deMap[i] = s;
			}
			adjList = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				adjList[i] = new ArrayList<Integer>();
			}
			int m = sc.nextInt();
			inDegree = new int[N];
			vis = new boolean[N];
			while (m-- > 0) {
				int i = map.get(sc.next());
				int j = map.get(sc.next());
				if (!adjList[i].contains(j)) {
					adjList[i].add(j);
					inDegree[j]++;
				}
			}
			for (int i = 0; i < N; i++) {
				Collections.shuffle(adjList[i]);
				Collections.sort(adjList[i]);
			}
			toposort();
			sb.append("Case #" + t++
					+ ": Dilbert should drink beverages in this order: "
					+ deMap[sortedArray.get(0)]);
			for (int i = 1; i < N; i++) {
				sb.append(" " + deMap[sortedArray.get(i)]);
			}
			sb.append(".\n\n");
			sc.nextLine();
		}
		System.out.print(sb);
	}

	static boolean[] vis;

	static void toposort() {
		Queue<Integer> root = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			if (inDegree[i] == 0 && !vis[i]) {
				root.add(i);
				break;
			}

		}
		while (!root.isEmpty()) {
			int u = root.poll();
			sortedArray.add(u);
			vis[u] = true;
			for (int v : adjList[u]) {
				--inDegree[v];
			}
			for (int v = 0; v < N; v++) {
				if (inDegree[v] == 0 && !vis[v]) {
					root.add(v);
					break;
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
