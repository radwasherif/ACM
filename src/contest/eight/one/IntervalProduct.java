package contest.eight.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import datastructures.SegmentTree;

public class IntervalProduct {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer s; 
		StringBuilder sb = new StringBuilder(); 
		int counter  = 2; 
		while (bf.ready()) {
			//while (counter-->0) {
			s = new StringTokenizer(bf.readLine()); 
			int n = Integer.parseInt(s.nextToken()); // number of elements
			int k = Integer.parseInt(s.nextToken()); // the number of rounds

			int N = 1;
			while (N < n)
				N <<= 1; // padding to be a power of two

			int in[] = new int[N + 1];
			Arrays.fill(in, 1);
			s = new StringTokenizer(bf.readLine()); 
			for (int i = 1; i <= n; i++) {
				
				in[i] = Integer.parseInt(s.nextToken()); 
			}
			SegmentTree st = new SegmentTree(in); 
			
			for(int m =0; m < k; m++) {
				s = new StringTokenizer(bf.readLine()); 
				String c = s.nextToken();
				if (c.equals("C")){
					//System.out.println("Here!");	
					int index = Integer.parseInt(s.nextToken()); 
					int val = Integer.parseInt(s.nextToken());
					st.update_point(index, val);
				} else {
					//System.out.println("And.. Here!");
					int i = Integer.parseInt(s.nextToken());
					int j = Integer.parseInt(s.nextToken());
					int q = st.query(i, j); 
					if (q < 0) {
						sb.append('-'); 
						
					} else if (q == 0) {
						sb.append('0'); 
					} else {
						sb.append('+'); 
					}
				} 
				 
				
			}
			//System.out.println("OUT!");
			sb.append('\n');
			
		}
		System.out.print(sb.toString());
	
		 
	}
}

//class SegmentTree {
//	int N; // the number of elements in the array
//	int array[];
//	int st[];
//
//	public SegmentTree(int in[]) { // we make sure that the length of this array
//									// is padded to be a power of 2
//									// and that it's one-indexed
//		array = in;
//		N = in.length - 1;
//		st = new int[N << 1];
//
//		build(1, 1, N);
//
//	}
//
//	int left(int n) {
//		return n << 1;
//	}
//
//	int right(int n) {
//		return (n << 1) + 1;
//	}
//	
//	int sign(int n) { if (n > 0) return 1; if (n == 0) return 0;  return -1; }
//
//	void build(int node, int start, int end) {
//		if (start == end) {
//			st[node] = sign(array[start]);
//		} else {
//			build(left(node), start, (start + end) / 2);
//			build(right(node), (start + end) / 2 + 1, end);
//			st[node] = st[left(node)] * st[right(node)]; // this operation can
//															// be modified to
//															// get different
//															// range queries
//		}
//	}
//
//	void update_point(int index, int val) {
//		/*
//		 * if the original array of len = 4, the 1-based array is of len =5 so N
//		 * = 4 to get the segment tree index of an element at index 1 in the
//		 * 1-based array we no 1 + 4 -1 which is 1 + N -1
//		 */
//
//		index += N - 1;
//		st[index] = sign(val);
//		index >>= 1;
//		while (index >= 1) {
//			//System.out.println("Blah!");
//			st[index] = st[left(index)] * st[right(index)];
//			index >>= 1;
//		}
//	}
//
//	/*
//	 * for the query we have 3 possibilities: 1- no overlap between the query
//	 * interval and the start-end interval --> return 0 2- the query interval
//	 * totally includes the start-end interval --> return the value of the node
//	 * 3- partial overlap --> we search both sides
//	 */
//	public int query(int i, int j) {
//		return query(1, 1, N, i, j);
//	}
//
//	public int query(int node, int start, int end, int i, int j) {
//		if (i > end || j < start)
//			return 1; // no overlap
//
//		if (i <= start && j >= end)
//			return st[node];
//
//		int q1 = query(left(node), start, (start + end) / 2, i, j);
//		int q2 = query(right(node), (start + end) / 2 + 1, end, i, j);
//		return q1 * q2;
//
//	}
//
//}
