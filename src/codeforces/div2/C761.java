package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C761 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int count[][] = new int[n][3];
		for (int i = 0; i < count.length; i++) {
			Arrays.fill(count[i], 1000000000);
		}
		for(int i = 0; i < n; i++){
			String s = sc.next(); 
			for (int j = 0; j < 3; j++) {
				for(int k = 0; k < s.length(); k++) {
					if(j == 0 && Character.isAlphabetic(s.charAt(k))){
						count[i][j] = Math.min(Math.min(k, n-k+1), count[i][j]); 
						break; 
					}
					if(j == 1 && Character.isDigit(s.charAt(k))) {
						count[i][j] = Math.min(Math.min(k, n-k+1), count[i][j]); 
						break;
					}
					if(j == 2 && "#*&".contains(s.charAt(k)+"")) {
						count[i][j] = Math.min(Math.min(k, n-k+1), count[i][j]); 
						break;
					}
				}
			}
		}
		int ans = 0; 
		for(int j = 0; j < 3; j++) {
			int min = 1000000000; 
			for (int i = 0; i < count.length; i++) {
				min = Math.min(min, count[i][j]); 
			} 
			ans+=min; 
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
