package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B761 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt(); 
		int L = sc.nextInt(); 
		Integer a[] = new Integer[n]; 
		Integer b [] = new Integer[n]; 
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt(); 
		}
		for (int i = 0; i < b.length; i++) {
			b[i] = sc.nextInt(); 
		}
		for(int i = 1; i <= L; i++) {
			for(int j = 0; j < a.length; j++) {
				a[j] = mod(a[j]- 1, L); 
			}
			Arrays.sort(a);
//			System.out.println(Arrays.toString(a));
			boolean eq = true; 
			for (int j = 0; j < b.length; j++) {
				if(a[j] != b[j])
					eq = false; 
			}
			if(eq) {
				System.out.println("YES");
				return; 
			}
		}
		System.out.println("NO");
	
	}
	static int mod(int a, int n) {
		if (a >= 0)
			return a % n;
		return (a % n + n) % n;
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
