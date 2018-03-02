package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Intersection_UVa191 {
	static double EPS = 1e-9; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in); 
		PrintWriter out = new PrintWriter(System.out); 
		int n = sc.nextInt(); 
		while(n-- > 0) {
			LineSegment ls = new LineSegment(new Point(sc.nextInt(), sc.nextInt()), new Point(sc.nextInt(), sc.nextInt())); 
			int xleft = sc.nextInt(); 
			int ytop = sc.nextInt();
			int xright = sc.nextInt(); 
			int ybottom = sc.nextInt(); 
			
			Point p1 = new Point(xleft, ytop); 
			Point p2 = new Point (xright, ytop);
			Point p3 = new Point(xright, ybottom); 
			Point p4 = new Point(xleft, ybottom); 
			
			LineSegment l1 = new LineSegment(p1, p2); 
			LineSegment l2 = new LineSegment(p2, p3); 
			LineSegment l3 = new LineSegment(p3, p4); 
			LineSegment l4 = new LineSegment(p4, p1); 
			
//			System.out.println(p1.x + " " + p1.y);
			boolean ans = ls.intersect(l1) || ls.intersect(l2) || ls.intersect(l3) || l2.intersect(l4) || ls.p.between(p1, p3); 
			
			out.println(ans? "T" : "F");
			
		}
		out.close();
	}
	
	static class Point {
		double x, y; 
		Point(double x, double y) {
			this.x = x; 
			this.y = y; 
		}
		
		boolean between (Point p, Point q) {
			return x < Math.max(p.x, q.x) + EPS && x + EPS > Math.min(p.x,q.x) &&
					y < Math.max(p.y, q.y) + EPS && y + EPS > Math.min(p.y, q.y); 
		}
	}
	
	static class LineSegment {
		Point p, q; 
		LineSegment(Point p, Point q) {
			this.p = p; 
			this.q = q; 
		}
		boolean intersect(LineSegment l) {
			Line l1 = new Line(p, q); 
			Line l2 = new Line(l.p, l.q); 
			if(l1.parallel(l2)) {
				if(l1.same(l2))
					return p.between(l.p, l.q) || q.between(l.p, l.q) ||
							l.p.between(p, q) || l.q.between(p, q); 
				return false; 
			}
			Point c = l1.intersect(l2); 

			return c.between(p, q) && c.between(l.p, l.q); 
		}
	}
	
	static class Line {
		double a, b, c; 
		Line(Point p, Point q) {
			if(Math.abs(p.x - q.x) < EPS) { a = 1.0; b = 0.0; c = -p.x; }
			else {
				a = (p.y - q.y) / (q.x - p.x); 
				b = 1.0; 
				c = -(a * p.x + p.y); 
			}
		}
		
		boolean parallel(Line l) {return Math.abs(a - l.a) < EPS && Math.abs(b - l.b) < EPS; }
		boolean same(Line l) {return parallel(l) && Math.abs(c - l.c) < EPS; }
		Point intersect(Line l) {
			if(parallel(l))
				return null; 
			double x = (b * l.c - l.b * c) / (a * l.b - l.a * b);
			double y; 
			if(Math.abs(b) < EPS) //if (b == 0), first line is vertical, substitute in second line equation
				y = -l.c - l.a * x;  
			else //only one of the two lines can be vertical
				y = -c - a * x;
			
			return new Point(x, y); 
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
