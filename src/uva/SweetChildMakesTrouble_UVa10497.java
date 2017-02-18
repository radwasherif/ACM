package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class SweetChildMakesTrouble_UVa10497 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		PrintWriter out = new PrintWriter(System.out); 
		Scanner sc = new Scanner(System.in); 
		der(800); 
		while(true) {
			int n = sc.nextInt();
			if(n == -1) 
				break; 
			out.println(d[n]);
			
		}
		out.flush();
		out.close();
	}
	static BigInteger d  [] ; 
	static void der (int N) {
		d = new BigInteger[N + 1]; 
		d[0] = new BigInteger("1"); 
		d[1] = new BigInteger("0"); 
		for (int i = 2; i < d.length; i++) {
			d[i] = new BigInteger((i - 1) + "").multiply(d[i - 1].add(d[i - 2]));  
		}
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
