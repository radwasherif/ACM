package contest.nine.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Functions {
	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {

			br = new BufferedReader(new InputStreamReader(s));

		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}

	static final int mod = (int) 1e9 + 7;
	static int atLeastOne[] []; 
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		nCr(1001);
		fac(1001);
		pow(1001); 
		atLeastOne= new int[101][1001]; 
		atLeastOne(101, 1001); 
		for (int c = 1; c <= t; c++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			int min = Math.min(x, y);
			
			long bi = 0;
			long inj = 0, total = 0, surj =0;

			for (int i = 1; i <= min; i++) {
				bi = (bi + mul(comb[x][i], mul(comb[y][i], fac[i]))) % mod;
			}
			for (int j = 1; j <= y; j++) {
				long sum = 0;
				for (int i = 1; i <= j; i++) {
					sum = (sum + mul(comb[x][i], mul(comb[j][i], fac[i])))
							% mod;
				}
				inj = (inj + mul(comb[y][j], sum)) % mod;
			}
			for (int j = 1; j <= y; j++) {
				for(int i =1; i <= x; i++) {
					total = (total + mul(comb[x][i], mul(comb[y][j], pow[j][i]))) % mod; 
				}
			}
			for(int i = 1; i <=x; i++) {
				for(int j =1; j <= y; j++) {
					surj = (surj + mul(comb[x][i], mul(comb[y][j], atLeastOne[i][j]))) % mod; 
				}
			}
			System.out.println("Case " + c + ": " + inj + " " + surj + " " + bi + " " + total);
		}

	}

	static int comb[][];

	static void nCr(int N) {
		comb = new int[N][N];
		comb[0][0] = 1;
		for (int i = 1; i < N; i++) {
			comb[i][0] = 1;
			for (int j = 1; j <= i; j++) {
				comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % mod;
			}
		}

	}

	static int fac[];

	static void fac(int n) {
		fac = new int[n + 1];
		fac[0] = 1;
		fac[1] = 1;
		for (int i = 2; i < n; i++)
			fac[i] = (int) mul(i, fac[i - 1]);
	}

	static long mul(long a, long b) {
		return a * b % mod;
	}

	static int pow[][];

	static void pow(int N) {
		pow = new int[N][N];
		for (int i = 0; i < pow.length; i++) {
			pow[i][0] = 1;
			for (int j = 1; j < comb.length; j++) {
				pow[i][j] = (int) mul(i, pow[i][j-1]); 
			}
		}
	}
	

	static void atLeastOne (int x, int y) {
		atLeastOne[0][0] =1; 
		for(int i =1; i < x; i++) {
			for(int j =1; j < y; j++) {
				int sum = 0; 
				for(int k =1; k<=i; k++) {
					sum = (int) (sum + mul(comb[i][k], atLeastOne[i-k][j-1])) % mod; 
					//System.out.println(atLeastOne[i-k][j-1]);
				}
				atLeastOne[i][j] =  sum; 
			}
		}
		
		
	}
}
