package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class EquidistantString_545B {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String  s = sc.next(); 
		String t = sc.next(); 
//		ArrayList<Integer> diff = new ArrayList<>(); 
		StringBuilder sb = new StringBuilder();  
		int c = 0; 
		String ans = ""; 
		boolean f = false; 
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == t.charAt(i)) {
				sb.append(s.charAt(i));
			} else {
				c++; 
				if(f) {
					sb.append(t.charAt(i));
				} else {
					sb.append(s.charAt(i));
				}
				f = !f; 
			}
			
		}
		
		if(c % 2 == 1)
		{
			System.out.println("impossible");  
		} else {
			System.out.println(sb);
		}
		
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
