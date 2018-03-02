package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FerryLoadingII_UVa10440 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out); 
		int c = sc.nextInt();
		while (c-- > 0) {
			int n = sc.nextInt();
			int t = sc.nextInt();
			int m = sc.nextInt();


			int curTime = 0;
			int trips = 0; 
			for(int i = 0; i < m; i++) {
				curTime = Math.max(curTime, sc.nextInt()); 
				if((m - i) % n == 0) {
					curTime += 2 * t; 
					trips++; 
				}
			}
			out.println(curTime + " " + trips);
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
			while (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		boolean ready() throws IOException {
			return br.ready();
		}
	}
}
