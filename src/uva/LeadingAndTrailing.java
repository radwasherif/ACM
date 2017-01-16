package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LeadingAndTrailing {
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
		int t = sc.nextInt(); 
		int n, k; 
		while(t-->0) {
			n = sc.nextInt(); 
			k = sc.nextInt(); 
			int tr = bigMod(n, k, 1000); 
			double x = k*Math.log10(n); 
			//System.out.println(x);
			x -= (int)x; 
			//System.out.println(x);
			double le = Math.pow(10, x)*100;
			int lead = (int) (le); 
			System.out.printf("%03d...%03d\n", lead, tr);
			
		}
		
	}
	static int bigMod(int a, int e, int mod) {
		a %= mod;
		int res = 1;
		while (e > 0) {
			if ((e & 1) == 1) {
				res = (res % mod * a % mod) % mod;
			}
			a = (a % mod * a % mod) % mod;
			e >>= 1;
		}
		return res;
	}
}
