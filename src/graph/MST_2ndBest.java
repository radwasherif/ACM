package graph;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class MST_2ndBest {
	static final int VALID = 1, INVALID = -1;
	static ArrayList<Edge> edgeList;
	static int V;
	static int valid[];
	static ArrayList<Integer> MST, mst2;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		while (T-- > 0) {
			V = sc.nextInt();
			int m = sc.nextInt();
			valid = new int[m];
			edgeList = new ArrayList<Edge>();
			MST = new ArrayList<Integer>();
			for (int i = 0; i < m; i++) {
				edgeList.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
			}
			Collections.shuffle(edgeList);
			Collections.sort(edgeList);
			Arrays.fill(valid, VALID);
			int s1 = mst(true);
			int s2 = 1000000000;
//			System.out.println(edgeList.toString());
//			System.out.println(MST.toString());
//			int i_min = 0;

			for (int i : MST) {
				mst2 = new ArrayList<Integer>();
				valid[i] = INVALID;
				int cur = mst(false);
				if (cur >= s1 && cur < s2) {
					s2 = cur;
//					i_min = i;
//					System.out.println(mst2.toString());
				}
				valid[i] = VALID;
			}
//			System.out.println(i_min);
			sb.append(s1 + " " + s2 + "\n");
		}
		System.out.print(sb);
	}

	/*
	 * O(ElogV)
	 */
	static int mst(boolean firstTime) {
		int mst = 0;

		DisjointSet ds = new DisjointSet(V);
		for (Edge e : edgeList) {
			int i = edgeList.indexOf(e);
			if (!ds.sameSet(e.s, e.e) && valid[i] == VALID) {
				mst += e.wt;
				ds.union(e.s, e.e);
				if (firstTime)
					MST.add(i);
				else
					mst2.add(i);
			}
		}
		return mst;
	}

	static class Edge implements Comparable<Edge> {
		int s, e, wt;

		Edge(int f, int t, int w) {
			s = f;
			e = t;
			wt = w;
		}

		@Override
		public int compareTo(Edge o) {
			if (wt != o.wt)
				return wt - o.wt;
			if (s != o.s)
				return s - o.s;
			return e - o.e;
		}

		public String toString() {
			return s + " " + e + " " + wt;
		}
	}

	static class DisjointSet {
		int[] rank, p, setSize;
		int numSets;

		public DisjointSet(int N) {
			rank = new int[N + 1];
			p = new int[N + 1];
			setSize = new int[N + 1];
			numSets = N;
			Arrays.fill(setSize, 1); // initially all sets are of size 1
			for (int i = 0; i < p.length; i++) {
				p[i] = i; // each node is a parent of itself at the beginning
			}
		}

		int findSet(int i) {
			if (p[i] == i)
				return i;
			return p[i] = findSet(p[i]);
		}

		boolean sameSet(int i, int j) {
			return findSet(i) == findSet(j);
		}

		void union(int i, int j) {
			if (sameSet(i, j))
				return;
			int x = findSet(i);
			int y = findSet(j);
			if (rank[x] > rank[y]) {
				p[y] = x;
				setSize[x] += setSize[y];
			} else {
				p[x] = y;
				setSize[y] += setSize[x];
				if (rank[x] == rank[y])
					rank[y]++;
			}
		}
	}

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
}

