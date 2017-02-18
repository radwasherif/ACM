package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RobotsTask_583B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); 
		int a [] = new int[n]; 
		int d = 1;
		int sum = 0; 
		int ans = 0; 
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt(); 
		}
		if(n == 1) {
			System.out.println(0);
			return; 
		}
//		System.out.println(Arrays.toString(a));
		for (int i = 0; ; i+=d) {
			if(i == 0)
			{
				d = 1;
				ans++; 
			}
			else if(i == a.length - 1)
			{
				d = -1;
				ans++; 
//				System.out.println("BOOOM");
			}
			if( a[i] != -1 && a[i] <= sum) {
				sum++; 
				a[i] = -1;
			}
			if(sum == n)
			{
				if(i == 0 || i == a.length - 1)
					ans--; 
				break; 
			}
//			System.out.println(i + " " + sum);
		}
		System.out.println(ans - 1);
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
