package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MemoryAndTrident_712B {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		if (s.length() % 2 == 1) {
			System.out.println(-1);
			return;
		}
		int x = 0;
		int y = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'R')
				x++;
			else if (s.charAt(i) == 'L')
				x--;
			else if (s.charAt(i) == 'U')
				y++;
			else
				y--;
		}
		x = Math.abs(x); 
		y = Math.abs(y); 
		System.out.println((x + y)/2);
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

	}
}
