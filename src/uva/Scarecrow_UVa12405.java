package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Scarecrow_UVa12405 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = sc.nextInt();
		int t = 1;
		while (T-- > 0) {
			int n = sc.nextInt();
			char c[] = sc.next().toCharArray();
			int ans = 0; 
			for(int i = 0; i < c.length; i++) {
				if(c[i] == '.') {
					ans++; 
					i+=2; 
				}
			}
			out.printf("Case %d: %d\n", t++, ans);
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
