package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Logo2_UVa11519 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = sc.nextInt();
		while (T-- > 0) {
			Point start = new Point(0, 0);
			Point middle = start;
			char move = 'f';
			Vector dir = new Vector(0, 1);
			int n = sc.nextInt();
			while (n-- > 0) {
				char c = sc.next().charAt(0);
				String s = sc.next();
				if (s.equals("?")) {

					move = c;
					middle = start;
					continue; 

				}
				double d = Integer.parseInt(s);
//				System.out.println(d);
				if (c == 'f') {
					start = start.translate(dir.normalize().scale(d));
					Vector v = dir.scale(d);
					// System.out.println(v.x + " " + v.y);
				} else if (c == 'b') {
					start = start.translate(dir.normalize().reverse().scale(d));
				} else if (c == 'l') {
					dir = dir.rotate(d);
				} else {
					dir = dir.rotate(-d);
				}
			}
			int ans;
			if (move == 'b' || move == 'f') {
				ans = (int) Math.round(start.dist(new Point(0, 0)));
			} else {
				ans = (int) Math.round(radToDeg(Point.angle(new Point(0, 0), middle, start)));
				if(move == 'r')
					ans = 360 - ans; 
				if(Point.ccw(new Point(0, 0), start, middle))
					ans = 360 - ans; 
			}
			
			out.println(ans);

		}
		out.close();
	}

	static class Point {

		static final double EPS = 1e-9;
		double x, y;

		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}

		public double dist(Point p) {
			return Math.sqrt(sq(x - p.x) + sq(y - p.y));
		}

		static double sq(double x) {
			return x * x;
		}

		public Point translate(Vector v) {
			return new Point(x + v.x, y + v.y);
		}

		static double angle(Point a, Point o, Point b) { // returns value in radian
			Vector oa = new Vector(o, a), ob = new Vector(o, b);
			return Math.acos(oa.dot(ob) / Math.sqrt(oa.normSqr() * ob.normSqr()));
		}

		/*
		 * Counter-clockwise test, returns true if r is to the left of pq, if pq x pr >
		 * 0
		 */
		static boolean ccw(Point p, Point q, Point r) {
			Vector pq = new Vector(p, q), pr = new Vector(p, r);
			return pq.cross(pr) > 0;
		}

	}

	static public class Vector {
		double x, y;

		public Vector(double x, double y) {
			this.x = x;
			this.y = y;
		}

		public Vector(Point p, Point q) {
			this(q.x - p.x, q.y - p.y);
		}

		Vector scale(double s) {
			return new Vector(x * s, y * s);
		}

		double dot(Vector v) {
			return x * v.x + y * v.y;
		}

		double cross(Vector v) {
			return x * v.y - y * v.x;
		}

		double normSqr() {
			return x * x + y * y;
		}

		Vector reverse() {
			return new Vector(-x, -y);
		}

		Vector normalize() {
			return scale(1.0 / (Math.sqrt(normSqr())));
		}

		double norm() {
			return Math.sqrt(normSqr());
		}

		Vector rotate(double angle) {
			angle = degToRad(angle);
			double c = Math.cos(angle), s = Math.sin(angle);
			return new Vector(x * c - y * s, x * s + y * c);
		}

	}

	static double degToRad(double deg) {
		return deg * Math.PI / 180.0;
	}

	static double radToDeg(double rad) {
		return rad * 180.0 / Math.PI;
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
