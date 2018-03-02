package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class XYZZY_UVa10557 {
	static ArrayList<Integer> adjList[];
	static int n;
	static final int INF = (int) 1e9;
	static int[] e;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		while (true) {
			n = sc.nextInt();
			if (n == -1)
				break;
			e = new int[n];
			adjList = new ArrayList[n];
			for (int i = 0; i < n; i++)
				adjList[i] = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				e[i] = sc.nextInt();
				int doors = sc.nextInt();
				while (doors-- > 0)
					adjList[i].add(sc.nextInt() - 1);
			}

			Queue<Integer> q = new LinkedList<Integer>();
			boolean vis[][] = new boolean[n][n * 100 + 1];

			vis[0][100] = true;
			q.add(100 * n + 0); // store them in the form of p = energy * n + node
			// this works because n*energy will always be > n, so p/n = energy and p % n =
			// node
			boolean reached = false;
			while (!q.isEmpty()) {
				int p = q.remove();
				int u = p % n, energy = p / n;
				if (u == n - 1) {
					reached = true;
					break;
				}

				for (int v : adjList[u]) {
					int en = energy + e[v];
					if (en > 0 && en < n * 100 + 1 && !vis[v][en]) {
						vis[v][en] = true;
						q.add(en * n + v);
					}

				}

			}
			out.println(reached ? "winnable" : "hopeless");

		}
		out.flush();
		out.close();
	}

	static class Pair {
		int node, energy;

		public Pair(int node, int energy) {
			this.node = node;
			this.energy = energy;
		}

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

		String nextLine() throws IOException {
			return br.readLine();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		boolean ready() throws IOException {
			return br.ready();
		}
	}
}
