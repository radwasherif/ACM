package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AtMostTwice {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int c = 4;
		while (c-- > 0) {
			char s[] = sc.next().toCharArray();
			int count[] = new int[10];
			for (int i = 0; i < s.length; i++) {
				int a = s[i] - '0';
				if (count[a] == 2) {
					while (true) {
						boolean found = false;
						for (int j = a - 1; j >= 0; j--) {
							if (count[j] < 2) {
								s[i] = (char) (j + '0');
								count[a]--;
								count[j + '0']++;
								found = true;
								break;
							}
						}
						if (found) {
							for (int j = i + 1; j < s.length; j++) {
								for (int k = 9; k >= 0; k--) {
									if (count[k] < 2) {
										s[j] = (char) (k + '0');
										count[k + '0']++;
										break;
									}
								}
							}
							break;
						}
						if (i > 0)
							a = s[--i] - '0';
						// count[a]--;
					}
					break;
				}
				count[a]++;
			}
			out.println(Long.parseLong(new String(s)));
		}
		out.flush();
		out.close();

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

		long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}

	}
}
