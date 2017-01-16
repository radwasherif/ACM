package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B745 {
	private void main() throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt(); 
		int m = sc.nextInt(); 
		int countX = 0; 
		int imax, jmax, imin, jmin; 
		imax = jmax = -1; 
		imin = jmin = 1000000000; 
		
		for(int i = 0; i < n; i++) {
			String s = sc.next(); 
			for(int j = 0; j < m; j++) {
				if(s.charAt(j) == 'X') {
					countX++; 
					imax = Math.max(imax, i); 
					jmax = Math.max(jmax, j); 
					imin = Math.min(imin, i); 
					jmin = Math.min(jmin, j); 
				}
			}
		}
		if((Math.abs(imin - imax ) + 1) * (Math.abs(jmin - jmax) + 1) == countX)
			System.out.println("YES");
		else 
			System.out.println("NO");
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
