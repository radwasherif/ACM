package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import geometry.Point;




public class CF498A {
	static double EPS = 1e-9; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in); 
		
		Point home = new Point(sc.nextInt(), sc.nextInt()); 
		Point uni = new Point(sc.nextInt(), sc.nextInt());
		int n = sc.nextInt(); 
		int ans = 0; 
		while(n-- > 0) {
			Line l  = new Line(sc.nextInt(), sc.nextInt(), sc.nextInt()); 
			if(!l.onSameSide(home, uni))
				ans++; 
		}
		System.out.println(ans);
	}
	
	static class Point {
		double x, y; 
		Point(double x, double y) {this.x = x; this.y = y; }
		
	}
	
	static class Line {
		double a, b, c; 
		
		Line(double a, double b, double c) {
			this.a = a; 
			this.b = b; 
			this.c = c; 
		}
		
		Line(Point p, Point q) {
			if(p.x == q.x) {a = 1.0; b = 0.0; c = -p.x; }
			else {
				a = (p.y - q.y) / (q.x - p.x); 
				b = 1.0; 
				c = - (a * p.x + p.y); 
			}
		}
		boolean onSameSide(Point p, Point q) {
			boolean posP = a * p.x + b* p.y + c > 0.0; 
			boolean posQ = a * q.x + b * q.y + c > 0.0;
			return !(posP ^ posQ); 
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
