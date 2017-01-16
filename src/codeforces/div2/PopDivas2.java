package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class PopDivas2 {
	static int N, M;
	static int a[], b[];
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();
		a = new int[N];
		b = new int[M];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < b.length; i++) {
			b[i] = sc.nextInt();
		}
		Arrays.sort(a);
		Arrays.sort(b);
		BigInteger prodA[] = new BigInteger[(1 << N)];
		BigInteger prodB[] = new BigInteger[(1 << M)];
		prodA[0] = new BigInteger("0");
		prodB[0] = new BigInteger("0");
		TreeMap<BigInteger, Integer> tm = new TreeMap<BigInteger, Integer>(); 
		for (int i = 1; i < (1 << N); i++) {
			prodA[i] = product(i, true);
			
		}
		for (int i = 1; i < (1 << M); i++) {
			prodB[i] = product(i, false);
			tm.put(prodB[i], i);
		}
//		System.out.println(Arrays.toString(prodA));
//		System.out.println(Arrays.toString(prodB));
		Arrays.sort(prodB);
		for (int i = 1; i < (1 << N); i++) {
			int idx = Arrays.binarySearch(prodB, prodA[i]);
			if (idx > 0 && i < prodB.length && prodA[i].equals(prodB[idx])) {
				idx = tm.get(prodB[idx]); 
				sb.append("Y\n" + Integer.bitCount(i) + " " + Integer.bitCount(idx) + "\n"); 
				getVals(i, true);
				getVals(idx, false);
				System.out.print(sb);
				return; 
			}
		}
		System.out.println("N");

	}
	static class Pair implements Comparable<Pair> {
		int idx;
		BigInteger prod; 
		Pair(int i, BigInteger p) {
			idx = i; 
			prod = p; 
		}
		@Override
		public int compareTo(Pair o) {
			return prod.compareTo(o.prod); 
		}
		
		
	}
	static void getVals(int msk, boolean A) {
		int arr[] = A ? a : b;
		int max = A ? N : M;
		boolean first = true;
//		System.out.println("mask " + Integer.toBinaryString(msk));
		for (int i = 0; i < max; i++) {
			if ((msk & (1 << i)) != 0) {
//				System.out.println("hi " + i + " " + arr[i]);
				if (!first)
					sb.append(" ");
				sb.append(arr[i]);
				if (first)
					first = false;

			}
		}
		sb.append("\n");
	}

	static BigInteger product(int msk, boolean A) {

		BigInteger ans = new BigInteger("1");
		int max = A ? N : M;
		int arr[] = A ? a : b;
		for (int i = 0; i < max; i++) {
			if ((msk & (1 << i)) != 0) {
				ans = ans.multiply(new BigInteger(arr[i] + ""));
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
