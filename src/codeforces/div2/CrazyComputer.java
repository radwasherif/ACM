package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CrazyComputer {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt(); 
		int c = sc.nextInt(); 
		int a; 
		int b = 0; 
		int ans = 0; 
		a = sc.nextInt(); 
		if(n == 1) {
			System.out.println(1);
			return; 
		}
		ans = 1; 
		for(int i = 1; i < n; i++) {
			b = sc.nextInt(); 
			if(b - a > c)
				ans = 0; 
			else
				ans++; 
			a = b; 
		}
		if(b - a <= c)
			ans++; 
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
	}
}