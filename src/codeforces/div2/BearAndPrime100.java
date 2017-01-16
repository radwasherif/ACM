package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BearAndPrime100 {

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
		boolean av[] = new boolean[101];
		Arrays.fill(av, true);
		for (int i = 2; i <= 100; i++) {
			if (av[i]) {
				System.out.println(i);
				System.out.flush();
			}
			String s = sc.next(); 
			if (s.equals("no")){
				
				setav(i, av); 
			}
		}
		int count = 0; 
		for (int i = 2; i < av.length; i++) {
			if (av[i])
				count++; 
		}
		if (count > 1) 
		{
			System.out.println("composite");
		} else {
			System.out.println("prime");
		}
		System.out.flush();
	} 
	static void setav( int i, boolean [] a) {
		for (int j = 2; j < a.length; j++) {
			if (j % i ==0)
				a[j] = false; 
		}
	}

}
