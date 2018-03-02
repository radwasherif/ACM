package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class ExcusesExcuses_UVa409 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = 1;
		// int c = 1;
		// while (c-- > 0) {
		while (sc.ready()) {
			int K = sc.nextInt();
			int E = sc.nextInt();
			TreeSet<String> ts = new TreeSet<>();
			String exc[] = new String[E];
			while (K-- > 0) {
				ts.add(sc.next());
			}

			int max = 0;
			int count[] = new int[E];
			for (int i = 0; i < E; i++) {
				exc[i] = sc.nextLine();
				String line = exc[i].toLowerCase();
				line = line.replaceAll("[^a-z]", " ");
				StringTokenizer st = new StringTokenizer(line);
				// System.out.println(st.countTokens());
				int n = 0;
				// System.out.println(i);
				while (st.hasMoreTokens()) {
					String token = st.nextToken();
					// System.out.println(token);
					if (ts.contains(token))
						n++;
				}
				max = Math.max(max, n);
				count[i] = n;
			}
			out.printf("Excuse Set #%d\n", t++);
			for (int i = 0; i < count.length; i++) {
				if (count[i] == max) {
					out.println(exc[i]);
				}
			}
			out.println();

		}
		out.flush();
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
