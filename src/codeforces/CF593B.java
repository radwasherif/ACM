package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF593B {
	static double EPS = 1e-9;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x1 = sc.nextInt();
		int x2 = sc.nextInt();

		Line lines1[] = new Line[n];
		Line lines2[] = new Line[n]; 
		for (int i = 0; i < n; i++) {
			double a = -sc.nextInt(); 
			double c = -sc.nextInt(); 
			lines1[i] = new Line(a, 1.0, c);
			lines1[i].sortY = -lines1[i].a * (x1 + EPS) - lines1[i].c;
			lines1[i].idx = i;
			
			lines2[i] = new Line(a, 1.0, c);
			lines2[i].sortY = -lines2[i].a * (x2 - EPS) - lines2[i].c;
			lines2[i].idx = i;
		}
		Arrays.sort(lines1);
		Arrays.sort(lines2);
		boolean flag = false; 
		for(int i = 0; i < n; i++) {
			 if(lines1[i].idx != lines2[i].idx ) {
				 flag = true;
				 break; 
			 }
		}
		System.out.println(flag? "YES" : "NO");

		
	}

	static class Line implements Comparable<Line> {
		double a, b, c;
		double sortY;
		int idx;

		Line(double a, double b, double c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		Line(Point p, Point q) {
			if (Math.abs(p.x - q.x) < EPS) {
				a = 1;
				b = 0.0;
				c = -p.x;
			} else {
				a = (p.y - q.y) / (q.x - p.x);
				b = 1.0;
				c = -(a * p.x + p.y);
			}
		}

		@Override
		public int compareTo(Line o) {
				return (o.sortY > sortY) ? 1 : -1;
		}
		

		boolean parallel(Line l) {
			return abs(a - l.a) < EPS && abs(b - l.b) < EPS;
		}

		boolean same(Line l) {
			return parallel(l) && abs(c - l.c) < EPS;
		}

		Point intersect(Line l) {
			if (parallel(l))
				return null;
			double x = (b * l.c - l.b * c) / (a * l.b - l.a * b);
			double y;
			if (abs(b) < EPS) // if (b == 0), first line is vertical, substitute in second line equation
				y = -l.c - l.a * x;
			else // only one of the two lines can be vertical
				y = -c - a * x;

			return new Point(x, y);
		}

		static double abs(double x) {
			return Math.abs(x);
		}

	}

	static class Point {
		double x, y;

		Point(double x, double y) {
			this.x = x;
			this.y = y;
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
