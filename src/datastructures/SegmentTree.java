package datastructures;

import java.util.Scanner;

/*
 * This segment tree is to get a range sum query, in can be modified to get range min query, range product query..etc. 
 */

public class SegmentTree {
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
			st[node] = st[left(node)] + st[right(node)]; // this operation can
															// be modified to
															// get different
															// range queries
		}
	}

	public void update_point(int index, int val) {
		/*
		 * if the original array of len = 4, the 1-based array is of len =5 so N
		 * = 4 to get the segment tree index of an element at index 1 in the
		 * 1-based array we no 1 + 4 -1 which is 1 + N -1
		 */

		index += N - 1;
		st[index] += val;
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

	void update_range(int i, int j, int val) // O(log n)
	{
		update_range(1, 1, N, i, j, val);
	}

	void update_range(int node, int start, int end, int i, int j, int val) {
		if (i > end || j < start)
			return;

		if (i >= start && j <= end) {
			st[node] += (end - start + 1) * val;
			lazy[node] += val; 
		} else {
			propagate(node, start, end); 
			update_range(right(node), start, (start + end)/2, i, j, val);
			update_range(left(node), (start + end )/2 + 1, end, i, j, val);
			st[node] = st[node<<1] + st[(node<<1)+1];
		}
	}
	void propagate(int node, int start, int end) {
		int mid = (start + end)/2;
		lazy[node<<1] += lazy[node];
		lazy[(node<<1)+1] += lazy[node];
		st[node<<1] += (mid-start+1)*lazy[node];		
		st[(node<<1)+1] += (end-mid)*lazy[node];		
		lazy[node] = 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // number of elements

		int N = 1;
		while (N < n)
			N <<= 1; // padding to be a power of two

		int in[] = new int[N + 1];

		for (int i = 1; i <= n; i++) {
			in[i] = sc.nextInt();
		}

		SegmentTree st = new SegmentTree(in);
		System.out.println(st.query(2, 4));

	}
}
