package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KnightMoves_UVa439 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int[][] dist = new int[64][64];
		for (int i = 0; i < dist.length; i++) {
			Arrays.fill(dist[i], 1000000000);
			dist[i][i] = 0;
		}
		int dx[] = { 2, 2, -2, -2, 1, 1, -1, -1 };
		int dy[] = { 1, -1, 1, -1, 2, -2, 2, -2 };

		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				for (int k = 0; k < 8; k++) {
					int newr = r + dx[k];
					int newc = c + dy[k];
					if (valid(newr, newc)) {
						int i = r * 8 + c;
						int j = newr * 8 + newc;
						dist[i][j] = 1;
					}
				}
			}
		}

		floyd(dist);
		int c = 4;
		// while (c-- > 0) {
		while (sc.ready()) {
			String src = sc.next();
			String dest = sc.next();

			int i = getPos((src.charAt(1) - '1'), src.charAt(0) - 'a');
			int j = getPos((dest.charAt(1) - '1'), dest.charAt(0) - 'a');

			out.printf("To get from %s to %s takes %d knight moves.\n", src, dest, dist[i][j]);
		}
		out.flush();
		out.close();
	}

	static void floyd(int[][] dist) {
		for (int k = 0; k < dist.length; k++)
			for (int i = 0; i < dist.length; i++)
				for (int j = 0; j < dist.length; j++)
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
	}

	static int getPos(int r, int c) {
		return r * 8 + c;
	}

	static boolean valid(int r, int c) {
		return r >= 0 && r < 8 && c >= 0 && c < 8;
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
