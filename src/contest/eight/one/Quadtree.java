package contest.eight.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * UVA 297 - Quadtrees
 */

public class Quadtree {
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

	static class Node {
		Node[] n;
		int color, level;

		Node(Node n[], int color, int level) {
			this.n = n;
			this.color = color;
			this.level = level;
		}
	}

	// static ArrayList<int []> t1, t2;

	static int i;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); 
		while (t-- > 0) {
		String s1 = sc.next();
		String s2 = sc.next();
		i = 0;
		Node n1 = build(1024, s1);
		i = 0;
		Node n2 = build(1024, s2);
		System.out.println( "There are " + getBlack(n1, n2) + " black pixels.");
		}
		}

	static Node build(int weight, String s1) {
		if (s1.charAt(i) == 'e') {
			i++;
			return new Node(null, 0, weight);

		}

		if (s1.charAt(i) == 'f') {
			i++;
			return new Node(null, 1, weight);

		}

		// s1.charAt(i) == 'p'
		// System.out.println(s1.charAt(i));
		i++;
		Node a[] = new Node[4];
		for (int j = 0; j < a.length; j++) {

			a[j] = build(weight / 4, s1);

		}
		return new Node(a, -1, weight);

	}

	static int getBlack(Node n1, Node n2) {
		if (n1 == null && n2 == null)
			return 0;
		
		if (n1.color == 0 && n2.color == 0)
			return 0;
		if (n1.color == 1)
			return n1.level;
		if (n2.color == 1)
			return n2.level; 
		if (n1.color == -1 && n2.color == -1) 
		{
			int black =0; 
			for (int i = 0; i < 4; i++) {
				black += getBlack(n1.n[i], n2.n[i]);
			}
			
			return black; 
		}
		if (n1.color == 0) {
			return getBlack_(n2); 
		}
		return getBlack_(n1); 
	}
     static int getBlack_ (Node n) {
    	 if (n == null || n.color == 0)
    		 return 0; 
    	 if (n.color == 1)
    		 return n.level; 
    	 
    	 int b = 0; 
    	 for(int i = 0; i < 4; i++)
    		 b += getBlack_(n.n[i]); 
    	 return b; 
     }
}
