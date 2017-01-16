package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DAsInDaelus {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		int c[] = { 10000, 1000, 100, 10, 1 };
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int count = 2;
//		while (count-- > 0) {
		while(sc.ready()) {
		int n = sc.nextInt();
			int m = sc.nextInt();
			int b = 0;
			int d;
			int or = 0;
			int ans = 0;
			for (int i = 0; i < m; i++) {
				b = sc.nextInt();
				d = sc.nextInt();
				
				int sum = 0;
				for (int j = 0; j < n - 1; j++)
					sum += sc.nextInt();
				if(sum + d<= b)
					or += d; 
				for (int j = 0; j < c.length; j++) {
					if (sum + c[j] <= b) {
						ans += c[j];
						break;
					}
				}
			}
			sb.append((ans - or) + "\n");
		}
		System.out.print(sb);
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
		boolean ready() throws IOException {
			return br.ready(); 
		}

	}
}
