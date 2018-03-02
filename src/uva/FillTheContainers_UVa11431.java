package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FillTheContainers_UVa11431 {
	static int a[];
	static int m, n;

	public static void main(String[] args) throws NumberFormatException, Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int c = 1;
		while (c-- > 0) {
			n = sc.nextInt();
			m = sc.nextInt();
			
			a = new int[n];
			int max = -1;
			int sum = 0;

			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
				max = Math.max(max, a[i]);
				sum += a[i];
			}
			if (m >= n) {
				out.println(max);
				continue;
			}
			long low = max;
			long high = sum;
			long mid = (high + low) / 2;
			verify(75); 
			while (low <= high) {
				mid = (low + high) / 2;
				boolean nefe3 = verify(mid);
				if (nefe3) {
					if (!verify(mid - 1))
						break;
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}

			out.println(mid);

		}
		out.flush();
	
	}

	static boolean verify(long max) {
		int count = 0;
		int idx = 0;
		for (int i = 0; i < a.length; i++) {
			count += a[i];
			if (count > max) {
				idx++;
				count = a[i];
			}
			if (idx >= m)
				return false;
		}
		return true;
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(System.in));

		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		boolean ready() throws IOException {
			return br.ready();
		}
	}
}
