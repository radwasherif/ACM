package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TicTacToe_3A {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String r = "";
		String c = "";
		String d1 = "";
		String d2 = "";
		int em = 0, allO = 0, allX = 0;
		for (int i = 0; i < 3; i++) {
			String s = sc.next();
			r += s + " ";
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == 'X')
					allX++;
				else if (s.charAt(j) == '0')
					allO++;
				else
					em++;
				if (i == j)
					d1 += s.charAt(j);
				if (i == 3 - j - 1)
					d2 += s.charAt(j);
			}
		}
//		System.out.println(r);
		for (int i = 0; i < 3; i++) {
			c += r.charAt(i) + ""  + r.charAt(i + 4) +  "" + r.charAt(i + 8) + " ";
		}
		boolean xWin = false;
		boolean oWin = false;
		if (r.contains("XXX") || c.contains("XXX") || d1.contains("XXX") || d2.contains("XXX"))
			xWin = true;
		if (r.contains("000") || c.contains("000") || d1.contains("000") || d2.contains("000"))
			oWin = true;
//		System.out.println(c);
		String ans = "";
		if (Math.abs(allX - allO) > 1 || allO > allX) {
			ans = "illegal";
		} else if (xWin) {
			if (!oWin && allO < allX) {
				ans = "the first player won";
			} else {
				ans = "illegal";
			}

		} else if (oWin) {
			if (!xWin && allX <= allO)
				ans = "the second player won";
			else 
				ans = "illegal"; 
		} else if (em == 0) {
			ans = "draw";
		} else {
			if (allX == allO) {
				ans = "first";
			} else {
				ans = "second";
			}
		}

		System.out.println(ans);
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
