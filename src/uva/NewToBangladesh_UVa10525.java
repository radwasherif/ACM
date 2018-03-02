package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NewToBangladesh_UVa10525 {
	static final int INF = (int) 1e9;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] dist = new int[n][n];
			int[][] time = new int[n][n];

			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++) {
					dist[i][j] = INF;
					time[i][j] = INF;
					time[i][i] = 0; 
					dist[i][i] = 0; 
				}

			while (m-- > 0) {
				int i = sc.nextInt() - 1;
				int j = sc.nextInt() - 1;
				int t = sc.nextInt(); 
				int d = sc.nextInt(); 
				if(t == time[i][j])
					dist[j][i] = dist[i][j] = Math.min(dist[i][j], d); 
				else if(t < time[i][j]) {
					time[j][i] = time[i][j] = t; 
					dist[j][i] = dist[i][j] = d; 
				}
				
			}

			for (int k = 0; k < n; k++)
				for (int i = 0; i < n; i++)
					for (int j = 0; j < n; j++) {
						int cur = time[i][j];
						int nw = time[i][k] + time[k][j];
						if (cur == nw) {
							dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
						} else if (nw < cur) {
							time[i][j] = nw;
							dist[i][j] = dist[i][k] + dist[k][j];
						}
					}

			int q = sc.nextInt();
			while (q-- > 0) {
				int i = sc.nextInt() - 1;
				int j = sc.nextInt() - 1;
				if (dist[i][j] == INF)
					out.println("No Path.");
				else
					out.printf("Distance and time to reach destination is %d & %d.\n", dist[i][j], time[i][j]);

			}
			if (T > 0)
				out.println();
		}
		out.flush();
		out.close(); 
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
