package uva;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class TheScroogeCoProblem_UVa11047 {
	static int d[][], p[][];
	static final int INF = (int) 1e9;
	static int N;
	static HashMap<String, Integer> hm;
	static String[] deMap;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int C = sc.nextInt();
		while (C-- > 0) {
			N = sc.nextInt();
			d = new int[N][N];
			p = new int[N][N];
			hm = new HashMap<>();
			deMap = new String[N];
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			int val = 0;
			while (st.hasMoreTokens()) {
				String s = st.nextToken();
				if (!hm.containsKey(s)) {
					hm.put(s, val);
					deMap[val] = s;
					val++;
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					d[i][j] = sc.nextInt();
					if (d[i][j] == -1)
						d[i][j] = INF;
					p[i][j] = i;
				}
				p[i][i] = -1;
				d[i][i] = 0;
			}
			floyd();
			int R = sc.nextInt();
			while (R-- > 0) {
				String name = sc.next();
				String org = sc.next();
				String dest = sc.next();

				int i = hm.get(org);
				int j = hm.get(dest);
				if (d[i][j] == INF) {
					out.printf("Sorry Mr %s you can not go from %s to %s\n", name, org, dest);
				} else {
					out.printf("Mr %s to go from %s to %s, you will receive %d euros\n", name, org, dest, d[i][j]);
					sol = new Stack<>(); 
					getPath(i, j);
					out.print("Path:" + org);
					
					for (int p : sol)
						out.printf(" %s", deMap[p]);
					out.println();
				}
			}
		}
		out.flush();
		out.close();
	}

	static Stack<Integer> sol;

	static void getPath(int i, int j) {
		if (p[i][j] != -1) {
			sol.push(j);
			getPath(i, p[i][j]);
		}
	}

	static void floyd() {

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int oldDist = d[i][j];
					d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
					if (d[i][j] != oldDist) {
						p[i][j] = p[k][j];
					}
				}
			}
		}

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
