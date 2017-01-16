package contest.nine.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class HowManyTrees {
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

	static BigInteger cat [];
	static BigInteger one = new BigInteger("1");
	static BigInteger two = new BigInteger("2"); 

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder(); 
		cat(1000); 
		//int c = 3; 
		while(sc.ready())
		  //while (c-- >0) 
		{
			int n = sc.nextInt(); 
			System.out.println(cat[n]); 
		}
	}

	static void cat(int N) {
		cat = new BigInteger[N + 1];
		cat[0] = new BigInteger("1");
		for (int i = 1; i < cat.length; i++) {
			BigInteger I = new BigInteger(i + ""); 
			cat[i] = two.multiply(I).multiply(two.multiply(I).subtract(one)).multiply(cat[i-1]).divide(I.multiply(I.add(one)));
		}
	}
}
