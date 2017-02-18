package camp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BearAndPrimesNumbers {
	static int freq[], fn[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		freq = new int[10000001]; 
		fn = new int[10000001]; 
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			freq[x]++; 
		}
		modSieve(10000000);
		for (int i = 1; i < fn.length; i++) {
			fn[i] += fn[i - 1]; 
		}
		
		int m = sc.nextInt();
		while (m-- > 0) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			if(r >= fn.length)
				r = fn.length - 1; 
			if(l >= fn.length)
				l = fn.length; 
			out.println(fn[r] - fn[l - 1]);

		}
		out.flush();
		out.close();
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

	}


	static void modSieve(int n) {
		// to be changed to n when we need all the numbers to be added to
		// ArrayList
		boolean isPrime[] = new boolean [n + 1]; 
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false; 
		for (int i = 2; i <= n; i++) {
			if (isPrime[i]) {
				for (int j = i; j <= n; j+=i) {
					isPrime[j] = false; 
					fn[i] += freq[j]; 
				}
			}
		}
	}

	


}
