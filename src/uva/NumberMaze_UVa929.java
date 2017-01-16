package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class NumberMaze_UVa929 {
	static int n, m;
	// static ArrayList<Pair>[] adjList;
	static int[][] maze;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			n = sc.nextInt();
			m = sc.nextInt();
			maze = new int[n][m];
			for (int i = 0; i < maze.length; i++) {
				for (int j = 0; j < maze[i].length; j++) {
					maze[i][j] = sc.nextInt();
				}
			}
			dijkstra(0, 0);
			// System.out.println(Arrays.deepToString(dist));
			sb.append(dist[n - 1][m - 1] + "\n");

		}
		System.out.print(sb);
	}

	static int[][] dist;
	static final int INF = 1000000000;
	static int dx[] = { 0, 1, -1, 0 };
	static int dy[] = { 1, 0, 0, -1 };

	static void dijkstra(int s_i, int s_j) {
		dist = new int[n][m];

		for (int i = 0; i < dist.length; i++) {
			Arrays.fill(dist[i], INF);
		}
		dist[0][0] = maze[0][0];
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		pq.add(new Pair(s_i, s_j, maze[0][0]));
		while (!pq.isEmpty()) {
			Pair cur = pq.remove();
			// System.out.println(cur.i + " " + cur.j);
			if (cur.wt > dist[cur.i][cur.j])
				continue;
			for (int i = 0; i < dx.length; i++) {
				int ii = cur.i + dx[i];
				int jj = cur.j + dy[i];
				if (!valid(ii, jj))
					continue;
				if (cur.wt + maze[ii][jj] < dist[ii][jj])
					pq.add(new Pair(ii, jj, dist[ii][jj] = cur.wt + maze[ii][jj]));
			}
		}
		// return -1;
	}

	static boolean valid(int i, int j) {
		return i >= 0 && i < n && j >= 0 && j < m;
	}

	static class Pair implements Comparable<Pair> {
		int i, j, wt;

		public Pair(int ii, int jj, int w) {
			i = ii;
			j = jj;
			wt = w;
		}

		@Override
		public int compareTo(Pair arg0) {
			if (wt != arg0.wt)
				return wt - arg0.wt;
			return i - arg0.i; // TODO
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

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

	}

}
