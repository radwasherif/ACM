package camp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.swing.text.AttributeSet.CharacterAttribute;

public class ChoosingSymbolPairs_50B {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in); 
//		int n = sc.nextInt(); 
		String s = sc.next(); 
		int f [] = new int[256];  
		for (int i = 0; i < s.length(); i++) {
			f[s.charAt(i)]++; 
		}
		long ans = 0; 
		for (int i = 0; i < f.length; i++) {
			ans += 1l*f[i]*f[i]; 
		}
		System.out.println(ans);
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
