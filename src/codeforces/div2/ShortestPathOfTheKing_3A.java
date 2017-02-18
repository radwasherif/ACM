package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ShortestPathOfTheKing_3A {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		String s = sc.next();
		int ys = s.charAt(0) - 'A';
		int xs = 8 - (s.charAt(1) - '0');
		s = sc.next();
		int yt = s.charAt(0) - 'A';
		int xt = 8 - (s.charAt(1) - '0');
		int dx = xs - xt;
		int dy = ys - yt;
		int count = 0;
		int d1 = Math.min(Math.abs(dx), Math.abs(dy));
		count += d1;
		s = "";
		if (dx < 0) {
			if (dy < 0) {
				s = "RD";
			} else {
				s = "LD";
			}
		} else {
			if (dy < 0) {
				s = "RU";
			} else {
				s = "LU";
			}
		}
		if (dx != 0)
			dx -= (dx / Math.abs(dx)) * d1;
		if (dy != 0)
			dy -= (dy / Math.abs(dy)) * d1;
		int d2 = Math.max(Math.abs(dx), Math.abs(dy));

		count += d2;
		out.println(count);
		for (int i = 0; i < d1; i++) {
			out.println(s);
		}

		if (dx < 0) {
			s = "D";
		} else if (dx > 0) {
			s = "U";
		}
		if (dy < 0) {
			s = "R";
		} else if (dy > 0) {
			s = "L";
		}

		for (int i = 0; i < d2; i++) {
			out.println(s);
		}
		out.flush();
		out.close();
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

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

	}
}
