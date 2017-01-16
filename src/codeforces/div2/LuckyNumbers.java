package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * #104 A
 */

public class LuckyNumbers {
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

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String a = sc.next(); 
		String b = sc.next();
		int seven = 0, four = 0; 
		for (int i = 0; i < a.length(); i++) {
			if(a.charAt(i) != b.charAt(i)) {
				if(a.charAt(i) == '4')
					four++; 
				else 
					seven++; 
			}
		}
		int swaps = Math.min(four, seven); 
		four -= swaps; 
		seven -= swaps;  
		System.out.println(swaps + four + seven);
	}
}
