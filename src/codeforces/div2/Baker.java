package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Baker {
	static ArrayList<Pair> adjList[];

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int m = sc.nextInt(), k = sc.nextInt();
		adjList = new ArrayList[N + 1];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<Pair>();
		}
		while (m-- > 0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int wt = sc.nextInt();
			adjList[u].add(new Pair(v, wt)); 
			adjList[v].add(new Pair(u, wt)); 
		}
		int ans = 1000000000; 
		TreeSet<Integer> bak = new TreeSet<>(); 
		ArrayList<Integer> a = new ArrayList<>(); 
		while(k-- > 0) {
			int x = sc.nextInt();
			a.add(x); 
			bak.add(x); 
		}
//		System.out.println(bak.toString());
		boolean found = false; 
		for(int u : a) {
			for(Pair v: adjList[u]) {
				if(!bak.contains(v.to)) {
					found = true; 
//					System.out.println("YO");
					ans = Math.min(ans, v.wt); 
				}
			}
		}
		System.out.println(found ? ans : -1);
	}

	static class Pair {
		int to, wt;

		Pair(int t, int w) {
			to = t;
			wt = w;
		}
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
