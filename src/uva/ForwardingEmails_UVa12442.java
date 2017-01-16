package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ForwardingEmails_UVa12442 {
	static boolean[] vis, hasP, done;
	static int child[];
	static int n;
	static int[] reachables;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			n = sc.nextInt();
			child = new int[n + 1];
			hasP = new boolean[n + 1];
			vis = new boolean[n + 1];
			reachables = new int[n + 1];
			done = new boolean[n + 1];
			for(int k = 0; k < n; k++) {
				int i = sc.nextInt();
				int j = sc.nextInt();
				child[i] = j;
				hasP[j] = true;
			}
			for (int i = 1; i < hasP.length; i++) {
				if (!hasP[i]) {
					vis = new boolean[n + 1];
					dfs(i);
				}
			}
			vis = new boolean[n + 1];
			for (int i = 1; i < done.length; i++) {
				if (!done[i])
					dfs(i);
			}
			int max = 0;
			int ans = 1;
			for (int i = 1; i < reachables.length; i++) {
				if (reachables[i] > max) {
					max = reachables[i];
					ans = i;
				}
			}
			//System.out.println(Arrays.toString(reachables));
			sb.append("Case " + t + ": " + ans + "\n");

		}
		System.out.print(sb);
	}

	static int dfs(int u) {
		if (vis[u])
			return -1;
		vis[u] = true;
		done[u] = true;
		if (child[u] == 0)
			return 0;
		return reachables[u] = 1 + dfs(child[u]);
	}

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
}
