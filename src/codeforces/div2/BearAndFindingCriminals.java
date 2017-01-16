package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BearAndFindingCriminals {
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
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner (System.in); 
		int n = sc.nextInt(); 
		int a = sc.nextInt(); 
		int c [] = new int [n]; 
	 
		int j, i; 
		for (int k = 0; k < c.length; k++) {
			c[k] = sc.nextInt(); 
		}
		int sum = c[a-1];
		for (i = a-2, j = a; i >=0 && j < c.length; i--, j++) {
			//System.out.println(c[i] + " " + c[j]);
			if (c[i] == 1 && c[j] == 1) {
				sum+=2; 
			}
		}
		for(; j < c.length; j++)
			sum += c[j]; 
		
		for (; i >= 0; i-- )
			sum += c[i]; 
		
		System.out.println(sum);
	}
}
