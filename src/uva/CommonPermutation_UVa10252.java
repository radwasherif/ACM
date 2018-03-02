package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CommonPermutation_UVa10252 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int c = 1; 
//		while(c-- > 0) {
		while(sc.ready()) {
			char [] a = sc.nextLine().toCharArray(); 
			char [] b = sc.nextLine().toCharArray(); 
			int count [] = new int[26]; 
			for(int i = 0; i < 26; i++) {
				count[i] = Math.min(countOcc(a, (char) ('a' + i)), countOcc(b, (char) ('a' + i))); 
			}
			StringBuilder sb = new StringBuilder(); 

			for(int i = 0; i < 26; i++) {
				while(count[i]-- > 0)
					sb.append((char)(i + 'a'));
			}
			out.println(sb);
		}
		out.flush();
		out.close();
	}
	
	static int countOcc(char s [], char c) {
		int ans = 0; 
		for(int i = 0; i < s.length; i++)
			if(c == s[i])
				ans++; 
		
		return ans;
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
