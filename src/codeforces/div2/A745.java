package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class A745 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in); 
		int ans = 0; 
		TreeSet<String> ts = new TreeSet<>(); 
		String s = sc.next(); 
		ts.add(s); 
		for(int i = 0; i < s.length(); i++) {
			s = s.charAt(s.length()-1) + "" + s.substring(0, s.length() - 1); 
			ts.add(s); 
		}
		System.out.println(ts.size());
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
