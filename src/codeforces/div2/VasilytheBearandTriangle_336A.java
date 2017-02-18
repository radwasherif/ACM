package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class VasilytheBearandTriangle_336A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int n = Math.abs(x) + Math.abs(y);
		if (x > 0) {
			if (y > 0)
				System.out.printf("%d %d %d %d", 0, n, n, 0);
			else
				System.out.printf("%d %d %d %d", 0, -n, n, 0);
		} else {
			if (y > 0)
				System.out.printf("%d %d %d %d", -n, 0, 0, n);
			else
				System.out.printf("%d %d %d %d", -n, 0, 0, -n);
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

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

	}
}
