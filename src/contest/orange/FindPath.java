package contest.orange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FindPath {
	static ArrayList<Integer> graph []; 
	static ArrayList<Integer> topo = new ArrayList<Integer>(); 
	static boolean vis[], hasP[]; 
	static int hasPath [] []; 
	static int curr; 
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in); 
		int n, m, q; 
		n = sc.nextInt(); 
		m = sc.nextInt(); 
		graph = new ArrayList[n+1]; 
		hasP = new boolean[n+1]; 
		hasPath = new int[n+1][n+1]; 
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Integer>(); 
		}
		vis = new boolean[n+1]; 
		
		while(m-- > 0) {
			int i = sc.nextInt(); 
			int j = sc.nextInt(); 
			graph[i].add(j);
			hasP[j] = true; 
			hasPath[i][j] = 1; 
		}
		for(curr = 1; curr <= n; curr++) {
			dfs(curr); 
			vis = new boolean[n+1]; 
		}
		q = sc.nextInt(); 
		StringBuilder sb = new StringBuilder(); 
		while(q-- > 0) {
			int u = sc.nextInt(); 
			int v = sc.nextInt(); 
			if(hasPath[u][v] == 1)
				sb.append("YES\n");
			else 
				sb.append("NO\n");
		}
		System.out.print(sb.toString());
		
	}
	
	static void dfs(int u) {
		vis[u] = true; 
		for(int v : graph[u]) {
			hasPath[curr][v] = 1; 
			if(!vis[v]) {
				dfs(v); 
			}
		}
	}
	
	static void topo(int u ) {
		vis[u] = true; 
		for(int v : graph[u] ) {
			if(!vis[v])
				topo(v); 
		}
		topo.add(u); 
	}
	static class Scanner 
	{
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
