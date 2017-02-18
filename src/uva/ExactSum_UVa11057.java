package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ExactSum_UVa11057 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int c = 100; 
		while (sc.ready()) {
//		while(c-- > 0 ) {
			boolean b[] = new boolean[1000001];
			int n = sc.nextInt();
			Integer a[] = new Integer[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
				b[a[i]] = true;
			}
			int sum = sc.nextInt();
			Arrays.sort(a);
			int ans1, ans2;
			ans1 = ans2 = 0;
			int diff = 1000000000;
//			for(int i = 0; i < b.length; i++) {
//				if(b[i])
//					System.out.println(i);
//			}
			for (int i = 0; i < n; i++) {
				int x = sum - a[i]; 
//				System.out.println(a[i] + " " + x + " " + sum);
				if (a[i] < sum && x > a[i] && x >= 0 && x < b.length && b[x]) {
//					System.out.println("HELLO");
					if (x - a[i] < diff) {
						ans1 = a[i];
						ans2 = x;
						diff = x - a[i];
					}
				}
			}
			out.printf("Peter should buy books whose prices are %d and %d.\n\n", ans1, ans2);
			sc.readLine(); 
		}
		out.close();
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
		String readLine() throws IOException {
			return br.readLine(); 
		}
	}
}
