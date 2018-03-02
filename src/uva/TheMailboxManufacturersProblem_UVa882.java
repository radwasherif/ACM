package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * Hint: DP 
 * You have k mailboxes and a range [min, max] of crackers that the mailbox might stand. 
 * Your goal is to find the minimum number of crackers to cover the entire range, given two scenarios: the box explodes, or it doesn't. 
 * For every x in [min + 1, max], if you test with x crackers there are two possibilities: the box explodes, then the range becomes [min, x - 1], 
 * or the box doesn't explode then the solution is in [x, max]. We take the maximum of the two scenarios, since we don't know in advance which one will happen.   
 * @author radwa
 *
 */
public class TheMailboxManufacturersProblem_UVa882 {
	static int memo[][][];

	public static void main(String[] args) throws NumberFormatException, Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = sc.nextInt();
		while (T-- > 0) {
			int k = sc.nextInt();
			int m = sc.nextInt();
			memo = new int[k + 1][m + 1][m + 1];
			for (int i = 0; i < k + 1; i++)
				for (int j = 0; j < m + 1; j++)
					Arrays.fill(memo[i][j], -1);
			int ans = dp(k, 0, m); //conceptually speaking, the box could stand 0 to m, (1, m) will make an off-by-one error
			out.println(ans);
		}
		out.flush();
		out.close();
	}

	static int dp(int k, int min, int max) {
		// System.out.println(k + " " + min + " " + max);
		if (min == max)
			return 0;
		if (k == 0) {
			return 1000000000;
		}
		if (memo[k][min][max] != -1)
			return memo[k][min][max];
		int ans = 1000000000;
		for (int i = min + 1; i <= max; i++) {
			ans = Math.min(ans, i + Math.max(dp(k - 1, min, i - 1), dp(k, i, max))); 
		}
		/**
		 * Choose i: a certain number of crackers to test with, 
		 * then add it to the maximum of dp(k-1, min, i - 1) --> when the box explodes with i crackers
		 * and dp(k, i, max)--> when the box doesn't explode with i crackers, here we choose i not i + 1, 
		 * because i might actually be the maximum number of crackers that the box can stand
		 * 
		 */

		return memo[k][min][max] = ans;
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

		String nextLine() throws IOException {
			return br.readLine();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		boolean ready() throws IOException {
			return br.ready();
		}
	}
}
