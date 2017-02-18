package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ANeedleInTheHaystack_NHAY {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in); 
		PrintWriter out = new PrintWriter(System.out); 
		boolean print = false; 
		while(sc.ready()) {
			if(!print) {
				print = true; 
			} else {
				out.println();
			}
			int n = sc.nextInt(); 
			String s = sc.next(); 
			String text = sc.next();
			int [] pi = kmp(s + "#" + text);
//			System.out.println(Arrays.toString(pi));
			for(int i = 0; i < pi.length; i++) {
				if(pi[i] == n) {
					out.println(i - 2*n);
				}
			}
		}
		out.flush(); 
		out.close();
	}
	static int [] kmp(String s) {
		int n = s.length(); 
		int [] pi = new int[n]; 
		for(int i = 1, j = 0; i < n; i++) {
			while(j > 0 && s.charAt(i) != s.charAt(j))
				j = pi[j- 1]; 
			if(s.charAt(i) == s.charAt(j))
				j++; 
			pi[i] = j; 
		}
		return pi; 
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
	}
}
