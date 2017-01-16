package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JotyAndChocolate_768C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt(); 
		int a = sc.nextInt(); 
		int b = sc.nextInt(); 
		int p = sc.nextInt(); 
		int q = sc.nextInt()	; 
		long ans = 0; 
		long inter = n/lcm(a, b); 
		ans = (n/a - inter)*p + (n/b - inter)*q + inter*((p > q)? p : q); 
		System.out.println(ans);
	}
	static long lcm (int a, int b) {
		return (1l*a*b)/gcd(a,b); 
	}
	static long gcd(int n, int m) {
		if(m == 0)
			return n; 
		return gcd(m, n%m); 
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
}
