package camp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CaesarsLegion_118D {
	static int memo[][][][];
	static int k1, k2; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		k1 = sc.nextInt();
		k2 = sc.nextInt();
		memo = new int[n1 + 1][n2 + 1][k1 + 1][k2 + 1];
		for (int i = 0; i < memo.length; i++) {
			for (int j = 0; j < memo[i].length; j++) {
				for (int j2 = 0; j2 < memo[i][j].length; j2++) {
					Arrays.fill(memo[i][j][j2], -1);
				}
			}
		}
		System.out.println(dp(n1, n2, 0, 0));
	}
	static final int mod = (int)1e8; 
	static int dp(int N1, int N2, int c1, int c2) {
//		System.out.println(N1 + " " + N2);
		if(N1 < 0 || N2 < 0 || c1 > k1 || c2 > k2) 
			return 0; 
		if(N1 == 0 && N2 == 0)
			return 1; 
		if(memo[N1][N2][c1][c2] != -1)
			return memo[N1][N2][c1][c2]; 
		
		return memo[N1][N2][c1][c2] = ((dp(N1 - 1, N2, c1 + 1, 0)%mod) + dp(N1, N2 - 1, 0, c2 + 1)%mod)%mod;  
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
