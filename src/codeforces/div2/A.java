package codeforces.div2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A {
	static int n, m; 
	static char [] [] grid;
	static int dx[] = {0, 1, 0, -1}; 
	static int dy [] = {1, 0, -1, 0}; 
	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner sc = new Scanner(System.in); 
//		PrintWriter out = new PrintWriter(System.out); 
		Scanner sc = new Scanner(new FileReader("blot.in")); 
		PrintWriter out = new PrintWriter(new FileWriter("blot.out")); 
		n = sc.nextInt(); 
		m = sc.nextInt(); 
		grid = new char[n][m]; 
		for (int i = 0; i < grid.length; i++) {
			String s = sc.next(); 
			grid[i] = s.toCharArray(); 
		}
		int comp = 0; 
		int max = 0; 
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
//				System.out.println("hiii");
				if(valid(i, j)) {
//					System.out.println("YO");
					count = 1;  
					comp++; 
					dfs(i, j);
					max = Math.max(max, count); 
				}
			}
		}
		out.println(comp + " " + max);
		out.flush();
		out.close();
	}
	static int count; 
	static void dfs(int i, int j) {
		grid[i][j] = '0';
		for (int j2 = 0; j2 < dx.length; j2++) {
			if(valid(i + dx[j2], j + dy[j2])) {
//				System.out.println("hi");
				count++; 
				dfs(i + dx[j2], j + dy[j2]); 
			}
		}
	}
	static boolean valid(int i , int j) {
		return i >= 0 && i < n && j >= 0 && j < m && grid[i][j] == '1'; 
	}

	static class Scanner {
		BufferedReader br; 
		StringTokenizer st; 
		Scanner (InputStream s) {
			br = new BufferedReader(new InputStreamReader(s)); 
		}
		Scanner(FileReader r) {
			br = new BufferedReader(r); 
			
		}
		String next() throws IOException {
			while(st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine()); 
			return st.nextToken(); 
		}
		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next()); 
		}
	}
}

