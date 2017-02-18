package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CountOnCantor_UVa264 {
	static final int limit = (int) 1e7 + 1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out); 
		int num[] = new int[limit];
		int den[] = new int[limit];

		int di = -1;
		int dj = 1;
		for (int k = 1, i = 1, j = 1; k < limit; k++) {
			num[k] = i;
			den[k] = j;
			i += di;
			j += dj;
			if (i < 1) {
				i = 1;
				di *= -1;
				dj *= -1;
			}
			if (j < 1) {
				j = 1;
				di *= -1;
				dj *= -1;

			}
		}
		
		while(sc.ready()) 
		{
			int n = sc.nextInt();
			out.printf("TERM %d IS %d/%d\n",n, num[n], den[n]); 
		}
		
		out.flush();
		out.close(); 
		
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		boolean ready() throws IOException {
			return br.ready();
		}

	}
}
