package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.acl.Permission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ExposingCorruption_UVa13008 {
	static int D, P, R, B;
	static int cost[];
	static boolean vis[];
	static ArrayList<Integer> adjList[];
	static ArrayList<Integer> totalCosts, dMem, pMem;
	static int[] comp;
	static int[][] dp_p, dp_d;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		 int c = 1;
		while(c-- > 0) {
//		while (sc.ready()) {
			D = sc.nextInt();
			P = sc.nextInt();
			R = sc.nextInt();
			B = sc.nextInt();
			totalCosts = new ArrayList<Integer>();
			dMem = new ArrayList<Integer>();
			pMem = new ArrayList<Integer>();
			cost = new int[D + P];
			vis = new boolean[D + P];
			comp = new int[D + P];
			for (int i = 0; i < D + P; i++)
				cost[i] = sc.nextInt();

			adjList = new ArrayList[D + P];
			for (int i = 0; i < adjList.length; i++)  {
				adjList[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < R; i++) {
				int x = sc.nextInt() - 1;
				int y = sc.nextInt() - 1;
				// System.out.println(x + " " + y);
				adjList[x].add(y + D);
				adjList[y + D].add(x);
			}
			CC = 0;
			for (int i = 0; i < D + P; i++) {
				if (!vis[i]) {
					compCost = 0;
					dCount = 0;
					pCount = 0;
					dfs(i, CC++);
					totalCosts.add(compCost);
					dMem.add(dCount);
					pMem.add(pCount);
				}
			}
			System.out.println(Arrays.toString(comp));
			System.out.println(totalCosts.toString());
			dp_p = new int[CC][B + 1];
			dp_d = new int[CC][B + 1];
			for (int i = 0; i < dp_p.length; i++) {
				Arrays.fill(dp_p[i], -1);
				Arrays.fill(dp_d[i], -1);
			}
			out.println(dp_d(0, B) + " " + dp_p(0, B));
		}
		out.flush();
		out.close();
	}

	static int compCost, dCount, pCount;

	static void dfs(int u, int CC) {
		vis[u] = true;
		compCost += cost[u];
		comp[u] = CC;
		if (u < D)
			dCount++;
		else
			pCount++;
		for (int v : adjList[u]) {
			if (!vis[v])
				dfs(v, CC);
		}
	}

	static int INF = 1000000000;
	static int CC;

	static int dp_d(int i, int remainder) {
		if (remainder < 0)
			return -INF;
		if (i == CC)
			return 0;
		if(dp_d[i][remainder] != -1)
			return dp_d[i][remainder]; 
		
		int keep = dp_d(i + 1, remainder) + dMem.get(i);
		int change = dp_d(i + 1, remainder - cost[i]) + pMem.get(i);
		return dp_d[i][remainder] = Math.max(keep, change);
	}

	static int dp_p(int i, int remainder) {
		if (remainder < 0)
			return -INF;
		if (i == CC)
			return 0;
		if(dp_p[i][remainder] != -1)
			return dp_p[i][remainder]; 
		int keep = dp_p(i + 1, remainder) + pMem.get(i);
		int change = dp_p(i + 1, remainder - cost[i]) + dMem.get(i);
		return dp_p[i][remainder] = Math.max(keep, change);
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		boolean ready() throws IOException {
			return br.ready();
		}

	}
}
