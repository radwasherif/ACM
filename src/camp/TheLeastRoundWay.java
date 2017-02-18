package camp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TheLeastRoundWay {
	static int grid2[][];
	static int grid5[][];
	static int memo2[][];
	static int memo5[][];
	static int memo[][], grid[][];
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		grid2 = new int[n][n];
		grid5 = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int x = sc.nextInt();
				grid2[i][j] = count(x, 2);
				grid5[i][j] = count(x, 5);
			}
		}
		memo2 = new int[n][n];
		memo5 = new int[n][n];
		for (int i = 0; i < memo2.length; i++) {
			Arrays.fill(memo2[i], -1);
			Arrays.fill(memo5[i], -1);
		}
		memo = memo2;
		grid = grid2;
		int d2 = dp(0, 0);

		memo = memo5;
		grid = grid5;
		int d5 = dp(0, 0);

		if (d2 < d5) {
			memo = memo2;
			grid = grid2;
			System.out.println(d2);
			System.out.println("two");
		} else {
			memo = memo5;
			grid = grid5;
			System.out.println(d5);
		}
		
		print(0, 0);
	}

	static void print(int i, int j) {
		// System.out.println(i + " " + j);
		if (i == n - 1 && j == n - 1)
			return;
		if (j < n - 1 && i < n) {
			if (dp(i, j) == grid[i][j] + dp(i, j + 1)) {
				System.out.print("R");
				print(i, j + 1);
			}
		} else {
			if (dp(i, j) == grid[i][j] + dp(i + 1, j)) {
				System.out.print("D");
				print(i + 1, j);
			}
		}
	}

	static int inf = (int) 1e9;

	static int dp(int i, int j) {
		if (i == n || j == n)
			return inf;
		if(i == n-1 && j == n-1)
			return 0; 
		// System.out.println(i + " " + j);
//		if (memo[i][j] != -1)
//			return memo[i][j];

		return memo[i][j] = Math.min(dp(i, j + 1), dp(i + 1, j)) + grid[i][j];
	}

	static int count(int n, int x) {
		int ans = 0;
		while (n > 1) {
			if (n % x == 0) {
				ans++;
			}
			n /= x;
		}
		return ans;
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

		String nextLine() throws IOException {
			return br.readLine();
		}

	}
}
