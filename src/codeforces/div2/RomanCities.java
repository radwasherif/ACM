package codeforces.div2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RomanCities {
	public static void main(String[] args)throws IOException {
		Scanner sc = new Scanner(new FileReader("roman.in"));
		PrintWriter out = new PrintWriter(new FileWriter("roman.out"));
		String s = sc.next();
		// System.out.println(s);
		String[] a = s.split("-");
		// System.out.println(a[0]);S
		String y1 = a[0].substring(0, a[0].length() - 2);
		// System.out.println(a[0]);
		String y2 = a[1].substring(0, a[1].length() - 2);
		// System.out.println(a[1]);
		// System.out.println(a[0]);
		// System.out.println("hi");
		Pair[] pq = { (new Pair(1, 1)), (new Pair(5, 1)), (new Pair(10, 1)), (new Pair(50, 1)), (new Pair(100, 1)),
				(new Pair(500, 1)), (new Pair(1000, 1)), (new Pair(4, 2)), (new Pair(9, 2)), (new Pair(40, 2)),
				(new Pair(90, 2)), (new Pair(400, 2)), (new Pair(900, 2)) };
		Arrays.sort(pq);
		String era1 = a[0].substring(a[0].length() - 2, a[0].length());
		String era2 = a[1].substring(a[1].length() - 2, a[1].length());
		int year1 = getYear(y1, era1);
		int year2 = getYear(y2, era2);
		// PriorityQueue<Pair> pq = new PriorityQueue<Pair>();

		int max = -1;
		for (int i = year1; i <= year2; i++) {
			max = Math.max(max, getMax(i, pq));
		}
		// System.out.println(getMax(getYear("757", "BC"), pq));
		out.println(max);
		out.flush();
		out.close();

	}

	static int getMax(int year, Pair[] pq) {
		int wt = 0;
		// System.out.println("year is "+year);

		int i = 0;
		while (year > 0) {
			int x = pq[i].val;
			if (year >= x) {
				year -= x;
				wt += pq[i].wt;
				// System.out.println(pq[i].wt);
			} else {
				// pq.remove();
				i++;
			}
		}
		// System.out.println("------");
		return wt;
	}

	static class Pair implements Comparable<Pair> {
		int val, wt;

		Pair(int v, int w) {
			val = v;
			wt = w;
		}

		@Override
		public int compareTo(Pair o) {
			return o.val - val;
		}

	}

	static int getYear(String y, String era) {
		if (era.equals("BC")) {
			return 753 - Integer.parseInt(y) + 1;
		} else {
			return Integer.parseInt(y) + 753;
		}
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
