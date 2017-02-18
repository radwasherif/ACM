package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PowerCrisis_UVa151 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n;
		while ((n = sc.nextInt()) != 0) {
			int m;
			for (m = 1; m <= n; m++) {
//				System.out.println("m = " + m);
				boolean off[] = new boolean[n + 1];

				int i = 1;
				int countOn = n;
				while (countOn > 0) {
					off[i] = true;
					countOn--;
					if (countOn == 0)
						break;
					int diff = m;
					int initi = i; 
					while (diff > 0) {
						i++; 
						if (i > n)
							i = 1;
						if(!off[i])
							diff--; 
//						System.out.println(i);
					}
					
				}
				if(i == 13)
					break; 
			}
			out.println(m);
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

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

		boolean ready() throws IOException {
			return br.ready();
		}

	}
}
