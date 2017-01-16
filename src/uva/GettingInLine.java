package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 216 
 * Traveling Salesman Problem 
 */

public class GettingInLine {
	static int n;
	static int[] x, y;
	static double dist[][];
	static double tsp[][];
	static ArrayList<Integer> sol;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for (int t = 1; true; t++) {
			n = sc.nextInt();
			if (n == 0)
				break;
			x = new int[n];
			y = new int[n];
			dist = new double[n][n];
			for (int i = 0; i < x.length; i++) {
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
			}
			for (int i = 0; i < n; i++) {
				for (int j = i; j < n; j++) {
					int dx = Math.abs(x[i] - x[j]);
					int dy = Math.abs(y[i] - y[j]);
					dist[i][j] = Math.sqrt(dx * dx + dy * dy) + 16;
					dist[j][i] = dist[i][j];
				}
			}
			tsp = new double[n][(1 << n)];
			for (int i = 0; i < tsp.length; i++) {
				Arrays.fill(tsp[i], -1);
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					tsp[i][(1 << j)] = tsp(i, (1 << j));
				}
			}
			//System.out.println(Arrays.deepToString(tsp));
			double minVal = 1000000;
			int start = 0;
			for (int i = 0; i < n; i++) {
				if (tsp[i][1 << i] < minVal) {
					minVal = tsp[i][1 << i];
					start = i;
				}
			}
			sol = new ArrayList<Integer>();
			sol.add(start);
			print(start, 1<<start);
			sb.append("**********************************************************\n");
			sb.append("Network #" + t + "\n");
			for (int j = 0; j < sol.size() - 1; j++) {
				sb.append("Cable requirement to connect (" + x[sol.get(j)]
						+ "," + y[sol.get(j)] + ")" + " to " + "("
						+ x[sol.get(j + 1)] + "," + y[sol.get(j + 1)] + ") is "
						+ format(dist[sol.get(j)][sol.get(j + 1)]) + " feet.\n");
				

			}
			sb.append("Number of feet of cable required is " + format(tsp[start][1<<start]) + ".\n");
		}
		System.out.print(sb);
	}
	static String format(double d) {
		return new DecimalFormat("0.00").format(Math.round(d*100)/100.0); 
	}

	/*
	 * O(n^2 * 2^n)
	 */
	static double tsp(int pos, int mask) {
		if (mask == (1 << n) - 1) // all the bits = 1, all cities visited
			return 0; // return the distance from where I am to the starting
						// node
		double min = 1000000000; // not sure if large enough
		if (tsp[pos][mask] != -1)
			return tsp[pos][mask];
		for (int i = 0; i < n; i++) {
			if (i != pos && ((mask & (1 << i)) == 0)) // check if ith bit is
														// zero
				min = Math.min(dist[pos][i] + tsp(i, (mask | (1 << i))), min); // set
																				// ith
																				// bit
																				// to
																				// 1
		}
		return tsp[pos][mask] = min;
	}

	static void print(int pos, int mask) {
		// System.out.println(pos + " " + Integer.toBinaryString(mask));
		if (mask == (1 << n) - 1)
			return;
		double optimal = tsp[pos][mask];
		for (int i = 0; i < n; i++) {
			if (i != pos && ((mask & (1 << i)) == 0)) {
				if (optimal == dist[pos][i] + tsp(i, (mask | (1 << i)))) {
					sol.add(i);
					print(i, (mask | (1 << i)));
					break;
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
