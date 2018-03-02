package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TheBusDriverProblem_UVa11389 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		while (true) {
			int n = sc.nextInt();
			int d = sc.nextInt();
			int r = sc.nextInt();

			if (n == 0 && d == 0 && r == 0)
				break;

			int a[] = new int[n];
			int b[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}

			for (int i = 0; i < n; i++) {
				b[i] = sc.nextInt();
			}

			Arrays.sort(a);
			Arrays.sort(b);

			int sum = 0;

			for (int i = 0; i < n; i++) {
				if (a[i] + b[n - 1 - i] > d)
					sum += a[i] + b[n - 1 - i] - d;

			}
			out.println(sum * r);
		}
		out.flush();
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}

			return st.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}
	}
}
