package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF335A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		char s[] = sc.next().toCharArray();
		int n = sc.nextInt();
		int f[] = new int[26];
		boolean found = false;
		for (int i = 0; i < s.length; i++)
			f[s[i] - 'a']++;
		for (int k = 1; k <= s.length; k++) {
			int ans = sum(f, k);

			if (ans <= n) {
				found = true;
				System.out.println(k);
				int len = 0;
				for (int i = 0; i < 26; i++) {
					int rep = (int) Math.ceil(f[i] * 1.0 / k);
					while (rep-- > 0) {
						System.out.print((char) (i + 'a'));
						len++;
					}
				}
				while (len < n) {
					System.out.print('a');
					len++;
				}
				break;
			}
		}
		System.out.println(!found ? -1 : "");
	}

	static int sum(int f[], int k) {
		int ans = 0;
		for (int i = 0; i < f.length; i++) {
			ans += (int) Math.ceil(f[i] * 1.0 / k);
		}
		return ans;
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
