package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KalevitchAndChess {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		char a[][] = new char[8][8];
		int cRows = 0, cCol = 0;
		for (int i = 0; i < 8; i++) {
			String s = sc.next();
			if (s.equals("BBBBBBBB"))
				cRows++;
			for (int j = 0; j < 8; j++) {
				a[i][j] = s.charAt(j);
			}
		}
		for (int j = 0; j < 8; j++) {
			String s = ""; 
			for (int i = 0; i < 8; i++) {
				s+= a[i][j]; 
			}
			if(s.equals("BBBBBBBB"))
				cCol++; 
		}
		int ans; 
		if(cCol == 8 && cRows == 8)
			ans = 8; 
		else 
			ans = cRows + cCol; 
		System.out.println(ans);
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
