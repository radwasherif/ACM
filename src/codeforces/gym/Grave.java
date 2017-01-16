package codeforces.gym;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Grave {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(new FileReader("grave.in")); 
		PrintWriter out = new PrintWriter(new FileWriter("grave.out")); 
//		Scanner sc = new Scanner(System.in); 
//		PrintWriter out = new PrintWriter(System.out); 
		int x1 = sc.nextInt(), y1 = sc.nextInt(), x2 = sc.nextInt(), y2 = sc.nextInt(); 
		int x3 = sc.nextInt(), y3 = sc.nextInt(), x4 = sc.nextInt(), y4 = sc.nextInt(); 
		int w = sc.nextInt(), h = sc.nextInt(); 
		boolean yes = false; 
		if((h <= y2 -y1) && ((w <= x3 - x1) || (w <= (x2 - x4)) ))
			yes = true; 
		if((w <= x2 - x1) && ((h <= y2 - y4) || (h <= y3 - y1)))
			yes = true; 
		int x = 1000000000*2; 
		out.println((yes) ? "Yes" : "No");
		out.flush();
		out.close(); 
	}	
	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}
		Scanner(FileReader r) {
			br = new BufferedReader(r); 
		}
		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}
	}
}
