package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
/*
 * Using nQueens optimization 
 */

public class EightQueensChessProblem_UVa750_Alternative {
	static int n, a, b, lineCounter;
	static boolean[] rw, ld, rd;
	static int[] row;
	static PrintWriter out; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		out = new PrintWriter(System.out); 
		n = 8;
		int T = sc.nextInt(); 
		while(T-- > 0) {
			a = sc.nextInt() - 1;
			b = sc.nextInt() - 1;
			row = new int[n];
			ld = new boolean[2 * n - 1];
			rd = new boolean[2 * n - 1];
			rw = new boolean[n];
			out.print("SOLN       COLUMN\n #      1 2 3 4 5 6 7 8\n\n");
			// System.out.println(Arrays.toString(ld));
			lineCounter = 1; 
			backtrack(0);
			if(T > 0)
				out.println();

		}
		out.flush();
		out.close();
		
	}

	static void backtrack(int c) {
//		System.out.println(c);
		if (c == n) {
			out.printf("%2d     ", lineCounter++);
			for (int i = 0; i < n; i++) {
				out.print(" " + (row[i] + 1));
				
			}
			out.println();
			return;
		}
		for (int r = 0; r < n; r++) {
			if(r == a && c != b)
				continue; 
			if (!rw[r] && !rd[r - c + n - 1] && !ld[r + c]) {
				row[c] = r;
				rw[r] = rd[r - c + n - 1] = ld[r + c] = true;
				backtrack(c + 1);
				rw[r] = rd[r - c + n - 1] = ld[r + c] = false;
			}
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
