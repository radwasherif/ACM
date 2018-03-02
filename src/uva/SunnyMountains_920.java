package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SunnyMountains_920 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in); 
		PrintWriter out = new PrintWriter(System.out); 
		int C = sc.nextInt(); 
		while(C-- > 0) {
			int N = sc.nextInt(); 
			Point [] pts = new Point[N];
			int [] suffMax = new int[N]; 
			for(int i = 0; i < N; i++) {
				pts[i] = new Point(sc.nextInt(), sc.nextInt());  
			} 
			Arrays.sort(pts);
			suffMax[N - 1] = N - 1; 
			for(int i = N - 2; i >= 0; i--)
				 if(pts[i].y > pts[suffMax[i + 1]].y)
					 suffMax[i] = i; 
				 else 
					 suffMax[i] = suffMax[i + 1]; 
			
			double ans = 0; 
//			System.out.println(Arrays.toString(suffMax));
//			System.out.println(Arrays.toString(pts));

			for(int i = 0; i < N-1; i++) {
				if(suffMax[i] == i) {
					int nxt = suffMax[i + 1];
					Line hor = new Line(pts[nxt], new Point(0, pts[nxt].y)); 
					Line l = new Line(pts[i], pts[i + 1]); 
//					System.out.println(hor);
//					System.out.println(l);
					Point p = hor.intersect(l); 
//					System.out.println(p);
					ans += p.dist(pts[i]); 
//					System.out.println(ans);
				}
			}
				
			out.printf("%.2f\n", ans); 
		}
		out.flush();
		out.close();
	}
	
	static class Line {
		static final int EPS = (int) 1e-9;
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
		@Override
		public String toString() {
			return a + "*x + " + b + "*y + " + c + " = 0";
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
		
			
	}

	static class Point implements Comparable<Point> {

		static final double EPS = (int) 1e-9;
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
		@Override
		public String toString() {
		
			return String.format("(%.3f,%.3f)", x, y);
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
		
		Point translate(Vector v) { return new Point(x + v.x, y + v.y); }

		
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
