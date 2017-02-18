package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LifeWithoutZeros_75A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in); 
		int n1 = sc.nextInt(); 
		int n2 = sc.nextInt();
		int ans1 = n1 + n2; 
		n1 = Integer.parseInt((n1 + "").replaceAll("0", "")); 
		n2 = Integer.parseInt((n2 + "").replaceAll("0", "")); 
		ans1 = Integer.parseInt((ans1 + "").replaceAll("0", "")); 
		if(n1 + n2 == ans1)
			System.out.println("YES");
		else 
			System.out.println("NO");
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
