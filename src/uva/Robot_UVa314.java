package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Robot_UVa314 {
	static int[][] grid;
	static int M, N;
	static int ei, ej;
	static int[][][] dist;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (true) {
			M = sc.nextInt();
			N = sc.nextInt();
			if (M == 0 && N == 0)
				break;
			grid = new int[M][N];
			dist = new int[M][N][4];
			for (int i = 0; i < dist.length; i++) {
				for (int j = 0; j < dist[i].length; j++) {
					Arrays.fill(dist[i][j], INF);
				}
			}
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					grid[i][j] = sc.nextInt();
				}
			}
			int bi = sc.nextInt();
			int bj = sc.nextInt();
			ei = sc.nextInt();
			ej = sc.nextInt();
			String or = sc.next();
			// System.out.println(or(or));
			// System.out.println(ei + " " + ej);
			// System.out.println(valid(6, 1));
			if (!valid(ei, ej))
				sb.append("-1\n");
			else
				sb.append(bfs(bi, bj, or(or)) + "\n");

		}
		System.out.print(sb);
	}

	static int or(String or) {
		switch (or) {
		case "south":
			return 0;
		case "north":
			return 2;
		case "east":
			return 1;
		default: // west
			return 3;
		}
	}

	static final int INF = 1000000000;
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	static int bfs(int i, int j, int or) {
		Queue<State> q = new LinkedList<State>();
		q.add(new State(i, j, or));
		dist[i][j][or] = 0;
		while (!q.isEmpty()) {
			State s = q.remove();
			for (int k = 1; k <= 3; k++) {
				int x = s.i + k * dx[s.dir];
				int y = s.j + k * dy[s.dir];
				if (valid(x, y) && dist[x][y][s.dir] == INF) {
					q.add(new State(x, y, s.dir));
					dist[x][y][s.dir] = dist[s.i][s.j][s.dir] + 1;
					System.out.println(x + " " + y + " " + dist[x][y][s.dir]);
					if (x == ei && y == ej)
						return dist[x][y][s.dir];
				}
			}
			int d = (s.dir + 1) % 4; // left
			if (dist[s.i][s.j][d] == INF) {
				q.add(new State(s.i, s.j, d));
				dist[s.i][s.j][d] = dist[s.i][s.j][s.dir] + 1;
				System.out.println(s.i + " " + s.j + " " + d);
			}

			d = (s.dir + 3) % 4; // right
			if (dist[s.i][s.j][d] == INF) {
				q.add(new State(s.i, s.j, d));
				dist[s.i][s.j][d] = dist[s.i][s.j][s.dir] + 1;
				System.out.println(s.i + " " + s.j + " " + d);
			}

		}
		return -1;
	}

	static class State {
		int i, j, dir;

		State(int i, int j, int dr) {
			this.i = i;
			this.j = j;
			dir = dr;
		}

	}

	static boolean valid(int i, int j) {
		boolean valid = i > 0 && i < M && j > 0 && j < N && grid[i][j] == 0;
		if (!valid)
			return false;
		if (i > 0) {
			valid &= (grid[i - 1][j] != 1);
		}
		if (j > 0) {
			valid &= (grid[i][j - 1] != 1);
		}
		if (i > 0 && j > 0)
			valid &= (grid[i - 1][j - 1] != 1);
		return valid;
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
