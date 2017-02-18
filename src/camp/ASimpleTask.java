package camp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ASimpleTask {
	static int n, m;
	static int e[][];
	static int dp[];
	static int cur; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		e = new int[n][n];
		while (m-- > 0) {
			int i = sc.nextInt() - 1; 
			int j = sc.nextInt() - 1; 
			e[i][j] = 1;
			e[j][i] = 1; 
		}
//		System.out.println(Arrays.deepToString(e));
		dp = new int[(1 << n) - 1];
	
			int ans = 0; 
		for(int i = 0; i < n; i++) {
			cur = i; 
			Arrays.fill(dp, -1);
			ans += dp(cur, 0); 
			
		}
		System.out.println(ans);
	}

	static int dp(int i, int msk) {
//		System.out.println(i + " " + Integer.toBinaryString(msk)); 
		if (msk == (1 << n) - 1)
			return 0;
		if(dp[msk] != -1)
			return dp[msk]; 
		int ans = 0;
		for (int j = cur + 1; j < n; j++) {
			if (e[i][j] == 1 && ((msk & (1 << j)) == 0)) {
				ans += dp(i, (msk | (1 << i)));
			} else if(j == cur)
				return 1; 
		}

		return ans;
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		Scanner(FileReader r) {
			br = new BufferedReader(r);
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
