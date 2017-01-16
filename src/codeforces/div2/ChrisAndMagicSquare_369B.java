package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class ChrisAndMagicSquare_369B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
//		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		if (n == 1) {
			System.out.println(3);
			return;
		}
		int[][] a = new int[n][n];
		TreeSet<Long> rows = new TreeSet<Long>();
		TreeSet<Long> cols = new TreeSet<Long>();
		long d1 = 0;
		long d2 = 0;
		int X = 0;
		int Y = 0;
		boolean D1 = false, D2 = false;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				int cur = a[i][j] = sc.nextInt();
				if (cur == 0) {
					X = i;
					Y = j;
					if (i == j)
						D1 = true;
					if (j == n - i - 1)
						D2 = true;
				}
				if (i == j)
					d1 += cur;
				if (j == n - i - 1)
					d2 += cur;
			}
		}
		long rowSum = 0;
		for (int i = 0; i < a.length; i++) {
			long sum = 0;
			for (int j = 0; j < a[i].length; j++) {
				sum += a[i][j];
			}
			if (i == X)
				rowSum = sum;
			else
				rows.add(sum);
		}
		long colSum = 0;
		for (int j = 0; j < a.length; j++) {
			long sum = 0;
			for (int i = 0; i < a[j].length; i++) {
				sum += a[i][j];
			}
			if (j == Y)
				colSum = sum;
			else
				cols.add(sum);
		}
		long sum = 0; 
//		System.out.println(rows.first() + " " + cols.first() + " " + rowSum + " " + colSum);
		boolean possible = true; 
		if (colSum != rowSum)
			possible = false;
//		System.out.println(possible + "hi");
		if(rows.size() > 1 || cols.size() > 1)
			possible = false; 
//		System.out.println(possible + "0");
		long rowF = rows.first(); 
		long colF = cols.first(); 
		if(rowF == colF)
		{
			sum = rowF; 
//			System.out.println("YOOO");
		}
		else 
		{	//System.out.println(rows.first()  + " " + cols.first());
			possible = false; 
		}
//		System.out.println(possible + "1");
	
		if(D1) {
			if(d1 != rowSum)
				possible = false; 
//			System.out.println(possible + "2");
		} else {
			if(d1 != sum)
				possible = false; 
//			System.out.println(possible + "3");
		}
		if(D2) {
			if(d2 != colSum)
				possible = false; 
//			System.out.println(possible + "4");
		} else {
			if(d2 != sum)
				possible = false; 
//			System.out.println(possible + "5");
		}
		
	
		if (possible) {
			System.out.println(sum - rowSum);
		} else {
			System.out.println(-1);
		}

	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(System.in));

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
