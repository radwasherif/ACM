package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * UVa - Garbage Heap - 10755
 */
public class Max3DRangeSum {
	static int a, b, c; 
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in); 
		int t = sc.nextInt(); 
		for(int x = 0; x<t; x++) {
			a = sc.nextInt(); b = sc.nextInt(); c = sc.nextInt(); 
			long A [][][] = new long [a][b][c]; 
			for (int i = 0; i < a; i++) {
				for (int j = 0; j < b ; j++) {
					for (int k = 0; k < c ; k++) {
						A[i][j][k] = sc.nextLong(); 
						if(i > 0) A[i][j][k] += A[i-1][j][k]; 
						if(j > 0) A[i][j][k] += A[i][j-1][k]; 
						if(k > 0) A[i][j][k] += A[i][j][k-1]; 
						if(i > 0 && j > 0) A[i][j][k] -=A[i-1][j-1][k]; 
						if(i > 0 && k > 0) A[i][j][k] -= A[i-1][j][k-1]; 
						if(j > 0 && k > 0) A[i][j][k] -= A[i][j-1][k-1]; 
						if( i > 0 && j > 0 && k > 0) A[i][j][k] += A[i-1][j-1][k-1]; 
					}
				}
			}
			if( x > 0)
				System.out.println();
			System.out.println(max3D(A));
		}
	}
	static long max3D(long A[] [] []) {
		long max = A[0][0][0]; 
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				for (int k = 0; k < c; k++) {
					for (int m = i; m < a; m++) {
						for (int l = j; l < b; l++) {
							for (int n = k; n < c; n++) {
								long sum = A[m][l][n]; 
								if(i > 0) sum -= A[i-1][l][n]; 
								if(j > 0) sum -= A[m][j-1][n]; 
								if(k > 0) sum -= A[m][l][k-1]; 
								if(i > 0 && j > 0) sum += A[i-1][j-1][n]; 
								if(i > 0 && k > 0) sum += A[i-1][l][k-1]; 
								if(j > 0 && k > 0) sum += A[m][j-1][k-1]; 
								if(i > 0 && k > 0 && j > 0) sum -= A[i-1][j-1][k-1]; 
								max = Math.max(sum, max); 
							}
						}
					}
				}
			}
		}
		return max; 
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
