package codeforces.div2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class MeetingOfOldFreidns {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		BigInteger l1 = new BigInteger(sc.next());
		BigInteger r1 = new BigInteger(sc.next());
		BigInteger l2 = new BigInteger(sc.next());
		BigInteger r2 = new BigInteger(sc.next());
		BigInteger k = new BigInteger(sc.next());
		if (l2.compareTo(r1) > 0 || r2.compareTo(l1) < 0) {
			System.out.println(0);
			return;
		}
		BigInteger first, second;
		if (l2.compareTo(l1) >= 0 && l2.compareTo(r1) <= 0) {
			first = l2;
		} else
			first = l1;
		if (r2.compareTo(l1) >= 0 && r2.compareTo(r1) <= 0)
			second = r2;
		else
			second = r1;
		BigInteger ans = second.subtract(first).add(new BigInteger("1"));
//		System.out.println(first + " " + second + " " + k);
//		System.out.println(k.compareTo(first) + " " + k.compareTo(second));
//		System.out.println(ans);
		if (k.compareTo(first) >= 0 && k.compareTo(second) <= 0)
			{ //System.out.println("yo");
				BigInteger one = new BigInteger("1"); 
				ans = ans.subtract(one);
//				System.out.println(ans);
			}
		
		System.out.println(ans);
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		Scanner(FileReader r) {
			br = new BufferedReader(r);

		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}
	}
}
