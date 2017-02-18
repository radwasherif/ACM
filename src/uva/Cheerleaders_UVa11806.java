package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Cheerleaders_UVa11806 {
	static int MOD = 1000007;

	public static void main(String[] args) throws NumberFormatException, IOException {
		PrintWriter out = new PrintWriter(System.out);
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		nCr(20 * 20);
//		System.out.println(Arrays.deepToString(nCr));
		for (int i = 1; i <= T; i++) {
			int m = sc.nextInt(), n = sc.nextInt(), k = sc.nextInt();
			if(k > m * n)
			{
				out.printf("Case %d: %d\n", i, 0);
				continue; 
			}
			int ans = nCr[n * m][k];
//			System.out.println(ans);
			ans -= 2 * nCr[(m - 1) * n][k]; 
//			System.out.println(ans);
			ans = mod(ans, MOD); 
			ans -= 2 * nCr[m * (n - 1)][k];
//			System.out.println(ans);
			ans = mod(ans, MOD); 
			ans += nCr[m * (n - 2)][k];
//			System.out.println(ans);
			ans = mod(ans, MOD); 
			ans += nCr[(m - 2) * n][k];
//			System.out.println(ans);
			ans = mod(ans, MOD); 
			ans += 4 * nCr[(n - 1) * (m - 1)][k];
//			System.out.println(ans);
			ans = mod(ans, MOD); 
			ans += -2 * (nCr[(m - 2) * (n - 1)][k]);
//			System.out.println(ans);
			ans = mod(ans, MOD); 
			ans += -2 * nCr[(m - 1) * (n - 2)][k];
//			System.out.println(ans);
			ans = mod(ans, MOD); 
			ans += nCr[(m - 2) * (n - 2)][k];
//			System.out.println(ans);
			ans = mod(ans, MOD); 
			out.printf("Case %d: %d\n", i, ans); 
		}
		out.flush();
		out.close(); 
		
	}
	static int mod(int a, int n) {
		if (a >= 0)
			return a % n;
		return (a % n + n) % n;
	}
	static int add(int a, int b) {
		return (a % MOD + b % MOD) % MOD;
	}

	static int[][] nCr;

	// using the concept of pascal's triangle
	static void nCr(int N) {
		nCr = new int[N + 1][N + 1];
		for (int i = 0; i < nCr.length; i++) {
			nCr[i][0] = nCr[i][i] = 1;
			for (int j = 1; j < i; j++) {
				nCr[i][j] = (nCr[i - 1][j - 1] % MOD + nCr[i - 1][j] % MOD) % MOD;

			}
		}
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		boolean ready() throws IOException {
			return br.ready();
		}

	}
}
