package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PetyaAndCountryside {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		int max = 1;
		for (int i = 0; i < n; i++) {
			int count = 1;
			int maxH = a[i];
			for (int j = i + 1; j < n; j++) {
//				System.out.println(i + " " + j + " " + maxH);
				if (a[j] < maxH)
					maxH = a[j];
				if (a[j] <= maxH) {
					count++;
//					System.out.println("count " + count);
				} else
					break;
			}
			maxH = a[i];
			for (int j = i - 1; j >= 0; j--) {
//				System.out.println(i + " " + j + " " + maxH);
				if (a[j] < maxH)
					maxH = a[j];
				if (a[j] <= maxH) {
					count++;
//					System.out.println("count " + count);
				} else
					break;
			}

			max = Math.max(max, count);
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

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

		boolean ready() throws IOException {
			return br.ready();
		}

	}
}
