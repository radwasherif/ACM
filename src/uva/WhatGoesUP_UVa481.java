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

public class WhatGoesUP_UVa481 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		ArrayList<Integer> a = new ArrayList<>();
		// int c = 6;
		while (sc.ready())
			// while(c-- > 0)
			a.add(sc.nextInt());
		int A[] = new int[a.size()];
		for (int i = 0; i < A.length; i++) {
			A[i] = a.get(i);
		}
		out.println(lis(A));
		out.println("-");
		while (!sol.isEmpty())
			out.println(sol.pop());
		out.flush();
		out.close();

	}

	static Stack<Integer> sol = new Stack<>();

	public static int lis(int A[]) {
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
			// System.out.println(A[i] + " " + pos);
			if (pos >= tails.size()) { // it's larger than all tails
				tails.add(A[i]); // then we extend an existing active list with
									// this number
			} else { // it's in between
				tails.set(pos, A[i]); // replace
				// System.out.println(A[i] + " " + pos);

			}
			if (pos + 1 > lis) {
				lis = pos + 1;
				lis_end = i;
			}
			if (pos + 1 == lis)
				lis_end = i;
			L_to_A[pos] = i;
			p[i] = (pos > 0) ? L_to_A[pos - 1] : -1;
		}

		while (lis_end != -1) {
			sol.push(A[lis_end]);
			lis_end = p[lis_end];
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
