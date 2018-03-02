package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF938B {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i = 0; i < n; i++)
			a[i] = sc.nextInt(); 
		
		int l[] = new int[n];
		int cur = (int) 1e6;
		for (int i = n - 1; i >= 0; i--) {
			l[i] = cur - a[i];
			
		}
//		System.out.println(Arrays.toString(l));
//		System.out.println(Arrays.toString(a));

		int max = 0;
		for (int i = 0; i < a.length; i++) {
			a[i] = Math.min(a[i] - 1, l[i]);
			max = Math.max(max, a[i]);
		}

		System.out.println(max);
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
