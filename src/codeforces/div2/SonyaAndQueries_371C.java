package codeforces.div2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class SonyaAndQueries_371C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		TreeSet<String> ts = new TreeSet<String>();
		TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
		int count[] = new int[(1 << 18) + 1];
		while (t-- > 0) {
			String s = sc.next();
			String n = sc.next();
			int val = 0;
			if (s.equals("+")) {
				int k = getParity(n);
				count[k]++;

			} else if (s.equals("-")) {
				int k = getParity(n);
				count[k]--;
			} else {
				int k = getParity(n);
				sb.append(count[k] + "\n");

				// System.out.println(Arrays.toString(even));
				// System.out.println(Arrays.toString(odd));
			}

		}
		System.out.print(sb);
	}

	static int getParity(String s) {
		int ans = 0;
		for (int i = 0; i <= s.length() - 1; i++) {
			if ((s.charAt(s.length() - 1 - i) - '0') % 2 != 0) {
				ans |= (1 << i);
			}

		}
		return ans;
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		Scanner(FileReader r) {
			br = new BufferedReader(r);

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
