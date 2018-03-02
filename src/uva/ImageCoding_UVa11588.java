package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ImageCoding_UVa11588 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in); 
		PrintWriter out = new PrintWriter(System.out); 
		int X = sc.nextInt(); 
		int t = 1; 
		while(X-- > 0 ) {
			int r = sc.nextInt(); 
			int c = sc.nextInt(); 
			int m = sc.nextInt(); 
			int n = sc.nextInt(); 
			
			int count [] = new int ['Z' - 'A' + 1]; 
			
			while(r-- > 0) {
				char s [] = sc.next().toCharArray(); 
				for(int i = 0; i < c; i++) {
					count[s[i] - 'A']++; 
				}
			}
			
			Arrays.sort(count);
			int max = count[count.length - 1]; 
			int ans = 0; 
			for(int i = 0; i < count.length; i++) {
				if(count[i] == max) {
					ans += count[i]*m; 
				} else {
					ans += count[i]*n; 
				}
			}
			
			
			
			
			out.printf("Case %d: %d\n", t++, ans);
		}
		
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
		
		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next()); 
		}
		
	}
}
