package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GeekPower {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int[] count = new int[1001];
			while (n-- > 0) {
				int k = sc.nextInt();
				int p = sc.nextInt();
				count[p] += k;
			}
			//System.out.println(Arrays.toString(count));
			ArrayList<Integer> k = new ArrayList<Integer>();
			ArrayList<Integer> p = new ArrayList<Integer>();
			for (int i = count.length-1; i >= 0; i--) {
				if (count[i] != 0) {
					k.add(count[i]);
					p.add(i);
				}
			}
			ArrayList<Integer> cumm = new ArrayList<Integer>();
			cumm.add(k.get(0));
			for (int i = 1; i < k.size(); i++) {
				cumm.add(cumm.get(i - 1) + k.get(i));
			}
//			System.out.println(p.toString());
//			System.out.println(cumm.toString());
//			 
//			System.out.println(500000);
			long max = -1;
			for (int i = 0; i < cumm.size(); i++) {
				max = Math.max(max, 1l *p.get(i) * cumm.get(i));
			}
			sb.append("Case " + t + ": " + max + "\n");
		}
		System.out.print(sb);
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		public Scanner(InputStream s) {
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
	}
}
