package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 10496 - Travelling Salesman 
 */
public class CollectingBeepers {
	static int n;
	static int dist[][];
	static int dp[][]; 
	static ArrayList<Integer> sol; 
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder(); 
		int t = sc.nextInt(); 
		while (t-- > 0) {
			sc.nextInt(); sc.nextInt(); 
			ArrayList<Integer> x = new ArrayList<Integer>(); 
			ArrayList<Integer> y = new ArrayList<Integer>(); 
			x.add(sc.nextInt()); 
			y.add(sc.nextInt()); 
			n = sc.nextInt(); 
			dist = new int[n+1][n+1]; 
			for(int i = 0; i < n; i++) {
				x.add(sc.nextInt()); 
				y.add(sc.nextInt()); 
			}
			for(int i = 0; i <= n; i++) {
				for(int j = 0; j <= n; j++) {
					int dx = Math.abs(x.get(i) - x.get(j)); 
					int dy = Math.abs(y.get(i) - y.get(j)); 
					dist[i][j] = dx + dy;
					dist[j][i] = dx + dy; 
				}
			}
			dp = new int [n+1][(1<<(n+1))]; 
			for (int i = 0; i < dp.length; i++) {
				Arrays.fill(dp[i], -1);
			}
			//System.out.println(Arrays.deepToString(dist));
			sb.append("The shortest path has length " + tsp(0, 1)); 
			sb.append('\n'); 
		}
		System.out.print(sb);
		
	}
	static int tsp(int pos, int mask) {
		//System.out.println(pos + " " + Integer.toBinaryString(mask));
		if(mask == (1<< (n+1))-1) // all the bits = 1, all cities visited
			return dist[pos][0]; //return the distance from where I am to the starting node 
		int min = 1000000000; //not sure if large enough
		if(dp[pos][mask] != -1)
			return dp[pos][mask]; 
		for (int i = 0; i <= n; i++) {
			if(i != pos && ((mask & (1<<i)) == 0)) //check if ith bit is zero 
			min = Math.min( dist[pos][i] + tsp(i, (mask | (1<<i))), min); //set ith bit to 1
		}
		return dp[pos][mask] = min; 
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
