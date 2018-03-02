package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WaterFalls_UVa833 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in); 
		PrintWriter out = new PrintWriter(System.out); 
		int c = sc.nextInt(); 
		while(c-- > 0) {
			int n = sc.nextInt(); 
			LineSegment lines [] = new LineSegment[n];
			for(int i = 0; i < n; i++) {
				Point p = new Point(sc.nextInt(), sc.nextInt()); 
				Point q = new Point(sc.nextInt(), sc.nextInt()); 
				if(p.y > q.y)
					lines[i] = new LineSegment(p, q); 
				else 
					lines[i] = new LineSegment(q, p); 
			}
			Arrays.sort(lines);

			int S = sc.nextInt();
			for(int i = 0; i < S; i++) {
				Point p = new Point(sc.nextInt(), sc.nextInt()); 
				 
				for(int j = 0; j < n; j++) {
					LineSegment vertical = new LineSegment(p, new Point(p.x, 0));
					if(vertical.intersect(lines[j])) {
						p.x = lines[j].q.x;
						p.y = lines[j].q.y;
					}
				}
				int x = (int) p.x; 
			out.println(x);
			
			}
			if(c > 0)
				out.println();
		}
		out.close();
	}
	static class LineSegment implements Comparable<LineSegment> {
		static double EPS = 1e-9; 
		Point p, q; 
		LineSegment(Point p, Point q) {this.p = p; this.q = q;}
		
		boolean intersect(LineSegment l) {
			Line l1 = new Line(p, q), l2 = new Line(l.p, l.q); 
			if(l1.parallel(l2)) {
				if(l1.same(l2))
					return p.between(l.p, l.q) || q.between(l.p, l.q) ||
							l.p.between(p, q) || l.q.between(p, q); 
				return false; 
			}
			Point c = l1.intersect(l2); 
			return c.between(p, q) && c.between(l.p, l.q); 
		}

		@Override
		public int compareTo(LineSegment o) {
			if(!(Math.abs(p.y - o.p.y) < EPS))
				return (p.y > o.p.y) ? -1: 1; 
			return (q.y > o.q.y) ? -1: 1;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return String.format("(%.1f,%.1f) (%.1f,%.1f)", p.x, p.y, q.x, q.y);
		}
	}
	static class Line {
		static final double EPS = 1e-9;
		double a, b, c;

		Line(Point p, Point q) {
			if (Math.abs(p.x - q.x) < EPS) {
				a = 1; b = 0.0; c = -p.x;
			} else {
				a = (p.y - q.y) / (q.x - p.x);
				b = 1.0;
				c = -(a * p.x + p.y);
			}
		}
		
		Line(Point p, double m) {
			a = -m; b = 1.0; c = -(a * p.x + p.y); 
		}
		static double abs (double x) {return Math.abs(x); }
		
		boolean parallel(Line l) { return abs(a - l.a) < EPS && abs(b - l.b) < EPS; }
		
		boolean same(Line l) { return parallel(l) && abs(c - l.c) < EPS; }
		
		Point intersect(Line l) {
			if(parallel(l))
				return null; 
			double x = (b * l.c - l.b * c) / (a * l.b - l.a * b);
			double y; 
			if(abs(b) < EPS) //if (b == 0), first line is vertical, substitute in second line equation
				y = -l.c - l.a * x;  
			else //only one of the two lines can be vertical
				y = -c - a * x;
			
			return new Point(x, y); 
		}
		
		Point closestPoint(Point p) {
			if(abs(b) < EPS) return new Point(-c, p.y); //line is x = -c
			if(abs(a) < EPS) return new Point(p.x, -c);// line is y = -c
			
			return intersect(new Line(p, 1/a)); //since for perpendicular lines m1 = -1/m2 and m1 = -a, then m2 = 1/a 
		}
		
		@Override
		public String toString() {
			return a + "*x + " + b + "*y + " + c + " = 0";
		}
		
			
	}
	static class Point implements Comparable<Point> {

		static final double EPS = 1e-9;
		double x, y; 
		Point(double x, double y) {this.x = x; this.y = y;}
		@Override
		/**
		 * compares with x first and then y 
		 */
		public int compareTo(Point p) { 
			if(Math.abs(x - p.x) > EPS) return (x > p.x) ? 1: -1; //if(x != p.x)  
			if(Math.abs(y - p.y) > EPS) return (y > p.y) ? 1: -1; //if(y != p.y) 
			return 0; 
		}
		
		static double sq(double x) {return x*x;}
		
		public double dist(Point p) {
			return Math.sqrt(sq(x - p.x) + sq(y - p.y)); 
		}
		
		public Point rotate(double theta) {
			double sin = Math.sin(theta); 
			double cos = Math.cos(theta); 
			
			return new Point(x*cos - y*sin, x*sin + y*cos); 
		}
		public Point rotate(double theta, Point p) {
			Vector v = new Vector(p, new Point(0, 0)); 
			return this.translate(v).rotate(theta).translate(v.reverse()); 
		}	
		
		Point translate(Vector v) { return new Point(x + v.x, y + v.y); }
		
		Point reflect(Line l) {
			Point p = l.closestPoint(this); 
			Vector v = new Vector(this, p); 
			return this.translate(v).translate(v); 
		}
		
		boolean between(Point p, Point q) {
			return x < Math.max(p.x, q.x) + EPS && x + EPS > Math.min(p.x, q.x)
					&& y < Math.max(p.y, q.y) + EPS && y + EPS > Math.min(p.y, q.y);
			
		}
		
		/*
		 * distance between point p and straight line defined by a and b,
		 * c = a + projection vector of v(ap) on v(ab)
		 * c = a + ((ab).(ap) / ||ab||) * (v(ab) / ||ab||)
		 * let u = ( ab.ap ) / ||ab||^2
		 * so c = a + v(av) * a  
		 */
		
		static double distToLine(Point p, Point a, Point b) {
			if(a.compareTo(b) == 0) return a.dist(p); 
			Vector ab = new Vector(a, b), ap = new Vector(a, p); 
			double u = ab.dot(ap) / ab.normSqr(); 
			Point c = a.translate(ab.scale(u)); 
			return c.dist(p); 
		}
		
		static double distToSegment(Point p, Point a, Point b) {
			if(a.compareTo(b) == 0) return a.dist(p); 
			Vector ab = new Vector(a, b), ap = new Vector(a, p); 
			double u = ab.dot(ap) / ab.normSqr(); 
			if(u < 0.0) return a.dist(p); // obtuse angle, p is closer to a
			if(u > 1.0) return b.dist(p);//projection is longer than line segment
			return distToLine(p, a, b); 
		}
		
		static double angle (Point a, Point o, Point b) { //returns value in radian
			Vector oa = new Vector(o, a), ob = new Vector(o, b); 
			return Math.acos(oa.dot(ob) / Math.sqrt(oa.normSqr() * ob.normSqr())); 
		}
		
		/*
		 * Counter-clockwise test, returns true if r is to the left of pq, 
		 * if pq x pr > 0
		 */
		static boolean ccw(Point p, Point q, Point r) {
			Vector pq = new Vector(p, q), pr = new Vector(p, r);
			return pq.cross(pr) > 0; 
		}
		
		static boolean collinear(Point p, Point q, Point r) {
			Vector pq = new Vector(p, q), pr = new Vector(p, r);
			return pq.cross(pr) < EPS; 
		}

		@Override
		public String toString() {
		
			return String.format("(%f , %f)", x, y);
		}

	}

	
	static class Vector {
		double x, y; 
		
		Vector(double x, double y) {this.x = x; this.y = y; }
		
		Vector(Point p, Point q) {this(q.x - p.x, q.y - p.y); }
		
		Vector scale(double s) { return new Vector(x * s, y * s); }
		
		double dot(Vector v) { return x * v.x + y * v.y; }
		
		double cross(Vector v) { return x * v.y - y * v.x; }
		
		double normSqr() { return x*x + y*y; }
		
		Vector reverse() { return new Vector(-x, -y ); }
		
		Vector normaize() { return scale(1/ (Math.sqrt(normSqr()))); }
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
