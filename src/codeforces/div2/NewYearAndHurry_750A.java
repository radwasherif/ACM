package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NewYearAndHurry_750A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in); 
		int x = sc.nextInt(); 
		int y = 240 - sc.nextInt(); 
		int ans = 0; 
		for(int i = 1; i <= x; i++) {
			y -= 5*i; 
			ans++; 
			if(y < 0) {
				ans--; 
				break; 
			}
		}
		System.out.println(ans);
		
	}
	public static class Scanner {
		BufferedReader bf;
		StringTokenizer st;

		Scanner(InputStream s) {
			bf = new BufferedReader(new InputStreamReader(s));

		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(bf.readLine());
			return st.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}
	}
}
