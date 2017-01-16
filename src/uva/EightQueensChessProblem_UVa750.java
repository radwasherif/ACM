package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class EightQueensChessProblem_UVa750 {
	static int row[];
	static int a, b, lineCount;
	static PrintWriter out = new PrintWriter(System.out); 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); 
		for (int t = 0; t < T; t++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			a--;
			b = Integer.parseInt(st.nextToken());
			b--; // to make it zero-based
//			System.out.println(a + " " + b );
			lineCount = 1;
			if (t > 0)
				out.println(); 
			out.print("SOLN       COLUMN\n #      1 2 3 4 5 6 7 8\n\n");
			row = new int[8];
			backtrack(0);
		}
		out.flush();
	}

	static boolean place(int r, int c) {
		for (int i = 0; i < c; i++) {
			if (row[i] == r
					|| Math.abs(row[i] - r) == Math.abs(i - c))
				return false;
		}
		return true;
	}

	static int numDig(int n) {
		int ans = 0;
		while (n > 0) {
			ans++;
			n /= 10;
		}
		return ans;
	}

	/*
	 * O(< n!) because of the optimizations of the place method
	 */
	static void backtrack(int c) {
		if (c == 8 && row[b] == a) {
			out.printf("%2d     ", lineCount++); 
			for (int i = 0; i < 8; i++) {
				out.printf(" %d", (row[i] + 1));

			}
			out.println();

		}
		// try all possiblw rows to place a queen in this row
		for (int r = 0; r < 8; r++) {
			if (place(r, c)) { // if it's valid to place a queen here
				row[c] = r; // place it
				backtrack(c + 1); // then go and try the next row
			}
		}
		/*
		 * This will result in a tree in which all possible (valid) combinations
		 * of rows and columns have been tried
		 */
	}
}
