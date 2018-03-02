package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CF938A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt();
		char c[] = sc.nextLine().toCharArray();

		ArrayList<Character> s = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			s.add(c[i]);
			
		}
		boolean done = false;
		while (!done) {
			done = true;
			for (int i = 1; i < s.size(); i++) {
				if (vowel(s.get(i)) && vowel(s.get(i - 1))) {
					s.remove(i);
					done = false;
				}
			}
		}
		for (char cc : s) {
			out.print(cc);
		}
		out.println();
		out.flush();
		out.close();
	}

	static boolean vowel(char c) {
		char v[] = { 'a', 'e', 'i', 'o', 'u', 'y' };
		for (int i = 0; i < v.length; i++) {
			if (v[i] == c)
				return true;
		}
		return false;
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
