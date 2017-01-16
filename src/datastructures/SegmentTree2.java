package datastructures;

public class SegmentTree2 {
	static class Node {
		int max, freq; 
		
		Node(int a, int b) {
			max = a; 
			freq = b; 
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
			sTree [node]  = new Node (array[start], 1); 
		} 
		else {
			build (left(node), start, (start + end)/2); 
			build (right(node), (start + end)/2 + 1, end); 
			sTree[node] = combine (sTree [left(node)], sTree[right(node)] ); 
		} 
	}
	void update_point (int index , int val) {
		index += N-1; 
		sTree[index] = new Node (val, 1); 
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
			return new Node((int)-1e9, 0); // no overlap

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
		if (a.max > b.max) 
			return new Node (a.max, a.freq); 
		else if (a.max < a.freq) 
			return new Node (b.max, b.freq); 
		else 
			return new Node (a.max, a.freq + b.freq); 
	}
}
