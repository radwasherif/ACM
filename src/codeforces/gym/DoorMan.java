package codeforces.gym;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DoorMan {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt(); 
		String s = sc.next();
		int m = 0, w = 0; 
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'W')
				w++; 
			else 
				m++; 
			if(Math.abs(m - w) == n)
				break; 
		}
		System.out.println(m + w);
	}
	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		boolean ready() throws IOException {
			return br.ready();
		}

	}
}
