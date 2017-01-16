package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MarblesInJars {
	static long mod = 1000000007;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int a[] = new int[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = sc.nextInt();
			}
			Arrays.sort(a);
			long ans = 1;
			for (int i = 0; i < a.length; i++) {
				// if(a[i] > 0)
				int num = a[i] -i; 
				if(num < 0) num = 0; 
				ans = mul(ans, num);
			}
			sb.append("Case " + t + ": " + ans + "\n");

		}
		System.out.print(sb);
	}

	static long mul(long a, long b) {
		return ((a % mod) * (b % mod)) % mod;
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		public Scanner(InputStream s) {
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
	}

}
