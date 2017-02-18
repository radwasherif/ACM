package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IlyaAndTicTacToeGame_754B {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		char c [] [] = new char [4][4]; 
		boolean yes = false; 
		for (int i = 0; i < 4; i++) {
			String s = sc.nextLine();
			if(s.contains("x.x") || s.contains("xx.") || s.contains(".xx"))
			{
				yes = true; 
			}
			for (int j = 0; j < 4; j++) {
				c[i][j] = s.charAt(j); 
			}
		}
		if(yes)
		{
			System.out.println("YES");
			return; 
		}
		for(int d =-1; d <= 4; d++) {
			String s = ""; 
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					
					if(d <= 1 && (j - i) == d) {
//						System.out.println(i + " " + j);
						s += c[i][j]; 
					} else if( d > 1 && (j + i) == d)
							s+= c[i][j]; 
				}
			}
			if(s.contains("x.x") || s.contains("xx.") || s.contains(".xx"))
			{
				System.out.println("YES");
				return; 
			}
		}
		for(int j = 0; j < 4; j++) {
			String s = ""; 
			for(int i = 0; i < 4; i++) {
				s += c[i][j]; 
				
			}
			if(s.contains("x.x") || s.contains("xx.") || s.contains(".xx"))
			{
				System.out.println("YES");
				return; 
			}
		}
		System.out.println("NO");
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
