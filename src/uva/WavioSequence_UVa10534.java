package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

class WavioSequence_UVa10534 {
	static int[] left, right;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		// int c = 3;
		while (sc.ready()) {
			// while (c-- > 0) {
			int n = sc.nextInt();
			int a[] = new int[n];
			left = new int[n];
			right = new int[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = sc.nextInt();
			}
			lis1(a);
			lis2(a);
			int ans = -1;
			for (int i = 0; i < n; i++) {
				ans = Math.max(ans, 2 * Math.min(left[i], right[i]) + 1);
			}
			out.println(ans);
		}

		out.flush();
		out.close();
	}

	static Stack<Integer> sol1, sol2;

	public static int lis1(int A[]) {
		ArrayList<Integer> tails = new ArrayList<>(); // stores last elements in
														// every "active list"
														// we keep track of
		int lis = 0, lis_end = 0;
		int L_to_A[] = new int[A.length]; // maps each index in L to an index in
											// A
		int p[] = new int[A.length]; // stores the index of the parent of each
										// element in a LIS
		for (int i = 0; i < A.length; i++) {
			int pos = Collections.binarySearch(tails, A[i]); // finds the
																// position of
																// current
																// elements
																// among the
																// tails
			if (pos < 0)
				pos = -(pos + 1); // if it is not in the list, find its supposed
									// position
			if (pos >= tails.size()) { // it's larger than all tails
				tails.add(A[i]); // then we extend an existing active list with
									// this number
				lis++;
				lis_end = i;
			} else { // it's in between
				tails.set(pos, A[i]); // replace
			}
			L_to_A[pos] = i;
			p[i] = (pos > 0) ? L_to_A[pos - 1] : -1;
			left[i] = pos;
		}

		return lis;
	}

	public static int lis2(int A[]) {
		ArrayList<Integer> tails = new ArrayList<>(); // stores last elements in
														// every "active list"
														// we keep track of
		int lis = 0, lis_end = 0;
		int L_to_A[] = new int[A.length]; // maps each index in L to an index in
											// A
		int p[] = new int[A.length]; // stores the index of the parent of each
										// element in a LIS
		for (int i = A.length - 1; i >= 0; i--) {
			int pos = Collections.binarySearch(tails, A[i]); // finds the
																// position of
																// current
																// elements
																// among the
																// tails
			if (pos < 0)
				pos = -(pos + 1); // if it is not in the list, find its supposed
									// position
			if (pos >= tails.size()) { // it's larger than all tails
				tails.add(A[i]); // then we extend an existing active list with
									// this number
				lis++;
				lis_end = i;
			} else { // it's in between
				tails.set(pos, A[i]); // replace
			}
			L_to_A[pos] = i;
			p[i] = (pos > 0) ? L_to_A[pos - 1] : -1;
			right[i] = pos;
		}

		return lis;
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
