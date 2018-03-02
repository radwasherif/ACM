package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class TheIslands_UVa1096 {
	static int n, b1, b2;
	static int[] x, y;
	static PrintWriter out;
	static double memo[][][];
	static double dist[][];
	static Stack<Integer> sol;
	static ArrayList<Integer> arr;
	static final double eps = 1e-12;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		out = new PrintWriter(System.out);
		int t = 1;
		while (true) {
			n = sc.nextInt();
			b1 = sc.nextInt();
			b2 = sc.nextInt();
			if (t == 93)
				System.out.println(n + " " + b1 + " " + b2);
			if (n == 0 && b1 == 0 && b2 == 0)
				break;
			x = new int[n];
			y = new int[n];

			for (int i = 0; i < n; i++) {
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
				if (t == 93)
					System.out.println(x[i] + " " + y[i]);
			}
			dist = new double[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dist[i][j] = dist(i, j);
				}
			}
			memo = new double[n][n][4];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					Arrays.fill(memo[i][j], -10);
			}
			sol = new Stack<Integer>();
			arr = new ArrayList<Integer>();
			arr.add(0);

			double ans = dp(0, 0, 0);

			out.printf("Case %d: %.2f\n", t++, Math.round(ans * 100.0) / 100.0);
			print(0, 0, 0);
			while (!sol.isEmpty())
				arr.add(sol.pop());
			arr.add(0);

			if (arr.get(1) == 1) {
				out.print(arr.get(0));
				for (int i = 1; i < arr.size(); i++)
					out.print(" " + arr.get(i));

			} else {
				out.print("0");
				for (int i = arr.size() - 2; i >= 0; i--) {
					out.print(" " + arr.get(i));
				}

			}
			out.println();
		}
		out.flush();
		out.close();
	}

	static double dp(int d1, int d2, int special) {
		int v = 1 + Math.max(d1, d2);
		if (v == n - 1)
			return dist[d1][v] + dist[d2][v];
		if (memo[d1][d2][special] > -5)
			return memo[d1][d2][special];
		double v1 = 1e16;
		double v2 = 1e16;

		if (v == b1 || v == b2) {
			if (special != 1) {
				v1 = dist[v][d1] + dp(v, d2, 1);
			}

			if (special != 2)
				v2 = dist[v][d2] + dp(d1, v, 2);

		} else {
			v1 = dist[v][d1] + dp(v, d2, special);
			v2 = dist[v][d2] + dp(d1, v, special);
		}

		return memo[d1][d2][special] = Math.min(v1, v2);

	}

	static double dd(int d1, int d2, int special) {
		int v = 1 + Math.max(d1, d2);
		if (v == n - 1)
			return dist[d1][v] + dist[d2][v];
		if (memo[d1][d2][special] > -5)
			return memo[d1][d2][special];
		double v1 = 1000000000;
		double v2 = 1000000000;

		if (v == b1 || v == b2) {
			if ((special & 1) == 0)
				v1 = dist[v][d1] + dd(v, d2, special | 1);
			if ((special & 2) == 0)
				v2 = dist[v][d2] + dd(d1, v, special | 2);
		} else {
			v1 = dist[v][d1] + dd(v, d2, special);
			v2 = dist[v][d2] + dd(d1, v, special);
		}

		return memo[d1][d2][special] = Math.min(v1, v2);

	}

	static void pp(int d1, int d2, int special) {
		int v = 1 + Math.max(d1, d2);
		if (v == n - 1) {
			arr.add(v);
			return;
		}
		double ans = dd(d1, d2, special);

		if (v == b1 || v == b2) {
			if ((special & 1) == 0 && dist[d1][v] + dd(v, d2, special | 1) - ans < eps) {
				arr.add(v);
				pp(v, d2, special | 1);

			} else {
				sol.push(v);
				pp(d1, v, special | 2);
			}
		} else if (dist[d1][v] + dd(v, d2, special) - ans < eps) {
			arr.add(v);
			pp(v, d2, special);
		} else {
			sol.push(v);
			pp(d1, v, special);
		}
	}

	static void print(int d1, int d2, int special) {
		int v = 1 + Math.max(d1, d2);
		if (v == n - 1) {
			arr.add(v);
			return;
		}

		double ans = dp(d1, d2, special);
		if (v == b1 || v == b2) {
			if (special != 1 && dist[v][d1] + dp(v, d2, 1) - ans < eps) {
				arr.add(v);
//				System.out.println(v);
				print(v, d2, 1);
			} else {
				sol.push(v);
				print(d1, v, 2);
			}
		} else {
			if (dist[v][d1] + dp(v, d2, 1) - ans < eps) {
				arr.add(v);
				print(v, d2, special);
			} else {
				sol.push(v);
				print(d1, v, special);
			}
		}

	}

	static double dist(int i, int j) {
		int dx = (int) Math.abs(x[i] - x[j]);
		int dy = (int) Math.abs(y[i] - y[j]);

		return Math.sqrt(dx * dx + dy * dy);
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