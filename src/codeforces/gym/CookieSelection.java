package codeforces.gym;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CookieSelection {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		int count = 8; 
		while (sc.ready()) {
//		while(count-- > 0) {
			String s = sc.next();
			if (s.equals("#")) {
				int i;
				if (list.size() % 2 == 1) {
					i = (list.size() + 1) / 2 -1;
				} else {
					i = list.size() / 2;
				}
				sb.append(list.get(i) + "\n"); 
				list.remove(i); 
			} else 
				list.add(s); 
		}
		System.out.print(sb);
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

		boolean ready() throws IOException {
			return br.ready();
		}

	}
}
