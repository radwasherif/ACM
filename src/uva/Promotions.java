package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Promotions {
	static int A, B, V, P, TS;
	static ArrayList<Integer> adjList[];
	static int count;
	static int succ[], pred[];
	static boolean vis[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
//		 int c = 1;
//		 while (c-- > 0) {
		while (sc.ready()) {
			A = sc.nextInt();
			B = sc.nextInt();
			V = sc.nextInt();
			P = sc.nextInt();
			adjList = new ArrayList[V];
			pred = new int[V];
			for (int i = 0; i < adjList.length; i++) {
				adjList[i] = new ArrayList<Integer>();

			}
			while (P-- > 0) {
				int i = sc.nextInt();
				int j = sc.nextInt();
				adjList[i].add(j);
			}
			succ = new int[V];
			// pred = new int[V];
			for (int i = 0; i < V; i++) {
				vis = new boolean[V];
				count = 0;
				dfs(i);
				succ[i] = count;
			}
			int def_a = 0, def_b = 0, imposs = 0;
			// System.out.println(Arrays.toString(pred));
			// System.out.println(Arrays.toString(succ));
			for (int i = 0; i < succ.length; i++) {
				if (V - succ[i] <= A)
					def_a++;
				if (V - succ[i] <= B)
					def_b++;
				if (pred[i] >= B)
					imposs++;

			}
			sb.append(def_a + "\n" + def_b + "\n" + imposs + "\n");
		}
		System.out.print(sb);
	}

	static void dfs(int u) {
		vis[u] = true;
		for (int v : adjList[u]) {
			if (!vis[v]) {
				count++;
				dfs(v);
				pred[v]++;
			}
		}
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		boolean ready() throws IOException {
			return br.ready();
		}

	}
}
