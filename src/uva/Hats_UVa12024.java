package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Hats_UVa12024 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in); 
		der(12); 
		fac(12); 
		int t = sc.nextInt(); 
		PrintWriter out = new PrintWriter(System.out); 
		while(t-- > 0) {
			int n = sc.nextInt(); 
			out.printf("%d/%d\n", D[n], fac[n]);
		}
		out.flush();
		out.close(); 
	}
	static int D[]; 
	static void der (int N) {
		D = new int [N + 1]; 
		D[0] = 1; 
		D[1] = 0; 
		for (int i = 2; i < D.length; i++) {
			D[i] = (i - 1) * (D[i - 1] + D[i - 2]);  
		}
	}
	static int [] fac; 
	static void fac(int N ) {
		fac = new int[N + 1]; 
		fac[0] = 1; 
		fac[1] = 1; 
		for (int i = 2; i < fac.length; i++) {
			fac[i] = i * fac[i - 1]; 
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
