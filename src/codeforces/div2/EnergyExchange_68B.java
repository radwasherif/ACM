package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class EnergyExchange_68B {
	static double k;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		k = sc.nextInt() * 1.0 / 100;
//		System.out.println( 1 + (11 - 1.9) * (1 - 0.9) < 1.9);
		int a[] = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		double low = 0.0;
		double high = a[a.length - 1];
		double mid = (high + low) / 2;
//		System.out.println(verify(a, 1.9));
		while (high - low >= 10e-12) {
			mid = (high + low) / 2;

			if (verify(a, mid)) {
//				System.out.println(mid);
				low = mid + 10e-12;
			} else {
				high = mid - 10e-12;
			}
		}
		System.out.println(mid);
	}

	static boolean verify(int a[], double max) {
		double acc = 0.0;
		for (int i = a.length - 1; i >= 0; i--) {
			if (a[i] > max) {
				acc += ((a[i] - max) * (1 - k));
//				System.out.println(acc);
			} else if (a[i] + acc < max) {
				return false;
			} else {
				acc -= (max - a[i]);
			}
			if (acc < 0.0)
				return false;
		}
		return true;
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
