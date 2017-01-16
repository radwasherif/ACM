package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MallMania_UVa11101 {
	static int[] x1, y1, x2, y2;
	static int[][] grid, dist;
	static int maxX1, maxY1, minX1, minY1;
	static int maxX2, maxY2, minX2, minY2;
	static boolean vis[][];

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (true) {
			int p = sc.nextInt();
			if (p == 0)
				break;
			grid = new int[2001][2001];
			minX1 = 1000000000;
			minY1 = 1000000000;
			maxX1 = 0;
			maxY1 = 0;
			x1 = new int[p];
			y1 = new int[p];
			for (int i = 0; i < p; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				x1[i] = x;
				y1[i] = y;
				maxX1 = Math.max(maxX1, x);
				minX1 = Math.min(minX1, x);
				maxY1 = Math.max(maxY1, y);
				minY1 = Math.min(minY1, y);
			}
			p = sc.nextInt();
			minX2 = 1000000000;
			minY2 = 1000000000;
			maxX2 = 0;
			maxY2 = 0;

			while (p-- > 0) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				grid[x][y] = 2;
				maxX2 = Math.max(maxX2, x);
				minX2 = Math.min(minX2, x);
				maxY2 = Math.max(maxY2, y);
				minY2 = Math.min(minY2, y);
			}

			MIN = 1000000000;
			vis = new boolean[maxx() + 1][maxy() + 1];
			dist = new int[maxx() + 1][maxy() + 1];
			bfs();
			sb.append(MIN + "\n");
		}
		System.out.print(sb);
	}

	static int MIN;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static void bfs() {
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		for (int k = 0; k < x1.length; k++) {
			if (x1[k] == minX1 || x1[k] == maxX1 || y1[k] == minY1 || y1[k] == maxY1) {
				qx.add(x1[k]);
				qy.add(y1[k]);
				vis[x1[k]][y1[k]] = true;

			}
		}
		while (!qx.isEmpty()) {
			int x = qx.remove();
			int y = qy.remove();
			for (int k = 0; k < dx.length; k++) {
				int ii = x + dx[k];
				int jj = y + dy[k];
				if (!valid(ii, jj)) {
					// System.out.println(ii + " " + jj);
					continue;
				}

				// System.out.println(ii + " " + jj);
				if (!vis[ii][jj]) {
					dist[ii][jj] = dist[x][y] + 1;
					if (grid[ii][jj] == 2) {
						MIN = Math.min(MIN, dist[ii][jj]);
						return;
					}
					qx.add(ii);
					qy.add(jj);
					vis[ii][jj] = true;
				}
			}

		}
	}

	static int maxx() {
		return Math.max(maxX1, maxX2);
	}

	static int maxy() {
		return Math.max(maxY1, maxY2);
	}

	static int minx() {
		return Math.min(minX1, minX2);
	}

	static int miny() {
		return Math.min(minY1, minY2);
	}

	static boolean valid(int i, int j) {
		return i >= 0 && i <= maxx() && j >= 0 && j <= maxy();
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
