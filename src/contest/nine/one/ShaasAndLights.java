package contest.nine.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class ShaasAndLights {
	static final int mod = ((int) 1e9 + 7);

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[m + 1];
		fac(n);
		ArrayList<Integer> segments = new ArrayList<Integer>();
		for (int i = 1; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		int pow = 0; 
		for (int i = 1; i < a.length - 1; i++) {
			segments.add(a[i + 1] - a[i] - 1);
			pow += a[i + 1] - a[i] - 2; 
		}
//		System.out.println(Arrays.toString(a));
		int left = 0, right = 0;
		if (a[1] != 1)
			left = a[1] - 1;
		if (a[m] != n)
			right = n - a[m];

		long ans = fac[n - m];
		//System.out.println(pow);
		long ans2 = bigMod(2, pow, mod); 
		
		long den = mul(fac[left], fac[right]);
		for (int i : segments) {
//			System.out.println(i);
			den = mul(den, fac[i]);
			
		}
//		System.out.println(den);
		long denInv = modInverse(den); 
		System.out.println(denInv);
		ans = mul(ans, mul(denInv, ans2));

		System.out.println(ans);
	}

	static long fac[];

	static void fac(int n) {
		fac = new long[n + 1];
		fac[0] = 1;
		fac[1] = 1;
		for (int i = 2; i < n; i++) {
			fac[i] = mul(i, fac[i - 1]);
			// System.out.println(fac[i]);
		}
	}

	static long mul(long a, long b) {
		return (a % mod * b % mod) % mod;
	}
	static long modInverse(long n) {
		for(long i = 0; i <= n; i++) {
			if(mul(i, n) == 1)
				return i; 
		}
		return -1; 
	}
	static long bigMod(long a, long e, int mod) {
		// System.out.println(a);
		a %= mod;
		long res = 1;
		while (e > 0) {
			if ((e & 1) == 1) {
				res = (res * a) % mod;
			}
			a =  (a * a) % mod;
			e >>= 1;
			//System.out.println(a);
		}
		return res;
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {

			br = new BufferedReader(new InputStreamReader(s));

		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}
}
