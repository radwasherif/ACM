package contest.orange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Knight {
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

	static int di[] = { 2, 2, 1, 1, -1, -1, -2, -2 };
	static int dj[] = { -1, 1, 2, -2, -2, 2, -1, 1 };
	static char a[][];
	static int Ki, Kj, Qi, Qj, Ni, Nj;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		a = new char[8][8];
		for (int i = 0; i < a.length; i++) {
			String s = sc.next();
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = s.charAt(j);
				if (a[i][j] == 'N') {
					Ni = i;
					Nj = j;
				}
			}
		}
		//System.out.println(Ni + " " + Nj);
		boolean king = false, queen = false;
		int thei = -1, thej = -1;
		for (int i = 0; i < di.length; i++) {
			int newi = Ni + di[i], newj = Nj + dj[i];
			king = queen = false; 
			if (valid(newi, newj))
				for (int j = 0; j < di.length; j++) {
					if (valid(newi + di[j], newj + dj[j])) {
						if (a[newi + di[j]][newj + dj[j]] == 'K') {
							king = true;
						}
						if (a[newi + di[j]][newj + dj[j]] == 'Q') {
							queen = true; 
						}
						if (queen && king) {
							thei = newi;
							thej = newj;
							//queen = king = false; 
							break;
						}

					}
				}

		}
		if (thei!= -1 && thej != -1) {

			System.out
					.println("YES " + (8 - thei) + "" + ((char) ('A' + thej)));
		} else {
			System.out.println("NO");
		}
	}

	static boolean valid(int i, int j) {
		return (i > 0 && i < 8 && j > 0 && j < 8);
	}

}
