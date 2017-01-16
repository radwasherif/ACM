package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Max2DRangeSum {
	/*
	 * Turn the 2D array into a cummulative sum 2D array, where a[i][j] = sum of
	 * all values from (0,0) to (i,j) 
	 * O(n^2) 
	 */
	static int INF = 100*100*127; 
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner (System.in); 
		while(sc.ready()) {
		int N = sc.nextInt(); 
		int a [] [] = new int [N][N]; 
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				a[i][j] = sc.nextInt(); 
				if(i > 0) a[i][j] += a[i-1][j]; 
				if(j > 0) a[i][j] += a[i][j-1]; 
				if(i > 0 && j > 0) a[i][j] -= a[i-1][j-1]; 
				
				Arrays.binarySearch(a, 3); 
			}
		}
		//System.out.println(Arrays.deepToString(a));
		System.out.println(max2DRange(a));
		//System.out.println(I + " " + J + " " + K + " " + L);
	}
		}
	
	/* Maximum 2D range sum 
	 * O(n^4) 
	 */
	static int I = -1, J = -1, K = -1, L = -1; 
	static int max2DRange( int a [][] ) {
		int maxSum = -INF, subRectSum = -INF; 
		for (int i = 0; i < a.length; i++) { //i, j start coordinates 
			for (int j = 0; j < a.length; j++) {
				for (int k = i;  k< a.length; k++) { //k, l end coordinates
					for(int l = j; l < a.length; l++) {
						subRectSum = a[k][l]; 
						if(i > 0) subRectSum -= a[i-1][l]; 
						if(j > 0) subRectSum -= a[k][j-1]; 
						if( i > 0 && j > 0) subRectSum += a[i-1][j-1]; 
						if(subRectSum > maxSum) {
							maxSum = subRectSum; 
							I = i; J = j; K = k; L = l; 
						}
					}
				}
			}
		}
		return maxSum; 
	}
	
	static class Scanner 
	{
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
}
