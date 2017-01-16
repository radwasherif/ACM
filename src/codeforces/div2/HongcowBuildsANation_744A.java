package codeforces.div2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class HongcowBuildsANation_744A {
	static int n, m, k;
	static ArrayList<Integer> adjList[];
	static boolean gov[];
	static int comp[];
	static int cNodes, cEdges;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		adjList = new ArrayList[n + 1];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>();
		}
		gov = new boolean[n + 1];
		vis = new boolean[n + 1];
		comp = new int[n + 1];
		for (int i = 0; i < k; i++) {
			gov[sc.nextInt()] = true;
		}
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			adjList[u].add(v);
			adjList[v].add(u);
		}
		long ans = 0;
		for (int i = 1; i < gov.length; i++) {
			if (gov[i]) {
				cNodes = 0;
				cEdges = 0;
				dfs(i);
				ans += cNodes * (cNodes - 1) / 2 - cEdges;
			System.out.println(cNodes);
			}
		}
		long lastNodes = 1; 
		for (int i = 0; i < n; i++) {
			if (vis[i]) {
				cNodes = 0;
				cEdges = 0;
				dfs(i);
				ans += cNodes * (cNodes - 1) / 2 - cEdges;
				lastNodes*= cNodes; 
				ans += lastNodes; 
			}
		}
		System.out.println(ans);
	}

	static boolean vis[];

	static void dfs(int u) {
		vis[u] = true;
		cNodes++;
		for (int v : adjList[u]) {
			cEdges++;
			if (!vis[v]) {
				dfs(v);
			}
		}
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
