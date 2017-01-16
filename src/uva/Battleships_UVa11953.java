package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Battleships_UVa11953 {
	static char[][] grid;
	static boolean vis[][];
	static int N;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder(); 
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			grid = new char[N][N];
			vis = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				String s = sc.next();
				for (int j = 0; j < N; j++) {
					grid[i][j] = s.charAt(j);
				}
			}
			int ans = 0; 
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid.length; j++) {
					if(valid(i, j)) {
						if(dfs(i, j) > 0)
							ans++; 
					}
				}
			}
			sb.append("Case " + t + ": " + ans + "\n"); 
		}
		System.out.print(sb);
	}

	static int dfs(int i, int j) {
		if (!valid(i, j))
			return 0;
		vis[i][j] = true;
		if (grid[i][j] == 'x') {
			return 1 + dfs(i + 1, j) + dfs(i, j + 1);
		} 
		return dfs(i + 1, j) + dfs(i, j + 1);

	}

	static boolean valid(int i, int j) {
		return i >= 0 && i < N && j >= 0 && j < N && grid[i][j] != '.'
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
