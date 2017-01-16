package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class PersistenceBookcase {
	static boolean bookcase[][], inv[];
	static int rowCount[];
	static int m, n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out); 
		n = sc.nextInt();
		m = sc.nextInt();
		int q = sc.nextInt();
		bookcase = new boolean[n + 1][m + 1];
		inv = new boolean[n + 1];
		rowCount = new int[n + 1];
		Node N[] = new Node[q + 1];
		N[0] = new Node(0, 0, 0, 0);
		for (int x = 1; x <= q; x++) {
			int type = sc.nextInt();
			int parent = x - 1;
			Node child = null;
			if (type == 1) {
				int i = sc.nextInt();
				int j = sc.nextInt();
				child = new Node(type, i, j, -1);
			} else if (type == 2) {
				int i = sc.nextInt();
				int j = sc.nextInt();
				child = new Node(type, i, j, -1);
			} else if (type == 3) {
				int i = sc.nextInt();
				child = new Node(type, i, -1, -1);
			} else if (type == 4) {
				int k = sc.nextInt();
				parent = k;
				child = new Node(type, -1, -1, k);
			}
			N[x] = child; 
			N[parent].children.add(child);
		}
		N[0].dfs(0);
		for (int i = 1; i < N.length; i++) {
			out.println(N[i].count);
		}
		out.flush();
		out.close(); 
	}

	static class Node {
		int type, i, j, k, count;
		ArrayList<Node> children;

		Node(int type, int i, int j, int k) {
			this.type = type;
			this.i = i;
			this.j = j;
			this.k = k;
			children = new ArrayList<Node>();
		}

		void dfs (int count) {
			boolean update = false; 
			this.count = count; 
			if(type == 1) {
				if(!inv[i] && !bookcase[i][j] || inv[i] && bookcase[i][j]) {
					update = true; 
					bookcase[i][j] = !bookcase[i][j]; 
					this.count++; 
					rowCount[i]++; 
				} 
			} else if (type == 2) {
				if(!inv[i] && bookcase[i][j] || inv[i] && !bookcase[i][j]) {
					update = true;
					bookcase[i][j] = !bookcase[i][j]; 
					this.count--;
					rowCount[i]--; 
				}
			} else if(type == 3) {
				update = true; 
				inv[i] = !inv[i];
				this.count += (m - rowCount[i]) - rowCount[i]; 
				rowCount[i] = m - rowCount[i]; 
			} 
			for(Node n: children) 
				n.dfs(this.count);
			if(update) {
				if(type == 1) {
					if(!inv[i] && bookcase[i][j] || inv[i] && !bookcase[i][j]) { 
						bookcase[i][j] = !bookcase[i][j];  
						rowCount[i]--; 
					} 
				} else if (type == 2) {
					if(inv[i] && bookcase[i][j] || !inv[i] && !bookcase[i][j]) {
						bookcase[i][j] = !bookcase[i][j]; 
						rowCount[i]++; 
					}
				} else if(type == 3) {
					inv[i] = !inv[i]; 
					rowCount[i] = m - rowCount[i]; 
				}	
			}
//			System.out.println(count + " " + Arrays.toString(rowCount));
		}
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
	}

}
