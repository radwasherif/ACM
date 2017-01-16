package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 11951
 */

public class Area {
	static int N, M, K, area;
	static long cost;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			long a[][] = new long[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					a[i][j] = sc.nextInt();
					if (i > 0)
						a[i][j] += a[i - 1][j];
					if (j > 0)
						a[i][j] += a[i][j - 1];
					if (i > 0 && j > 0)
						a[i][j] -= a[i - 1][j - 1];
				}
			}
			max2DRange(a);
			System.out.println("Case #" + t + ": " + area + " " + cost);
		}
	}

	static long INF = 100 * 100 * 1000000;

	static void max2DRange(long a[][]) {
		cost = 0;
		area = 0;
		int curA = 0;
		long curP = 0;
		for (int i = 0; i < N; i++) { // i, j start coordinates
			for (int j = 0; j < M; j++) {
				if ((N - i + 1) * (M - j + 1) < area)
					break;
				for (int k = i; k < N; k++) { // k, l end coordinates
					for (int l = j; l < M; l++) {
						curA = (k - i + 1) * (l - j + 1);

						curP = a[k][l];
						if (i > 0)
							curP -= a[i - 1][l];
						if (j > 0)
							curP -= a[k][j - 1];
						if (i > 0 && j > 0)
							curP += a[i - 1][j - 1];
						
						if(curA > area) {
							if(curP <= K) {
								area = curA; 
								cost = curP; 
							}
						} else if (curA == area) {
							if (curP < cost) {
								cost = curP; 
							}
						}

					}
				}
			}
		}

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
