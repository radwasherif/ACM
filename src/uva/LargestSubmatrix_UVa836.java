package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LargestSubmatrix_UVa836 {
	static int grid[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = sc.nextInt();
		while (T-- > 0) {
			sc.nextLine();
			String s = sc.nextLine();
			int N = s.length();
			grid = new int[N][N];
			for (int i = 0; i < N; i++) {
				if (i > 0)
					s = sc.nextLine();
				for (int j = 0; j < N; j++) {
					grid[i][j] = (s.charAt(j) - '0' == 0)?-INF: 1;
					//System.out.print(grid[i][j]);
					if (i > 0)
						grid[i][j] += grid[i - 1][j];
					if (j > 0)
						grid[i][j] += grid[i][j - 1];
					if (i > 0 && j > 0)
						grid[i][j] -= grid[i - 1][j - 1];
				}
			}
			int ans = max2DRange(grid); 
			out.println(ans < 0 ? 0: ans);
			if (T > 0)
				out.println();
		}
		out.flush();
		out.close();

	}
	static final int INF = 25*25; 
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

		String nextLine() throws IOException {
			return br.readLine();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}
	}
}
