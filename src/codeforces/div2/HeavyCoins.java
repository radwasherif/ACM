package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HeavyCoins {
	static int S, N;
	static int a[]; 

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder(); 
		int T = sc.nextInt(); 
		while(T-- > 0) {
			N = sc.nextInt(); 
			S = sc.nextInt(); 
			a = new int[N]; 
			for (int i = 0; i < a.length; i++) {
				a[i] = sc.nextInt(); 
			}
//			System.out.println(Arrays.toString(a));
			int ans = -1; 
			for(int msk = 1; msk < (1 << N); msk++) {
				Pair p = compute(msk); 
			
				if(p.sum >= S && p.minVal > p.sum - S) {
//					System.out.println("yo");
					ans = Math.max(ans, Integer.bitCount(msk)); 
				}
			}
			sb.append(ans + "\n"); 
		}
		
		System.out.print(sb);
	}

	static int INF = 1000000000;

	static Pair compute(int msk) {
		int minVal = INF;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			if ((msk & (1 << i)) != 0) {

				sum += a[i];
				minVal = Math.min(minVal, a[i]);
			}
		}
		return new Pair(minVal, sum); 
	}

	static class Pair {
		int minVal, sum;

		Pair(int i, int s) {
			minVal = i;
			sum = s;
		}

	
		

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
	}
}
