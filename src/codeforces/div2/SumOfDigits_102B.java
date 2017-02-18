package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfDigits_102B {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in); 
		String s = sc.next();  
		int sum = 1000000000;
		int ans = 0; 
		while(s.length() > 1) {
			sum = 0; 
			for (int i = 0; i < s.length(); i++) {
				sum += s.charAt(i) - '0'; 
			}
			s = sum + ""; 
			ans++; 
		}
		System.out.println(ans);
		
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
