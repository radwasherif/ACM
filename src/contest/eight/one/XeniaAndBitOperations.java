package contest.eight.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;






public class XeniaAndBitOperations {
	static class Scanner 
	{
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
  public static void main(String[] args) throws IOException {
	  Scanner sc = new Scanner(System.in); 
	  int n = 1 <<sc.nextInt(); 
	 // System.out.println(n);
	  int m = sc.nextInt(); 
	  int N = 1; while( N < n) N <<=1; //padding to be a power of two 
		//System.out.println(N);
		int in [] = new int [N + 1];
	    
		for (int i = 1; i <= n; i++) {
			in[i] = sc.nextInt(); 
		}
		
		SegmentTree2 sTree = new SegmentTree2(in); 
		StringBuilder sb = new StringBuilder(); 
		for (int i = 0; i < m; i++) {
			sTree.update_point(sc.nextInt(), sc.nextInt());
			sb.append(sTree.query(1, n).max + "\n"); 
		} 
		System.out.print(sb.toString());
}
  
  
 
}

class SegmentTree2 {
	static class Node {
		int max, op; // op = 1 for OR, op = 0 for XOR

		Node(int a, int b) {
			max = a;
			op = b;
		}
	}

	Node[] sTree;
	int[] array;
	int N;

	SegmentTree2(int in[]) {
		array = in;
		N = in.length - 1;
		sTree = new Node[N << 1];

		build(1, 1, N);
	}

	int left(int n) {
		return n << 1;
	}

	int right(int n) {
		return (n << 1 )+ 1;
	}

	void build(int node, int start, int end) {
		if (start == end) {
			//System.out.println(start);
			sTree[node] = new Node(array[start], 0);
		} else {
			build(left(node), start, (start + end) / 2);
			build(right(node), (start + end) / 2 + 1, end);
			sTree[node] = combine(sTree[left(node)], sTree[right(node)]);
		}
	}

	
	void update_point (int index , int val) {
		index += N-1; 
		sTree[index] = new Node (val, 0); 
		index >>=1;
		while (index >= 1) {
			sTree[index]  = combine(sTree[right(index)], sTree[left(index)]); 
			index >>=1; 
		}
	}
	
	public Node query(int i, int j) {
		return query(1, 1, N, i, j);
	}

	public Node query(int node, int start, int end, int i, int j) {
		if (i > end || j < start)
			return new Node(0, sTree[node].op); // no overlap

		if (i <= start && j >= end)
			return sTree[node];

		Node q1 = query(left(node), start, (start + end) / 2, i, j);
		Node q2 = query(right(node), (start + end) / 2 + 1, end, i, j);
		return  combine(q1, q2); 

	} 
	Node combine(Node a, Node b) {
		if (a.op == 1)
			return new Node(a.max ^ b.max, 0);
		else
			return new Node(a.max | b.max, 1);
	}
}
