package camp;

import java.awt.Adjustable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class KefaAndPark {
	static int [] cat;
	static boolean vis[]; 
	static int C, X; 
	static ArrayList<Integer> adjList[]; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in); 
		int N = sc.nextInt();
		X = sc.nextInt(); 
		adjList = new ArrayList[N]; 
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>(); 
		}
		cat = new int [N];
		vis = new boolean[N]; 
		for (int i = 0; i < cat.length; i++) {
			cat[i] = sc.nextInt(); 
		}
		for(int i = 0; i < N - 1; i++) {
			int v = sc.nextInt() - 1; 
			int u = sc.nextInt() - 1; 
			adjList[u].add(v); 
			adjList[v].add(u); 
		}
		dfs(0, 0); 
		System.out.println(C);
		
	}
	static void dfs(int u, int c) {
		System.out.println(u + " " + c);
		vis[u] = true; 
		boolean leaf = true; 
		for(int v : adjList[u]) {
			if(!vis[v]) {
				leaf = false; 
				dfs(v, c + cat[u]); 
			}
		}
		if(leaf) {
			if(c <= X)
				C++; 
		}
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
