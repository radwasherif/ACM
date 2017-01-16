package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * UVa - 10827
 */
public class MaximumSumOnTorus {
	static int N;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			N = sc.nextInt();
			int a[][] = new int[N*2][N*2];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					a[i][j] = sc.nextInt();
					a[i + N][j] = a[i][j];
					a[i][j + N] = a[i][j];
					a[i + N][j + N] = a[i][j];
				}
			}
			//System.out.println("OUT");
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a.length; j++) {
					if(i > 0) a[i][j] += a[i-1][j]; 
					if(j > 0) a[i][j] += a[i][j-1]; 
					if(i > 0 && j > 0) a[i][j] -= a[i-1][j-1]; 
				}
			}
			System.out.println(max2DRange(a));
		}
		
	}
	static int INF = 100*75*75; 
	static int max2DRange( int a [][] ) {
		int maxSum = -INF, subRectSum = -INF; 
		for (int i = 0; i < N ; i++) { //i, j start coordinates 
			for (int j = 0; j < N; j++) {
				for (int k = i;  k< N + i; k++) { //k, l end coordinates
					for(int l = j; l < N + j; l++) {
						
						subRectSum = a[k][l]; 
						if(i > 0) subRectSum -= a[i-1][l]; 
						if(j > 0) subRectSum -= a[k][j-1]; 
						if( i > 0 && j > 0) subRectSum += a[i-1][j-1]; 
						if(subRectSum > maxSum) {
							maxSum = subRectSum; 
							
						}
					}
				}
			}
		}
		return maxSum; 
	}
	

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
}
