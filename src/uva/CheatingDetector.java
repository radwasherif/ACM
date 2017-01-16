package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CheatingDetector {
	static int leakedCorrect[];
	static int notLeakedInCorrect[];

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			leakedCorrect = new int[11];
			notLeakedInCorrect = new int[11];
			int q = Integer.parseInt(bf.readLine());
			while (q-- > 0) {
				st = new StringTokenizer(bf.readLine());
				int d = Integer.parseInt(st.nextToken());
				int leak = Integer.parseInt(st.nextToken());
				String corr = st.nextToken();
				if (leak == 0 && corr.equals("i"))
					notLeakedInCorrect[d]++;
				if (leak == 1 && corr.equals("c"))
					leakedCorrect[d]++;
			}
			int ans = 0;
			for (int i = 1; i < notLeakedInCorrect.length; i++) {
				for (int j = i + 1; j < leakedCorrect.length; j++) {
					ans += notLeakedInCorrect[i] * leakedCorrect[j];
				}
			}
			sb.append(ans);
			sb.append('\n');
		}
		System.out.print(sb);
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		public Scanner(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}
	}
}
