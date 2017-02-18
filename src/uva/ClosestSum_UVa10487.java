package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ClosestSum_UVa10487 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n;
		long t = 1;
		while ((n = sc.nextInt()) != 0) {
			long a[] = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();

			ArrayList<Long> sums = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++)
					sums.add(a[i] + a[j]);
			}
			Collections.sort(sums);
			out.printf("Case %d:\n", t++);
			// System.out.println(sums.toString());
			int m = sc.nextInt();
			while (m-- > 0) {
				int x = sc.nextInt();

				int low = 0;
				int high = sums.size() - 1;
				long sum = 0;

				if (x < sums.get(0))
					sum = sums.get(0);
				else if (x > sums.get(sums.size() - 1))
					sum = sums.get(sums.size() - 1);
				else

					while (low <= high) {
						int mid = (high + low) / 2;
						if (sums.get(mid) == x) {
							sum = x;
							break;
						}
						if (low == high - 1) {
							if (Math.abs(x - sums.get(low)) > Math.abs(x - sums.get(high))) {
								sum = sums.get(high);
							} else {
								sum = sums.get(low);
							}
							break;
						}

						else if (sums.get(mid) > x) {
							high = mid;
						} else {
							low = mid;
						}

					}
				out.printf("Closest sum to %d is %d.\n", x, sum);
			}

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

		boolean ready() throws IOException {
			return br.ready();
		}

	}
}
