package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheresTreasureEverywhere_UVa587 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		String s;
		int t = 1;
		while (!((s = sc.nextLine()).equals("END"))) {
			s = s.substring(0, s.length() - 1);
			StringTokenizer st = new StringTokenizer(s, ",");
			double x = 0, y = 0;
			while (st.hasMoreTokens()) {

				String str = st.nextToken();
				int idx = getIntIdx(str);
				int d = Integer.parseInt(str.substring(0, idx));
				String dir = str.substring(idx);
				double diag = Math.sqrt(2) / 2.0;
				if (dir.equals("N"))
					y += d;
				if (dir.equals("S"))
					y -= d;
				if (dir.equals("E"))
					x += d;
				if (dir.equals("W"))
					x -= d;
				if (dir.equals("NE")) {
					x += diag * d;
					y += diag * d;
				}
				if (dir.equals("NW")) {
					x -= diag * d;
					y += diag * d;
				}
				if (dir.equals("SE")) {
					x += diag * d;
					y -= diag * d;
				}
				if (dir.equals("SW")) {
					x -= diag * d;
					y -= diag * d;
				}

			}
			out.printf("Map #%d\nThe treasure is located at (%.3f,%.3f).\n", t++, Math.round(x * 1000) / 1000.0,
					Math.round(y * 1000) / 1000.0);
			double dist = Math.sqrt(x * x + y * y);
			out.printf("The distance to the treasure is %.3f.\n\n", Math.round(dist * 1000) / 1000.0);

		}
		out.flush();
		out.close();
	}

	static int getIntIdx(String s) {
		for (int i = 0; i < s.length(); i++)
			if (!(Character.isDigit(s.charAt(i))))
				return i;
		return -1;
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

		boolean ready() throws IOException {
			return br.ready();
		}
	}
}
