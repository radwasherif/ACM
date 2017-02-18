package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LittlePigsAndWolves_116B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		char a[][] = new char[n][m];
		for (int i = 0; i < a.length; i++) {
			String s = sc.next();
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = s.charAt(j);
			}
		}
		int ans = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] == 'P') {
					if (i > 0) {
						if (a[i - 1][j] == 'W') {
							ans++;
							a[i][j] = a[i - 1][j] = '.';
							continue; 
						}
					} 
					if(i < a.length -1) {
						if(a[i + 1][j] == 'W')
						{
							ans++; 
							a[i + 1][j] = a[i][j] = '.';  
							continue; 
						}
					}
					if(j > 0) {
						if(a[i][j - 1] == 'W') {
							ans++; 
							a[i][j - 1] = a[i][j] = '.'; 
							continue; 
						}
					}
					if(j < a[i].length - 1) {
						if(a[i][j + 1] == 'W') {
							ans++; 
							a[i][j + 1] = a[i][j] = '.'; 
							continue; 
						}
					}
				}
			}
		}
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

	}
}
