package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FiveCards {
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

	public static void main(String[] args) throws IOException {
		int a[] = new int[5];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		int minSum = sum;
		
		for (int i = a.length - 1; i > 0; i--) {
			int currSum = a[i];
		
			for (int j = i - 1; j >= 0; j--) {
				if (a[i] == a[j] && i - j < 3) {
					currSum += a[j];
					
				}
					else
					break;
			}
			if (currSum > a[i]) {
				
				 
				if (sum - currSum < minSum)
					minSum = sum - currSum; 
			} 
		}
		System.out.println(minSum);
	}
}
