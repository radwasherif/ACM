package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CairoMarket {

	public static int[][] grid;
	static int[][][] memo;

	public static int solve(int r, int c, int max) {
		// System.out.println(r+" " + c);
		// System.out.println(grid.length);
		if (r == grid.length && c == grid.length)
			return 0;

		if (memo[r][c][max] != -1)
			return memo[r][c][max];

		int rightTake = 0;
		int rightLeave = 0;
		if (r + 1 < grid.length && grid[r + 1][c] > max) {
			// System.out.println("hii");
			if (grid[r + 1][c] != -1)
				rightTake = 1 + solve(r + 1, c, Math.max(max, grid[r + 1][c]));
		}
		if (r + 1 < grid.length)
			rightLeave = solve(r + 1, c, max);

		int leftTake = 0;
		int leftLeave = 0;

		if (c + 1 < grid.length && grid[r][c + 1] > grid[r][c]) {
			// System.out.println("hi");
			if (grid[r][c + 1] != -1)
				leftTake = 1 + solve(r, c + 1, Math.max(max, grid[r][c + 1]));
			// else
			// left = solve(r, c+1);
		}
		if (c + 1 < grid.length)
			leftLeave = solve(r, c + 1, max);
		return memo[r][c][max] = Math.max(Math.max(leftTake, rightTake),
				Math.max(leftLeave, rightLeave));

	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		grid = new int[n][n];
		for (int i = 0; i < grid.length; i++) {
			Arrays.fill(grid[i], -1);
		}
		int time = 1;
		for (int i = 0; i < n; i++) {
			int c = sc.nextInt() - 1;
			int r = sc.nextInt() - 1;
			grid[r][c] = time;
			time++;
		}
		memo = new int[n + 1][n + 1][time + 10];
		for (int i = 0; i < memo.length; i++) {
			for (int j = 0; j < memo[i].length; j++) {
				Arrays.fill(memo[i][j], -1);
			}
		}
		// for (int i = 0; i < grid.length; i++) {
		// System.out.println(Arrays.toString(grid[i]));
		// }
		int one = solve(0, 0, 0);
		int two = 0;
		if (grid[0][0] != -1)
			two = 1 + solve(0, 0, grid[0][0]);

		System.out.println(Math.max(one, two));

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

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}
