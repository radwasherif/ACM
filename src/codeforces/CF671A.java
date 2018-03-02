package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF671A {

	static int n;
	static Point orA, orB, rec;
	static Point bin[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		orA = new Point(sc.nextInt(), sc.nextInt());
		orB = new Point(sc.nextInt(), sc.nextInt());
		rec = new Point(sc.nextInt(), sc.nextInt());

		n = sc.nextInt();
		double total = 0.0;
		double[] preA, suffA, b;
		preA = new double[n + 2];
		suffA = new double[n + 2];
		b = new double[n + 2];
		
		
		for (int i = 1; i <= n; i++) {
			Point bin = new Point(sc.nextInt(), sc.nextInt());
			double distToRec = bin.dist(rec);
			total += distToRec * 2;
			preA[i] = suffA[i] = bin.dist(orA) - distToRec;
			b[i] = bin.dist(orB) - distToRec;

		}
		preA[0] = suffA[n + 1] = Double.MAX_VALUE; 
		for (int i = 1; i <= n; i++)
			preA[i] = Math.min(preA[i], preA[i - 1]);

		for (int i = n; i >= 1; i--)
			suffA[i] = Math.min(suffA[i], suffA[i + 1]);

		double ans = total + suffA[1]; // here suffA[0] is the minimum value for A
		//this is the first case where we take min from A and ignore B 

		for (int i = 1; i <= n; i++) {
			//here we check whether its cheaper to take min for b only, or min for b with another min for A 
			ans = Math.min(ans, total + b[i] + Math.min(0, Math.min(suffA[i + 1], preA[i - 1]) ));
		}
		System.out.printf("%.21f\n", ans);

	}


	static class Point {
		double x, y;

		Point(double x, double y) {
			this.x = x;
			this.y = y;
		}

		double dist(Point p) {
			return Math.sqrt(sq(x - p.x) + sq(y - p.y));
		}

		static double sq(double x) {
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
