package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AllInAll_UVa10340 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in); 
		PrintWriter out = new PrintWriter(System.out); 
		int c = 4;
//		while(c-- > 0) {
		while(sc.ready()) {
			char s1[] = sc.next().toCharArray(); 
			char s2[] = sc.next().toCharArray(); 
			
			int idx1 = 0; 
			for(int i = 0; i < s2.length; i++) {
				if(s2[i] == s1[idx1]) {
					idx1++; 
				}
				if(idx1 == s1.length)
					break; 
			}
			
			out.println((idx1 == s1.length)? "Yes":"No");
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
			while(st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			
			return st.nextToken(); 
		}
		
		String nextLine() throws IOException {
			return br.readLine(); 
		}
		
		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next()); 
		}
		
		boolean ready() throws IOException {
			return br.ready(); 
		}
		
	}
}
