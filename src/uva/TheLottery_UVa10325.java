package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheLottery_UVa10325 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		while (sc.ready()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int M[] = new int[m];
			for (int i = 0; i < M.length; i++) {
				M[i] = sc.nextInt();
			}
			long ans = 0;
			for (int i = 1; i < (1 << m); i++) {
				long lcm = 1;
				int size = 0;
				for (int j = 0; j < m; j++) {
					if ((i & (1 << j)) > 0) {
						size++;
						// System.out.println(j + " " + M[j]);
						lcm = lcm(lcm, M[j]);
					}
				}
				// System.out.println(size);
				ans += ((size - 1) % 2 == 0 ? 1 : -1) * (n / lcm);
				// System.out.pri ntln(ans);
			}
			out.println(n - ans);
		}
		out.flush();
		out.close(); 
	}

	static long lcm(long a, long b) {
		return (1l * a * b) / gcd(a, b);
	}

	static long gcd(long n, long m) {
		if (m == 0)
			return n;
		return gcd(m, n % m);
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

		boolean ready() throws IOException {
			return br.ready();
		}

	}
}
