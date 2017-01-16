package contest.orange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class GPA {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in); 
		int n; 
		ArrayList<Double> p[] = new ArrayList[3001]; 
		for (int i = 0; i < p.length; i++) {
			p[i] = new ArrayList<Double>(); 
		}
		boolean y[] = new boolean[3001]; 
		
		n = sc.nextInt(); 
		while(n -- > 0) {
			int year = sc.nextInt();
			int m = sc.nextInt(); 
			y[year] = true; 
			
			for(int i = 0; i < m; i++) {
				p[year].add(sc.nextDouble());   
			}
			
			
		}
		
		n = sc.nextInt(); 
		while(n -- > 0) {
			int year = sc.nextInt();
			int m = sc.nextInt(); 
			y[year] = true; 
			for(int i = 0; i < m; i++) {
				p[year].add(sc.nextDouble());  
			}	
		}
		
		n = sc.nextInt(); 
		while(n -- > 0) {
			int year = sc.nextInt();
			int m = sc.nextInt(); 
			y[year] = true; 
			for(int i = 0; i < m; i++) {
				p[year].add(sc.nextDouble());  
			}	
		}
		for (int i = 0; i < p.length; i++) {
			if(!p[i].isEmpty()) {
				double sum = 0.0; 
				for(double j : p[i])
					sum += j; 
				
				System.out.println(i + " " + sum/(p[i].size()*1.0));
				
			}
		}
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
		public double nextDouble() throws NumberFormatException, IOException {
			return Double.parseDouble(next()); 
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}
}
