package codeforces.div2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Article {
	
	static ArrayList<Integer> l;
	public static void dfs(int u){
		vis[u] = true;
		l.add(u);
		for(int nxt: adjList[u])
			if(!vis[nxt]) dfs(u);
		
		
	}
	
	static void bfs(int node)
	{
		dist = new int[n];
		
		vis[node] = true;
		Queue<Integer> q = new LinkedList<>();
		Queue<String> nodes = new LinkedList<>();
		q.add(node);
		nodes.add(node+"");
		dist[0] = 0;
		while(!q.isEmpty())
		{
			int u = q.remove();
			String sofar = nodes.remove();
			
			
		}
	}
	
	static ArrayList<Integer> adjList[];
	static boolean []vis;
	static int n;
	static int[] dist;
	
	public static void main(String[] args) throws IOException{
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		adjList = new ArrayList[n];
		vis = new boolean[n];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt()-1;
			int v = sc.nextInt()-1;
			adjList[u].add(v);
			adjList[v].add(u);
		}
		
		for(int i = 0; i < adjList[0].size(); ++i)
		{
			int node = adjList[0].get(i);
			vis = new boolean[n];
		}
		
	}
	
	static class Scanner {
		BufferedReader br; 
		StringTokenizer st; 
		Scanner (InputStream s) {
			br = new BufferedReader(new InputStreamReader(s)); 
		}
		Scanner(FileReader r) {
			br = new BufferedReader(r); 
			
		}
		String next() throws IOException {
			while(st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine()); 
			return st.nextToken(); 
		}
		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next()); 
		}
	}
}
