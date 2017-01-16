package codeforces.gym;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TeachYourselfPottery {
	static double l, r1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(new FileReader("frustum.in"));
		PrintWriter out = new PrintWriter(new FileWriter("frustum.out"));
		// Scanner sc = new Scanner(System.in);
		// PrintWriter out = new PrintWriter(System.out);
		l = sc.nextInt();
		r1 = sc.nextInt() / (2.0);
		// System.out.println(r2);
		int c = 2000;
		double left = 0;
		double right = l;
		// double ans = 0.0;
		double m1 = 0.0, m2 = 0.0;
		while (c-- > 0) {
			m1 = left + (right - left) / (3.0);
			m2 = left + (2.0) * (right - left) / (3.0);
			// System.out.println(m1 + " " + m2);
			// System.out.println("vol: " + vol(m1) + " " + vol(m2));
			if (vol(m1) < vol(m2))
				left = m1;
			else if (vol(m1) > vol(m2))
				right = m2;
		}
		out.println(vol(m1));
		out.flush();
		out.close();
	}

	static double vol(double h) {
		double r2 = r1 + Math.sqrt(l * l - h * h);
		return Math.PI / 3.0 * (r1 * r1 + r1 * r2 + r2 * r2) * h;
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		Scanner(FileReader r) {
			br = new BufferedReader(r);

		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}
	}
}
