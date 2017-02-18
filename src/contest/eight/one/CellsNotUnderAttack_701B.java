package contest.eight.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class CellsNotUnderAttack_701B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
		long m = sc.nextInt();
		PrintWriter out = new PrintWriter(System.out); 
		TreeSet<Integer> r = new TreeSet<>();
		TreeSet<Integer> c = new TreeSet<>();
		for(int i = 0; i < m; i++) {
			r.add(sc.nextInt());
			c.add(sc.nextInt());
			if(i > 0)
				out.print(" ");
			
			out.print(1l * ( n * n - (1l * n * r.size() + 1l * n * c.size() - 1l * r.size() * c.size())));
			
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

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		boolean ready() throws IOException {
			return br.ready();
		}

	}
}
