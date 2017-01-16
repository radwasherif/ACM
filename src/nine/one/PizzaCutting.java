package nine.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PizzaCutting {
	static long seq[];

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n;
		 
		while ((n = sc.nextInt()) >= 0) {
			int counter =1; 
			long value = 1; 
			while(counter <= n) {
				value += counter; 
				//System.out.println(value);
				counter++; 
			}
			System.out.println(value);
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
