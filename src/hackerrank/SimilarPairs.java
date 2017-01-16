package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SimilarPairs {
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

	static SegmentTree st;
	static ArrayList<Integer>[] graph;
	static int T;
    static long ans; 
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		T = sc.nextInt();
		ans = 0;
		int N = 1;
		while (N < n)
			N <<= 1;
		st = new SegmentTree(new int[N + 1]); 
		graph = new ArrayList[n + 1];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Integer>(); 
		}
		boolean[] parent = new boolean[n + 1];
		for (int i = 0; i < n - 1; i++) {
			int u = sc.nextInt(), v = sc.nextInt();
			parent[v] = true;
			graph[u].add(v);
			graph[v].add(u);
		}
		int root = 0;
		for (int i = 1; i < parent.length; i++) {
			if (!parent[i])
				root = i;
		}
		//System.out.println(root);
		dfs(root, 0);
		System.out.println(ans);

	}

	static void dfs(int u, int p) {
		
		
		ans += st.query(u - T, u + T);
		st.update_point(u, 1);
//		System.out.println(u);
//		System.out.println(st.query(u - T, u + T));
		for (int v : graph[u]) {
			if (p != v)
			dfs(v, u);
		}
		st.update_point(u, 0);
	}
}

/*
 * This segment tree is to get a range sum query, in can be modified to get
 * range min query, range product query..etc.
 */

class SegmentTree {
	int N; // the number of elements in the array
	int array[];
	int st[];

	public SegmentTree(int in[]) { // we make sure that the length of this array
									// is padded to be a power of 2
									// and that it's one-indexed
		array = in;
		N = in.length - 1;
		st = new int[N << 1];

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
			st[node] = st[left(node)] + st[right(node)]; // this operation can
															// be modified to
															// get different
															// range queries
		}
	}

	void update_point(int index, int val) {
		/*
		 * if the original array of len = 4, the 1-based array is of len =5 so N
		 * = 4 to get the segment tree index of an element at index 1 in the
		 * 1-based array we no 1 + 4 -1 which is 1 + N -1
		 */

		index += N - 1;
		st[index] = val;
		index >>= 1;
		while (index >= 1) {
			st[index] = st[left(index)] + st[right(index)];
			index >>= 1;
		}
	}

	/*
	 * for the query we have 3 possibilities: 1- no overlap between the query
	 * interval and the start-end interval --> return 0 2- the query interval
	 * totally includes the start-end interval --> return the value of the node
	 * 3- partial overlap --> we search both sides
	 */
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
		return q1 + q2;

	}

	
}
