package codeforces.div2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in); 
		int n =sc.nextInt(); 
		TreeSet<Integer> ts = new TreeSet<Integer>(); 
		while(n-- > 0) {
			ts.add(sc.nextInt()); 
		}
		if(ts.size() > 3)
		{
			System.out.println("NO");
			return; 
		} else if (ts.size() < 3)
		{
			System.out.println("YES");
			return; 
		}
//		System.out.println(ts.toString());
		int x = ts.first(); ts.remove(x); 
		int y = ts.first(); ts.remove(y); 
		int z = ts.first(); ts.remove(z); 
		
//		System.out.println(x + " " + y  + " " + z);
		if(Math.abs(x - y) == Math.abs(y - z))
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
