package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class LuckySum_121C {
	static long l, r;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		l = sc.nextInt();
		r = sc.nextInt();
		long ans = 0;
		generateLucky();
//		System.out.println(lucky.toString());
		for (long i : lucky) {
			if (i >= l) {
				ans += (i - l + 1) * i;
				l = i + 1; 
//				System.out.println(i);
//				System.out.println(ans);
			}
			if(i > r) {
				ans -= (i - r)*i;
//				System.out.println(ans);
//				System.out.println("---");
				break; 
			}
		}

		System.out.println(ans);
	}

	static ArrayList<Long> lucky = new ArrayList<>();

	static void generateLucky() {
		Queue<Long> q = new LinkedList<>();
		q.add((long)4);
		q.add((long) 7);
		while (!q.isEmpty()) {
			long cur = q.poll();
			
			lucky.add(cur);
			if (cur > r)
				return;
			q.add(cur * 10  + 4);
			q.add(cur * 10 + 7);
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
