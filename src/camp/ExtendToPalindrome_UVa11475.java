package camp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ExtendToPalindrome_UVa11475 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		while (sc.ready()) {
			String s = sc.next();
			String r = rev(s);
			String s2 = r + "#" + s;
			// System.out.println(s2);
			int pi[] = kmp(s2.toCharArray());
			// System.out.println(Arrays.toString(pi));
			int i = pi[pi.length - 1];
			out.println(s + r.substring(i));

		}
		out.close();

	}

	static String rev(String s) {
		String ans = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			ans += s.charAt(i);
		}
		return ans;
	}

	static int[] kmp(char s[]) {
		int pi[] = new int[s.length];
		for (int i = 1, j = 0; i < s.length; i++) {
			while (j > 0 && s[i] != s[j])
				j = pi[j - 1];
			if (s[i] == s[j])
				j++;
			pi[i] = j;
		}
		return pi;
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

		boolean ready() throws IOException {
			return br.ready();
		}
	}
}
