package contest.orange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SolveEquation {
	static class Scanner 
	{
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
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in); 
		String op1 = sc.next(); 
		sc.next(); 
		String op2 = sc.next(); 
		sc.next(); 
		String res = sc.next(); 
		if(res.equals("x")) {
			System.out.println(Integer.parseInt(op1) + Integer.parseInt(op2));
		} else if (op1.equals("x")) {
			System.out.println(Integer.parseInt(res) - Integer.parseInt(op2));
		} else {
			System.out.println(Integer.parseInt(res) - Integer.parseInt(op1));
		}
	}
}
