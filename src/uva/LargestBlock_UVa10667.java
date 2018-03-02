package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LargestBlock_UVa10667 {
	static int a[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int p = sc.nextInt();
		while (p-- > 0) {
			int s = sc.nextInt();
			a = new int[s][s];
			for(int i = 0; i < s; i++) Arrays.fill(a[i], 1);
			int b = sc.nextInt();
			while (b-- > 0) {
				int r1 = sc.nextInt() - 1;
				int c1 = sc.nextInt() - 1;
				int r2 = sc.nextInt() - 1;
				int c2 = sc.nextInt() - 1;
				for (int i = r1; i <= r2; i++) {
					for (int j = c1; j <= c2; j++) {
						a[i][j] = -100000;
					}
				}
			}

			for (int i = 0; i < s; i++) {
				for (int j = 0; j < s; j++) {
					int sum = 0;
					if (i > 0)
						sum += a[i - 1][j];
					if (j > 0)
						sum += a[i][j - 1];
					if (i > 0 && j > 0)
						sum -= a[i - 1][j - 1];
					a[i][j] += sum;
				}
			}

			int max = -1000000;
			for (int i = 0; i < s; i++) {
				for (int j = 0; j < s; j++) {
					for (int l = i; l < s; l++) {
						for (int k = j; k < s; k++) {
							int sum = a[l][k];
							if (i > 0)
								sum -= a[i - 1][k];
							if (j > 0)
								sum -= a[l][j - 1];
							if (i > 0 && j > 0)
								sum += a[i - 1][j - 1];
							max = Math.max(sum, max);
						}
					}
				}
			}
			out.println(max > 0? max : 0);

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
	}

}
