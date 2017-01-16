package codeforces.div2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class EasyArith {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(new FileReader("easy.in"));
//		PrintWriter out = new PrintWriter(new FileWriter("easy.out"));
		Scanner sc = new Scanner(System.in); 
		PrintWriter out = new PrintWriter(System.out); 
		String s = sc.next();
		char sign = ' ';
		String ans = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '+' || s.charAt(i) == '-') {
				ans += s.charAt(i);
				sign = s.charAt(i);
				continue;
			} else {
				ans += s.charAt(i++);
				while (sign == '-' && i < s.length() && Character.isDigit(s.charAt(i))) {
					ans += '+' + "" + s.charAt(i);
					i++;
				}
				while (sign == '+' && i < s.length() && Character.isDigit(s.charAt(i))) {
					ans += s.charAt(i);
					i++;
				}
				i--;
			}
		}
		out.println(ans);
		out.flush();
		out.close();
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(FileReader r) {
			br = new BufferedReader(r);
		}

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

	}
}
