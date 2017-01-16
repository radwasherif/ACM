package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BB {
	static char[] s;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		s = sc.next().toCharArray();

		Math.round(n); 
	}

	static int ans(boolean red) {
		char a;
		if (red)
			a = 'r';
		else
			a = 'b';
		int mb = 0, mr = 0;
		for (int i = 0; i < s.length; i++) {
//			System.out.print(a);
			if (s[i] == 'b' && s[i] != a)
				mb++;
			else if (s[i] == 'r' && s[i] != a)
				mr++;
			if (a == 'r')
				a = 'b';
			else
				a = 'r';

		}
//		System.out.println(mb + " " + mr);
		int ans = Math.min(mr, mb) + (Math.max(mr, mb) - Math.min(mr, mb)); 
//		System.out.println();
		return ans; 
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		boolean ready() throws IOException {
			return br.ready();
		}

	}
}
