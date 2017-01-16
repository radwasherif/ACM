package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Passwords {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt(); 
		int k = sc.nextInt(); 
		String [] p = new String[n];
		for (int i = 0; i < p.length; i++) {
			p[i] = sc.next(); 
		}
		String correct = sc.next(); 
		int len = correct.length();
		int less = 0;
		int equal = 0; 
		for (int i = 0; i < p.length; i++) {
			if(p[i].length() < len)
				less++; 
			if(!p[i].equals(correct) && p[i].length() == len)
				equal++; 
		}
		int ans1  = less + (less/k)*5 + 1;
		int ans2 = (less + equal) + (less + equal)/k*5 + 1; 
		System.out.println(ans1 + " " + ans2);
		
	}
	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(System.in));

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
