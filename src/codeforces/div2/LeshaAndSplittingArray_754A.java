package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LeshaAndSplittingArray_754A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int k = sc.nextInt();
		int a[] = new int[k];
		int sum = 0;
		int nonzero = 0;
		for (int i = 0; i < k; i++) {
			a[i] = sc.nextInt();
			if (a[i] != 0)
				nonzero++;
			sum += a[i];
			if (i > 0)
				a[i] += a[i - 1];

		}
//		System.out.println(sum);
		int split = -1;
		for (int i = 0; i < a.length; i++) {
			if (sum - a[i] != 0) {
				split = i + 1;
				break;
			}

		}
		if (sum != 0) {
			out.println("YES\n1");
			out.println(1 + " " + k);
		} else if(nonzero > 0) {
			out.println("YES\n2");
			out.println(1 + " " + split);
			out.println(split + 1 + " " + k);
		} else {
			out.println("NO");
		}
		out.flush();
		out.close();

	}

	public static class Scanner {
		BufferedReader bf;
		StringTokenizer st;

		Scanner(InputStream s) {
			bf = new BufferedReader(new InputStreamReader(s));

		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(bf.readLine());
			return st.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}
	}
}
