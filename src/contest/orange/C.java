package contest.orange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder(); 
		int n = sc.nextInt(); // number of elements
		int k = sc.nextInt(); 
		int N = 1;
		while (N < n)
			N <<= 1; // padding to be a power of two

		int in[] = new int[N + 1];

		for (int i = 1; i <= n; i++) {
			in[i] = sc.nextInt();
		}
		SegmentTree st = new SegmentTree(in); 
		for(int i =1; i <= n-k+1; i++) {
			sb.append(st.query(i, i+k-1) + " "); 
		}
		System.out.print(sb.toString());
		
	}
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

}

/*
 * This segment tree is to get a range sum query, in can be modified to get range min query, range product query..etc. 
 */
class SegmentTree {
	int N; // the number of elements in the array
	int array[];
	int st[], lazy [] ;

	public SegmentTree(int in[]) { // we make sure that the length of this array
									// is padded to be a power of 2
									// and that it's one-indexed
		array = in;
		N = in.length - 1;
		st = new int[N << 1];
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
		if (start == end) {
			st[node] = array[start];
		} else {
			build(left(node), start, (start + end) / 2);
			build(right(node), (start + end) / 2 + 1, end);
			st[node] = Math.max(st[left(node)], st[right(node)]); // this operation can
															// be modified to
															// get different
															// range queries
		}
	}

		 
	public int query(int i, int j) {
		return query(1, 1, N, i, j);
	}

	public int query(int node, int start, int end, int i, int j) {
		if (i > end || j < start)
			return 0; // no overlap

		if (i <= start && j >= end)
			return st[node];

		int q1 = query(left(node), start, (start + end) / 2, i, j);
		int q2 = query(right(node), (start + end) / 2 + 1, end, i, j);
		return Math.max(q1, q2);

	}

	
	}

