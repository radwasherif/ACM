package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AncientMessages {
	static int grid [] []; 
	static int H, W; 
	static boolean vis[] []; 
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder(); 
		while(sc.ready()) {
			H = sc.nextInt(); 
			W = sc.nextInt(); 
			grid = new int [H][W*4]; 
			for(int i = 0; i < H; i++) {
				String s = sc.next(); 
				for(int j = 0; j < W; j++) {
					String bin = toBin(s.charAt(j)); 
					grid[i][j*4] = bin.charAt(0); 
					grid[i][j*4 +1] = bin.charAt(1); 
					grid[i][j*4 + 2] = bin.charAt(2); 
					grid[i][j*4 +3] = bin.charAt(3); 
				}
			}
		}
	}

	static String toBin(char c) {
		switch (c) {
		case '0':
			return "0000";
		case '1':
			return "0001";
		case '2':
			return "0010";
		case '3':
			return "0011";
		case '4':
			return "0100";
		case '5':
			return "0101";
		case '6':
			return "0110";
		case '7':
			return "0111";
		case '8':
			return "1000";
		case '9':
			return "1001";
		case 'a':
			return "1010";
		case 'b':
			return "1011";
		case 'c':
			return "1100";
		case 'd':
			return "1101";
		case 'e':
			return "1110";
		default:
			return "1111";
		}
	}

	static class Scanner {
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
}
