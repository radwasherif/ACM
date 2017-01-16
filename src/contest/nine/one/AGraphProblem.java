package contest.nine.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AGraphProblem {
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

	static long dp[][];
	static int N;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in); 

		while(sc.ready()) {
			N = sc.nextInt(); 
			dp = new long [N+1][2]; 
			for (int i = 0; i < dp.length; i++) {
				Arrays.fill(dp[i], -1);
				//System.out.println(Arrays.toString(dp[i]));
				
			}
			System.out.println(dp(1, 1));
		}
		
	} 

	static long dp(int i, int canLeave) {
		//System.out.println(i);
		if (i >= N)
			return 1;
		if (dp[i][canLeave] != -1)
			return dp[i][canLeave]; 
		if (canLeave == 1) {
			long leave = dp(i + 1, 0);
			long take = dp(i + 2, 1);
			return dp[i][canLeave] = take + leave;
		} else {
			return dp[i][canLeave] = dp(i + 2, 1); //takeOnly 

		}
	}
}
