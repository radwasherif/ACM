package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PrimeRingProblem_UVa524 {
	static int n, msk;
	static int[] ans;
	static PrintWriter out;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		out = new PrintWriter(System.out);
		int t = 1;
		int c = 7;
		while (sc.ready()) {
//			 while(c-- > 0) {/
			if(t > 1)
				out.println();
			n = sc.nextInt();
			ans = new int[n];
			ans[0] = 1;
			msk = (1 << 1);
			out.printf("Case %d:\n", t++);
			backtrack(1); 
		}
		out.flush();
		out.close();
	}

	static void backtrack(int c) {
		if (c == n && isPrime(ans[c - 1] + ans[0])) {
			for (int i = 0; i < n; i++) {
				if (i > 0)
					out.print(" ");
				out.print((ans[i]));
			}
			out.println();
		}
		for (int i = 2; i <= n; i++) {

			if ((msk & (1 << i)) == 0 && isPrime(i + ans[c - 1])) {
				ans[c] = i;
				msk = (msk | (1 << i));
				backtrack(c + 1);
				msk = (msk ^ (1 << i));
			}

		}
	}

	static boolean isPrime(int n) {
		for (int i = 2; i < n / 2; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
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
