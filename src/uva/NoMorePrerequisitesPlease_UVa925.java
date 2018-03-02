package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class NoMorePrerequisitesPlease_UVa925 {
	static final int INF = (int) 1e9;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			TreeMap<String, Integer> tm = new TreeMap<>();
			String[] deMap = new String[N];
			for (int i = 0; i < N; i++) {
				deMap[i] = sc.next();
			}
			Arrays.sort(deMap);
			for (int i = 0; i < N; i++)
				tm.put(deMap[i], i);

			int[][] adjMat = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(adjMat[i], -INF);
				adjMat[i][i] = 0;
			}
			boolean[] hasPre = new boolean[N];
			int K = sc.nextInt();

			while (K-- > 0) {
				String course = sc.next();
				int i = tm.get(course);
				hasPre[i] = true;
				int count = sc.nextInt();
				while (count-- > 0) {
					int j = tm.get(sc.next());
					adjMat[j][i] = 1;
				}
			}
			floyd(adjMat);
			for (int i = 0; i < N; i++) {
				ArrayList<Integer> sol = new ArrayList<>();

				for (int j = 0; j < N; j++) {
					if (adjMat[j][i] == 1) {
						sol.add(j);
					}
				}
				if (sol.size() == 0)
					continue;
				out.printf("%s %d", deMap[i], sol.size());
				for (int c : sol)
					out.printf(" %s", deMap[c]);
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
					dist[i][j] = Math.max(dist[i][j], dist[i][k] + dist[k][j]);
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
