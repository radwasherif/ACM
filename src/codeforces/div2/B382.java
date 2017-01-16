package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B382 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int a[] = new int[n];
		double a1[] = new double[n];
		double a2[] = new double[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
			a1[i] = a[i] / (1.0 * n1);
			a2[i] = a[i] / (1.0 * n2);
		}
		Arrays.sort(a1);
		Arrays.sort(a2);
		double sum = 0.0;
		for (int i = a.length - 1; i >= 0; i--) {
			if(n1 > 0 && n2 > 0) {
				if(a1[i] > a2[i]) { 
					n1--; 
					sum += a1[i]; 
				} else {
					n2--; 
					sum += a2[i]; 
				}
			} else if (n1 > 0) {
				sum += a1[i]; 
				n1--; 
			} else if (n2 > 0){
				sum += a2[i];
				n2--; 
			}
		}
		System.out.println(sum);
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		boolean ready() throws IOException {
			return br.ready();
		}

	}
}
