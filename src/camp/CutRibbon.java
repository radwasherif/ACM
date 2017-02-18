package camp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CutRibbon {
	static int n, a, b, c; 
	static final int INF = (int)1e9; 
	static int memo[]; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in); 
			n = sc.nextInt(); 
			a = sc.nextInt(); 
			b = sc.nextInt(); 
			c = sc.nextInt();
			memo = new int[n + 1]; 	
			Arrays.fill(memo, -1); 
			System.out.println(dp(n));
	}
	static int dp (int left) {
		if(left < 0)
			return -INF;
		if(left == 0)
			return 0; 
		if(memo[left] != -1)
			return memo[left];
		return memo[left] = Math.max(dp(left - a), Math.max(dp(left - b), dp(left - c))) + 1; 
		
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
