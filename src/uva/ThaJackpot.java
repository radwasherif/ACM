package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 10684
 */

public class ThaJackpot {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n;
		while (true) {
			n = sc.nextInt();
			if(n == 0)
				break; 
			int a [] = new int [n]; 
			for (int i = 0; i < a.length; i++) {
				a[i] = sc.nextInt(); 
			}
			int seq = max1D(a); 
			if(seq > 0)
				System.out.println("The maximum winning streak is " + seq + ".");
			else 
				System.out.println("Losing streak.");

		}
	}
	static int max1D( int a []) {
		int sum = 0, max = 0; 
		//int currStart = 0; 
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			if( sum > max) {
				max = sum;  
				//start = currStart; 
			}
			if(sum < 0) {
				sum = 0; 
				//currStart = i+1; 
				
			}
			
		}
		return max; 
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
