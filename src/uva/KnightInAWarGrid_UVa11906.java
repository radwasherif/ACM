package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class KnightInAWarGrid_UVa11906 {
	static int m, n, R, C, W;
	static int[][] grid; 
	static boolean [] [] vis; 
	static int E, O;
	static int x;
	static int[] dx, dy;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			R = sc.nextInt();
			C = sc.nextInt();
			m = sc.nextInt();
			n = sc.nextInt();
			W = sc.nextInt();
			// System.out.println(R + " " + C);
			grid = new int[R][C];
			vis = new boolean[R][C];
			E = 0;
			O = 0;
			while (W-- > 0) {
				int i = sc.nextInt();
				int j = sc.nextInt();
				grid[i][j] = -1;
			}
			grid[0][0] = 1;
			if (n == 0 || m == 0) {
				x = (m == 0) ? n : m;
				int[] dx0 = { x, -x, 0, 0 };
				dx = dx0;
				int[] dy0 = { 0, 0, x, -x };
				dy = dy0;

			} else if (n == m) {
				x = n;
				int dxe[] = { x, -x, x, -x };
				int dye[] = { x, x, -x, -x };
				dx = dxe;
				dy = dye;

			} else {
				int dxf[] = { m, n, m, -n, -m, n, -m, -n };
				int dyf[] = { n, m, -n, m, n, -m, -n, -m };
				dx = dxf;
				dy = dyf;

			}
			dfs(0, 0);
			sb.append("Case " + t + ": " + E + " " + O + "\n");
		}
		System.out.print(sb);
	}

	static void dfs(int i, int j) {
		vis[i][j] = true; 
		int count = 0;
		for (int k = 0; k < dx.length; k++) {
			if (valid(i + dx[k], j + dy[k])) {
				count++;

			}
		}
		
			if (count % 2 == 0)
				E++;
			else
				O++;
		
		for (int k = 0; k < dx.length; k++) {
			if (valid(i + dx[k], j + dy[k]) && !vis[i + dx[k]][j + dy[k]]) {
				dfs(i + dx[k], j + dy[k]);

			}
		}
	}

	static boolean valid(int i, int j) {
		if (i >= 0 && i < R && j >= 0 && j < C && grid[i][j] != -1) {
			return true;
		}
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
