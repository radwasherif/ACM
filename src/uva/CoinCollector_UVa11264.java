package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CoinCollector_UVa11264 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			long a[] = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();

			int max = 0; 
			int types = 0; 
			for(int i = 0; i < n - 1; i++) {
				if(max + a[i] < a[i + 1]) {
					max += a[i];
					types++; 
				}
			}	
			 
			out.println(types + 1);
		}
		out.flush();

	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}

			return st.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}
	}
}
