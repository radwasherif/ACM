package codeforces.div2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BachgoldProblem_749A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner (System.in); 
		int n = sc.nextInt();
		int two = n/2;
		int three = 0;
		if(n % 2 == 1) {
			two--; 
			three++; 
		}
		
		PrintWriter out = new  PrintWriter(System.out); 
		out.println(two + three); 
		for(int i = 0; i < two; i++) {
			if(i > 0)
				out.print(" ");; 
			out.print("2"); 
				
		}
		if(three > 0) {
			out.print(" 3"); 
		}
		out.flush();
		out.close();

	}
	static boolean [] sieve(int n) {
		  boolean isPrime  [] = new boolean[n+1]; 
		  for (int i = 0; i < isPrime.length; i++) {
			isPrime[i] = true; 
		} 
		  isPrime[0] = false; 
		  isPrime[1] = false; 
		  int n_sqrt = (int) Math.sqrt(n); 
		  for (int i = 2; i <= n_sqrt; i++) {
			if (isPrime[i]) {
				for(int j = 2; i*j <=n; j++) {
					isPrime[i*j] = false; 
				}
			}
		}
		 return isPrime;  
	  }
	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		Scanner(FileReader r) {
			br = new BufferedReader(r);

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
