package contest.eight.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Skyline {
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

	static int ans;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {

			int b = sc.nextInt();
			int n = 100000; // number of elements

			int N = 1;
			while (N < n)
				N <<= 1; // padding to be a power of two

			int in[] = new int[N + 1];
			SegmentTree3 st = new SegmentTree3(in);
			//System.out.println("HERE");
			while (b-- > 0) {
				
				int l = sc.nextInt();
				int r = sc.nextInt();
				int h = sc.nextInt();
				st.update_range(l, r-1, h);
			}
			System.out.println(st.ans);
		}
	}
}

/*
 * This segment tree is to get a range sum query, in can be modified to get
 * range min query, range product query..etc.
 */
class SegmentTree3 {
	static class Node {
		int max, min;

		Node(int a, int b) {
			max = a;
			min = b;
		}
	}

	Node[] st;
	int[] array, lazy;
	int N, ans;

	SegmentTree3(int in[]) {
		array = in;
		N = in.length - 1;
		st = new Node[N << 1];
		lazy = new int[N << 1];
		build(1, 1, N);
	}

	int left(int n) {
		return n << 1;
	}

	int right(int n) {
		return (n << 1) + 1;
	}

	void build(int node, int start, int end) {
		// System.out.println(node + " " + start + " " + end );
		
		if (start == end) {
			st[node] = new Node(array[start], array[start]);
		} else {
			build(left(node), start, (start + end) / 2);
			build(right(node), (start + end) / 2 + 1, end);
			st[node] = combine(st[left(node)], st[right(node)]);
		}
	}

	/*
	 * for the query we have 3 possibilities: 1- no overlap between the query
	 * interval and the start-end interval --> return 0 2- the query interval
	 * totally includes the start-end interval --> return the value of the node
	 * 3- partial overlap --> we search both sides
	 */

	void update_range(int i, int j, int val) // O(log n)
	{
		update_range(1, 1, N, i, j, val);
	}

	void update_range(int node, int start, int end, int i, int j, int val) {
		if (i > end || j < start)
			return;
		// System.out.println(start + " " + end);
		if (i <= start && j >= end && val >= st[node].max) {
			st[node].max = val;
			st[node].min = val; //if range is covered.. then val is the only value we have 
			lazy[node] = val;
			ans += (end - start+1);
		} else if (val >= st[node].min) {
			propagate(node, start, end);
			update_range(left(node), start, (start + end) / 2, i, j, val);
			update_range(right(node), (start + end) / 2 + 1, end, i, j, val);
			st[node] = combine(st[node << 1], st[(node << 1) + 1]);
		}
	}

	void propagate(int node, int start, int end) {
		/*
		 * propagation is about the value that you want to move to your children
		 * Here we want the maximum value, not the sum of the values
		 */
		lazy[node << 1] = Math.max(lazy[node << 1], lazy[node]);
		lazy[(node << 1) + 1] = Math.max(lazy[(node << 1) + 1], lazy[node]);

		if (lazy[node] > st[left(node)].max)
			st[node << 1].max = lazy[node];
		if (lazy[node] > st[left(node)].min)
			st[node << 1].min = lazy[node];

		if (lazy[node] > st[right(node)].max)
			st[(node << 1) + 1].max = lazy[node];
		if (lazy[node] > st[right(node)].min)
			st[(node << 1) + 1].min = lazy[node];
		lazy[node] = 0;
	}

	Node combine(Node a, Node b) {
		return new Node(Math.max(a.max, b.max), Math.min(a.min, b.min));
	}
}
