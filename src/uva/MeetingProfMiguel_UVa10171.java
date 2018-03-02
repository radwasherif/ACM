package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MeetingProfMiguel_UVa10171 {
	static final int INF = (int) 1e9;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		while (true) {
			int N = sc.nextInt();
			if (N == 0)
				break;

			int[][] dY = new int[26][26];
			int[][] dM = new int[26][26];
			for (int i = 0; i < 26; i++) {
				Arrays.fill(dY[i], INF);
				Arrays.fill(dM[i], INF);
				dY[i][i] = 0;
				dM[i][i] = 0;
			}

			for (int i = 0; i < N; i++) {
				String age = sc.next();
				String dir = sc.next();
				int from = sc.next().charAt(0) - 'A';
				int to = sc.next().charAt(0) - 'A';
				int dist = sc.nextInt();
				if (age.equals("Y")) {
					if (dir.equals("U")) {
						dY[from][to] = Math.min(dY[from][to], dist);
					} else {
						dY[from][to] = Math.min(dY[from][to], dist);
						dY[to][from] = Math.min(dY[to][from], dist);
					}
				} else {
					if (dir.equals("U")) {
						dM[from][to] = Math.min(dM[from][to], dist);
					} else {
						dM[from][to] = Math.min(dM[from][to], dist);
						dM[to][from] = Math.min(dM[to][from], dist);
					}
				}
			}

			floyd(dY);
			floyd(dM);
			int student = sc.next().charAt(0) - 'A';
			int prof = sc.next().charAt(0) - 'A';

			int meetingPlace = -1;
			int dist = INF;
			for (int i = 0; i < 26; i++) {
				if (dY[student][i] + dM[prof][i] < dist) {
					dist = dY[student][i] + dM[prof][i];
				}
			}

			if (dist == INF) {
				out.println("You will never meet.");
			} else {
				out.print(dist);
				for (int i = 0; i < 26; i++) {
					if (dY[student][i] + dM[prof][i] == dist) {
						out.print(" ");
						out.print((char) (i + 'A'));
					}
				}
				out.println();
			}

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
