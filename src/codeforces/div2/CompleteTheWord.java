package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CompleteTheWord {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		char[] s = sc.next().toCharArray();
		if(s.length < 26) {
			System.out.println(-1);
			return; 
		}
		int alpha[] = new int[26];
		int unk = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i] != '?')
				alpha[s[i] - 'A']++;
			else
				unk++;
		}
		if (unk == 0) {
			boolean all = true;
			for (int i = 0; i < alpha.length; i++) {
				if (alpha[i] == 0)
					all = false;
			}
			if (all) {
				System.out.println(new String(s));
				return;
			} else {
				System.out.println(-1);
			}
		} else {
			int count = 0;
			ArrayList<Character> missing = new ArrayList<>();
			for (int i = 0; i < alpha.length; i++) {
				if (alpha[i] == 0) {
					count++;
					missing.add((char) ('A' + i));
				}
			}
			if (count == 0) {
				System.out.println(new String(s).replace("?", "A"));
			} else if (count > unk) {
				System.out.println(-1);
			} else {
				int i = 0;
				for (int j = 0; j < s.length; j++) {
					if (s[j] == '?') {
						s[j] = missing.get(i);
						if (i < missing.size() - 1)
							i++;
					}
				}
				System.out.println(new String(s));
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
