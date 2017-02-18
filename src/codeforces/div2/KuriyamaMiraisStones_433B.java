package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class KuriyamaMiraisStones_433B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt(); 
		Long a [] = new Long[n]; 
		for (int i = 0; i < a.length; i++) {
			a[i] = (long) sc.nextInt(); 
		}
		Long s [] = a.clone(); 
		Arrays.sort(s);
		for(int i = 1; i < s.length; i++) {
			s[i] = s[i - 1] + s[i]; 
			a[i] = a[i - 1] + a[i]; 
		}
		int m = sc.nextInt(); 
		PrintWriter out = new PrintWriter(System.out); 
		while(m-- > 0) {
			int t = sc.nextInt(); 
			int l = sc.nextInt() - 1; 
			int r = sc.nextInt() - 1; 
			long ans = 0; 
			if(t == 1) {
				ans = a[r] - (l > 0 ? a[l -1]:0); 
			} else if (t == 2) {
				ans = s[r] - (l > 0 ? s[l -1]:0);
			}
			out.println(ans);
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
