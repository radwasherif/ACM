package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TextDocumentAnalysis {
	static String s;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		s = sc.next();
		int len = 0;
		int maxLen = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isAlphabetic(s.charAt(i)))
				len++;
			else {
				maxLen = Math.max(maxLen, len);
				len = 0;
			}
			if (s.charAt(i) == '(') {
				i = paren(i);
				len = 0; 
				maxLen = Math.max(len, maxLen); 
			}
		}
//		System.out.println(len);
		maxLen = Math.max(maxLen, len); 
		System.out.println(maxLen + " " + wordInside);

	}

	static int wordInside;

	static int paren(int n) {
		boolean word = false;
//		System.out.println(n);
		for (int i = n;; i++) {
			if (s.charAt(i) == ')') {
				if (word)
					wordInside++;
//				System.out.println(i + " " + wordInside);
				return i;
			}
			if (Character.isAlphabetic(s.charAt(i)))
				word = true;
			if (s.charAt(i) == '_' && word) {

				wordInside++;
//				System.out.println(i + " " + wordInside);
				word = false;
			} else if (s.charAt(i) == '_')
				word = false;

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
