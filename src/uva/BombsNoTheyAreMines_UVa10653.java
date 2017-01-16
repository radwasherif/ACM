package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BombsNoTheyAreMines_UVa10653 {
	static int[][] grid;
	static int R, C;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (true) {
			R = sc.nextInt();
			C = sc.nextInt();
			if (R == 0 && C == 0)
				break;
			grid = new int[R][C];
			int rows = sc.nextInt();
			while (rows-- > 0) {
				int i = sc.nextInt();
				int col = sc.nextInt();
				while (col-- > 0)
					grid[i][sc.nextInt()] = -1;
			}
			int si = sc.nextInt(), sj = sc.nextInt(); // source
			int ti = sc.nextInt(), tj = sc.nextInt(); // dest
			bfs(si, sj, ti, tj);
			sb.append(grid[ti][tj] + "\n");

		}
		System.out.print(sb);
	}

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static void bfs(int si, int sj, int ti, int tj) {
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		qx.add(si);
		qy.add(sj);
		while (!qx.isEmpty()) {
			int i = qx.remove();
			int j = qy.remove();
			if (i == ti && j == tj)
				break;
			for (int k = 0; k < dx.length; k++) {
				int newi = i + dx[k];
				int newj = j + dy[k];
				if (valid(newi, newj)) {
					grid[newi][newj] = grid[i][j] + 1;
					qx.add(newi);
					qy.add(newj);
				}
			}
		}
	}

	static boolean valid(int i, int j) {
		return i >= 0 && i < R && j >= 0 && j < C && grid[i][j] == 0;
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
