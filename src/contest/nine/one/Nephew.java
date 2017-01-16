package contest.nine.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Nephew {
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
		Scanner sc = new Scanner(System.in); 
		int a, b, c, d, e; 
		while(true) {
			a = sc.nextInt(); b = sc.nextInt(); c = sc.nextInt(); d = sc.nextInt(); e = sc.nextInt(); 
			if( a == 0 && b == 0 && c ==0 && d ==0 && e == 0) 
				break; 
			System.out.println(a*b*c*d*d*e*e);
		}
	}
}
