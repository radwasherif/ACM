package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AlternatingStrings {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			int k = sc.nextInt();
			char s[] = new char[N];
			s = sc.next().toCharArray();
			int dp[] = new int[N];
			for (int i = 0; i < s.length - 1; i++) {
				boolean alt = true; 
				for(int j = i; j < s.length && i - j + 1 <= k; j++ ) {
					if(j < s.length - 1 && s[j] == s[j + 1])
						alt = false; 
					
				}
			}
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

	}
}
