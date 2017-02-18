package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TheSultansSuccessors_UVa167 {
	static int [] [] b;
	static boolean [] rw, ld, rd; 
	static int ans;
	static ArrayList<Integer> vals = new ArrayList<>(); 
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out); 
		int T = sc.nextInt(); 
		while(T-- > 0) {
			b = new int[8][8];
			rw = new boolean[8]; 
			ld = new boolean[8 * 2 - 1]; 
			rd = new boolean[8 * 2 - 1]; 
			for (int i = 0; i < b.length; i++) {
				for (int j = 0; j < b.length; j++) {
					b[i][j] = sc.nextInt(); 
				}
			}
			ans = 0; 
			vals = new ArrayList<>(); 
			backtrack(0);
			int max = -1; 
			for(int i: vals)
				max = Math.max(i, max); 
			out.printf("%5d\n", max);
		}
		out.close();
	}
	static void backtrack(int c) {
		if(c == 8) {
			vals.add(ans); 
		}
		for(int r = 0; r < 8; r++) {
			if(!rw[r] && !ld[r + c] && !rd[r - c + 8 - 1]) {
				ans += b[r][c]; 
				rw[r] = ld[r + c] = rd[r - c + 8 - 1] = true; 
				backtrack(c + 1);
				ans -= b[r][c]; 
				rw[r] = ld[r + c] = rd[r - c + 8 - 1] = false; 
				
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

		boolean ready() throws IOException {
			return br.ready();
		}
	}
}
