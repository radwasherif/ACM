package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PickUpStick_UVa10902 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in); 
		PrintWriter out = new PrintWriter(System.out); 
		while(true) {
			int n = sc.nextInt(); 
			if(n == 0)
				break; 
			LineSegment l [] = new LineSegment[n]; 
			for(int i = 0; i < n; i++) {
				l[i] = new LineSegment(new Point(sc.nextDouble(), sc.nextDouble()), new Point(sc.nextDouble(), sc.nextDouble())); 
			}
			
			ArrayList<Integer> tops = new ArrayList<Integer>(); 
			for(int i = 0; i < n; i++) {
				boolean top = true; 
				for(int j = i + 1; j < n; j++) {
					if(l[i].intersect(l[j])) {
						top = false; 
						break; 
					}
				}
				if(top) 
					tops.add(i + 1); 
				
			}
			out.print("Top sticks: " + tops.get(0));
			
			for(int i = 1; i < tops.size(); i++)
				out.printf(", %d", tops.get(i)); 
			out.println(".");
		
		}
		out.flush();
		out.close();
		
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
		
		static double abs(double x) {return Math.abs(x); }
	}
	
	static class Point implements Comparable<Point>{
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
		
		boolean between(Point p, Point q) {
			return x < Math.max(p.x, q.x) + EPS && x + EPS > Math.min(p.x, q.x)
					&& y < Math.max(p.y, q.y) + EPS && y + EPS > Math.min(p.y, q.y);
			
		}
	}
	
	static class LineSegment {
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

		
	}
}
