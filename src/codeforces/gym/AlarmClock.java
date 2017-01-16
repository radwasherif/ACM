package codeforces.gym;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AlarmClock {
	static int[] val = { 6, 2, 5, 5, 4, 5, 6, 3, 7, 6 };
	static int n;
	static boolean found = false;
	static ArrayList<String> sol = new ArrayList<String>(); 
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(new FileReader("alarm.in"));
		PrintWriter out = new PrintWriter(new FileWriter("alarm.out")); 
//		Scanner sc = new Scanner(System.in);
//		PrintWriter out = new PrintWriter(System.out); 
		n = sc.nextInt();
		backtrack(0);
		if(!found) 
			out.println("Impossible");
		else 
			out.println(sol.get(sol.size()-1));
		int x [] = {1, 1, 1, 1}; 
//		System.out.println(valid(x));
//		System.out.println(getVal(x));
//		System.out.println(sol.size());
		out.flush();
		out.close(); 
	}

	static int[] a = new int[4];

	static void backtrack(int i) {
		if (i == 4) {
//			if(a[0] == 0)
//			System.out.println(Arrays.toString(a));
			if (valid(a)) {
				sol.add(a[0] + "" + a[1] + ":" + a[2] + a[3]);
//				System.out.println(a[0] + "" + a[1] + ":" + a[2] + a[3]);
				found = true;
//				return; 
				
			}
			return;
		}
		for (int j = 0; j < val.length; j++) {
			a[i] = j;
			backtrack(i + 1);
		}

	}

	static boolean valid(int[] a) {
//		boolean b = n - (val[a[0]] + val[a[1]] + val[a[2]] + val[a[3]]) == 0;
		return a[0] <= 2 && ((a[0] == 2) ? (a[1] <= 3) : true) && a[2] < 6 && a[3] <= 9 && ( n == getVal(a));
	}
	static int getVal(int a []) {
		int ans = 0; 
		for (int i = 0; i < a.length; i++) {
			ans += val[a[i]]; 
		}
		return ans; 
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
