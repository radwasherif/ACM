package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF617C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		Point p1 = new Point(sc.nextInt(), sc.nextInt());
		Point p2 = new Point(sc.nextInt(), sc.nextInt());

		double d1[] = new double[n + 1];
		double d2[] = new double[n + 1];

		for (int i = 0; i < n; i++) {
			Point p = new Point(sc.nextInt(), sc.nextInt());
			d1[i + 1] = p.dist(p1);
			d2[i + 1] = p.dist(p2);
		}

		double ans = Double.MAX_VALUE;

		for (int i = 0; i < n + 1; i++) {
			double r2 = 0;
			double r1 = d1[i];
			for (int j = 0; j < n + 1; j++) {
				if (j == i)
					continue;

				if (d1[j] > r1 && d2[j] > r2) {
					r2 = d2[j];
				}

			}
			ans = Math.min(r1 * r1 + r2 * r2, ans);
		}
		System.out.println((long) (Math.round(ans)));
	}

	static class Point implements Comparable<Point> {
		double x, y;
		double dist;
		int idx;

		Point(double x, double y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if (dist != o.dist)
				return (dist < o.dist) ? 1 : -1;
			return o.idx - idx;
		}

		double dist(Point p) {
			return Math.sqrt(sq(x - p.x) + sq(y - p.y));
		}

		double sq(double x) {
			return x * x;
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
