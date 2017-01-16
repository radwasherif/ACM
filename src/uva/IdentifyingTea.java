package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IdentifyingTea {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder(); 
		int c = 2; 
//		while(c-- > 0) {
		while(br.ready()) {
			String t = br.readLine(); 
			int ans = 0; 
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			for (int i = 0; i < 5; i++) {
				if( t.equals(st.nextToken()))
					ans++; 
				
			}
			sb.append(ans + "\n"); 
		}
		System.out.print(sb);
	}
}
