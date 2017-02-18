package camp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Animals {
	static int n, x;
	static int memo[][];
	static int c[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(new FileReader("input.txt"));
		PrintWriter out = new PrintWriter(new FileWriter("output.txt")); 
		n = sc.nextInt();
		x = sc.nextInt();
		c = new int[n];
		for (int i = 0; i < c.length; i++) {
			c[i] = sc.nextInt();
		}
		memo = new int[x + 1][n];
		for(int i = 0; i < memo.length; i++)
			Arrays.fill(memo[i], -1);
		out.println(dp(x, 0));
		out.flush();
		out.close();
	}

	static int INF = (int) 1e9;

	static int dp(int rem, int i) {
		if (rem == 0)
			return 0;
		if (rem < 0)
			return -INF;
		if (i == n)
			return 0;
		if(memo[rem][i] != -1)
			return memo[rem][i]; 
		int take = 1 + dp(rem - (n - i) * c[i], i + 1);
		int leave = dp(rem, i + 1);
		return memo[rem][i] = Math.max(take, leave);

	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;


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
