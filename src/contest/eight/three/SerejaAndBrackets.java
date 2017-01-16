package contest.eight.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import datastructures.SegmentTree;



public class SerejaAndBrackets {
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		String s = br.readLine(); 
		int n = s.length();  // number of elements

		int N = 1;
		while (N < n)
			N <<= 1; // padding to be a power of two

		int in[] = new int[N + 1];

		for (int i = 1; i <= n; i++) {
			if(s.charAt(i-1)== '(')
				in[i] = 1; 
			else 
				in[i] = 0; 
		}
		System.out.println(Arrays.toString(in));
		SegmentTree2 st = new SegmentTree2(in);
		int m = sc.nextInt(); 
		while(m-->0) {
			int i = sc.nextInt(); 
			int j = sc.nextInt(); 
			System.out.println(st.query(i, j).max);
		}
	}
}

class SegmentTree2 {
	static class Node {
		int max, left, right; 
		
		Node(int a, int b, int c) {
			right = a; 
			left = b;
			max = c; 
		}
	} 
	
	Node [] sTree; 
	int [] array, lazy; 
	int N; 
	
	SegmentTree2 (int in []) {
		array = in; 
		N = in.length - 1;
		sTree = new Node[N << 1];
		lazy = new int[N<<1]; 
		build(1, 1, N);
	}
	
	int left(int n) {
		return n << 1;
	}

	int right(int n) {
		return (n << 1) + 1;
	}
   
	void build (int node, int start, int end) {
		if (start == end) {
			if(array[start] == 1)
			sTree [node]  = new Node (1, 0, 0);
			else {
				sTree[node] = new Node(0, 1, 0); 
			}
		} 
		else {
			build (left(node), start, (start + end)/2); 
			build (right(node), (start + end)/2 + 1, end); 
			sTree[node] = combine (sTree [left(node)], sTree[right(node)] ); 
		} 
	}
//	void update_point (int index , int val) {
//		index += N-1; 
//		sTree[index] = new Node (val, 1); 
//		index >>=1;
//		while (index >= 1) {
//			sTree[index]  = combine(sTree[right(index)], sTree[left(index)]); 
//			index >>=1; 
//		}
//	}
	
	public Node query(int i, int j) {
		return query(1, 1, N, i, j);
	}

	public Node query(int node, int start, int end, int i, int j) {
		if (i > end || j < start)
			return new Node(-1, -1, -1); // no overlap

		if (i <= start && j >= end)
			return sTree[node];

		Node q1 = query(left(node), start, (start + end) / 2, i, j);
		Node q2 = query(right(node), (start + end) / 2 + 1, end, i, j);
		return  combine(q1, q2); 

	} 
	void update_range(int i, int j, int val) // O(log n)
	{
		update_range(1, 1, N, i, j, val);
	}

	void update_range(int node, int start, int end, int i, int j, int val) {
		if (i > end || j < start)
			return;
      if(start == end)
        	return; 
		//System.out.println(start + " " + end);
		if (i <= start && j >= end) {
			sTree[node].max += val;
			//sTree[node].min += val; 
			lazy[node] += val; 
			//ans+= (end - start + 1);  
		} else {
			propagate(node, start, end); 
			update_range(left(node), start, (start + end)/2, i, j, val);
			update_range(right(node), (start + end )/2 + 1, end, i, j, val);
			sTree[node] = combine(sTree[node<<1], sTree[(node<<1)+1]);
		}
	}
	void propagate(int node, int start, int end) {
		lazy[node<<1] += lazy[node];
		lazy[(node<<1)+1] += lazy[node];
		sTree[node<<1].max += lazy[node];
		//sTree[node<<1].min += lazy[node];
		sTree[(node<<1)+1].max += lazy[node];
		//st[(node<<1)+1].min += lazy[node];
		lazy[node] = 0;
	}

	Node combine(Node a, Node b) {
		int max = a.max + b.max; 
		if(a.right >= b.left) {
			max += a.right - b.left; 
			a.right -= b.left; 
			b.left =0; 
		} else {
			max += a.left - b.right;
			b.left -= a.right; 
			a.right = 0; 
		}
		return new Node (a.right + b.right, a.left + b.left, max); 
	}
}
