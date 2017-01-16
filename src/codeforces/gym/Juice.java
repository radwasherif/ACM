package codeforces.gym;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Juice {
	static int N; 
	static ArrayList<Triple> adjList []; 
	static int cap []; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in); 
		N = sc.nextInt(); 
		adjList = new ArrayList [N + 1];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>(); 
		}
		cap = new int[N + 1]; 
		cap[0] = INF; 
		for(int v = 1; v <= N; v++) {
			int u = sc.nextInt(); 
			int r = sc.nextInt(); 
			int c = sc.nextInt();
			cap[v] = r; 
//			System.out.println(v + " " + c + " " + r);
			adjList[u].add(new Triple(v, r, c)); 
		}
		System.out.println(dp(0, INF));
	}
	static int INF = 100000000; 
	static int dp(int u, int power) {
		System.out.println(u + " " + power);
		if(power < 0)
			return -INF; 
		if(adjList[u].size() == 0)
			if(power >= cap[u])
				return 1; 
			else 
				return 0; 
		int max = -INF; 
		for(Triple v: adjList[u]) {
			if(u > 0 && power >= cap[u]) {
				max = 1 + Math.max(max,	dp(v.to, Math.min(power - cap[u], v.cable))); 
			} else {
				max = Math.max(max, dp(v.to, Math.min(power, v.cable))); 
			}
		}
		return max; 
	}
	static class Triple {
		int to, curCap, cable; 
		Triple (int to, int curCap, int cable) {
			this.to = to; 
			this.curCap = curCap; 
			this.cable = cable; 
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

		boolean ready() throws IOException {
			return br.ready();
		}
		 int nextInt() throws NumberFormatException, IOException {
			 return Integer.parseInt(next()); 
		 }
	}
}
