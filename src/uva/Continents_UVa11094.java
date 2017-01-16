package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Continents_UVa11094 {
	static char[][] grid;
	static boolean[][] vis;
	static int M, N;
	static int count;
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static boolean flood;
	static char land;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = 30;
		// while (T-- > 0) {
		while (sc.ready()) {
			M = sc.nextInt();
			N = sc.nextInt();
			grid = new char[M][N];
			vis = new boolean[M][N];
			for (int i = 0; i < M; i++) {
				String s = sc.next();
				for (int j = 0; j < N; j++) {
					char c = s.charAt(j);
					grid[i][j] = c;
					// grid[i + M][j] = c;
				}
			}
			count = 0;
			int x = sc.nextInt();
			int y = sc.nextInt();
			land = grid[x][y];
			flood = true;
			dfs(x, y);
//			System.out.println(Arrays.deepToString(grid));
			flood = false;
			int max = 0;
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[i].length; j++) {
					vis = new boolean[M][N];
					if (valid(i, j)) {
						count = 0;
						dfs(i, j);
						max = Math.max(max, count);
					}
				}
			}
			sb.append(max + "\n");
			sc.nextLine(); 
		}
		System.out.print(sb);
	}

	static void dfs(int i, int j) {
		if(j == N)
			j = 0; 
		if(j < 0)
			j = N-1; 
		if (!valid(i, j))
			return;
		if (flood) {
			grid[i][j] = (char) (land + 1);

		}
		vis[i][j] = true;
		count++;

		for (int k = 0; k < dx.length; k++) {
			dfs((i + dx[k]), (j + dy[k]));
		}
	}

	static boolean valid(int i, int j) {
		return i >= 0 && i < M && j >= 0 && j < N && grid[i][j] == land
				&& !vis[i][j];
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
