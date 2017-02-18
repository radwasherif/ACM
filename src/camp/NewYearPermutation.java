package camp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class NewYearPermutation {
	static ArrayList<Integer> adjList[]; 
	static ArrayList<Integer> ind, val; 
	static int a[]; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt(); 
		a = new int[n]; 
		TreeMap<Integer, Integer> valueToIndex = new TreeMap<>();
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt(); 
			valueToIndex.put(a[i], i); 
		}
		adjList = new ArrayList[n]; 
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>(); 
		}
		for(int i = 0; i < n; i++) {
			String s = sc.next(); 
			for(int j = 0; j < n; j++) {
				if(s.charAt(j) == '1')
				{
					adjList[i].add(j); 
					adjList[j].add(i); 
				}
			}
		}
		vis = new boolean[n]; 
		for(int i = 0; i < n; i++) {
			ind = new ArrayList<>(); 
			val = new ArrayList<>(); 
			dfs(i); 
			Collections.sort(ind);
			Collections.sort(val);
			for(int k = 0; k < val.size(); k++) {
				a[ind.get(k)] = val.get(k); 
			}
			
		}
		for (int i = 0; i < a.length; i++) {
			if(i > 0)
				System.out.print(" ");
			System.out.print(a[i]);
		}
		System.out.println();
		 
	}
	static boolean vis[]; 
	static void dfs(int u) {
		vis[u] = true; 
		ind.add(u); 
		val.add(a[u]); 
		for(int v: adjList[u]) {
			if(!vis[v]) {
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
