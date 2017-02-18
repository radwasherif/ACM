package camp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EasyNumberChallenge {
	static final int mod = 1073741824;
	static int numDiv[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int ans = 0;
		sieve(a * b * c);
		for (int i = 1; i <= a; i++) {
			for (int j = 1; j <= b; j++) {
				for (int k = 1; k <= c; k++) {
					ans = (ans + numDiv[i * j * k]) % mod;
				}
			}
		}
		System.out.println(ans);
	}

	static void sieve(int n) {

		numDiv = new int[n + 1];
		Arrays.fill(numDiv, 1);
		numDiv[0] = 0;

		for (int i = 2; i <= n; i++) {
			if (numDiv[i] == 1) {
				numDiv[i] = 2; 
				for (int j = i * 2; j <= n; j += i) {
					numDiv[j] = (numDiv[j] * (count(i, j) + 1)) % mod;
				}
			}

		}
	}

	static int count(int i, int j) {
		int ans = 0;
		while (j % i == 0) {
			ans++;
			j /= i;
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

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

	}
}
