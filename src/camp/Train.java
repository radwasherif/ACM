package camp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Train {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in); 
		int d = sc.nextInt(); 
		int m = sc.nextInt(); 
		long lcm = lcm(d, m); 
		long dt = lcm/d - 1; 
		long mt = lcm/m - 1; 
		if(mt < dt) {
			mt++; 
		} else {
			dt++; 
		}
		if(mt > dt) {
			System.out.println("Masha");
		} else if(mt < dt) {
			System.out.println("Dasha");
		} else {
			System.out.println("Equal");
		}
	}
	static long lcm (int a, int b) {
		return (1l*a*b)/gcd(a,b); 
	}
	static int gcd(int n, int m) {
		if(m == 0)
			return n; 
		return gcd(m, n%m); 
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

