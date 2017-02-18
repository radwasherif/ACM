package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KitaharaHarukisGift_433A {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt(); 
		int count1 = 0; 
		int count2 = 0;
		for(int i = 0; i < n; i++) {
			int x = sc.nextInt(); 
			if(x == 100)
				count1++; 
			else 
				count2++; 
			
		}
		count2 = count2 % 2; 
		if(count1 >= count2 * 2) {
			count1 -= count2 * 2; 
			if(count1 % 2 == 0)
				System.out.println("YES");
			else 
				System.out.println("NO");
			
		} else {
			System.out.println("NO");
		}
			
		

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
