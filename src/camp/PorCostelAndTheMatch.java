package camp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PorCostelAndTheMatch {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(new FileReader("meciul.in"));
		PrintWriter out = new PrintWriter("meciul.out");
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
		
			DisjointSet ds = new DisjointSet(n + 2);
			while (m-- > 0) {
				int i = sc.nextInt() + 1;
				int j = sc.nextInt() + 1;
				if (ds.sameSet(i, j)) {
					out.println("NO");
					continue;
				} else if (ds.findSet(i) == i && ds.findSet(j) == j) {
					ds.union(0, i);
					ds.union(1, j);
				} else {
					int di = ds.findSet(i);
					int dj = ds.findSet(j);
					if ((di == 1 || di == 0) && dj == j)
						ds.union(j, di ^ 1);
					else if ((dj == 0 || dj == 1) && di == i)
						ds.union(i, dj ^ 1);
				}
				out.println("YES");
			}
		}
		out.flush();
		out.close();
	}

	static class DisjointSet {
		int[] rank, p, setSize;
		int numSets;

		public DisjointSet(int N) {
			rank = new int[N];
			p = new int[N];
			setSize = new int[N];
			numSets = N;
			Arrays.fill(setSize, 1); // initially all sets are of size 1
			for (int i = 0; i < p.length; i++) {
				p[i] = i; // each node is a parent of itself at the beginning
			}
		}

		int findSet(int i) {
			if (p[i] == i)
				return i;
			return p[i] = findSet(p[i]); // to make all nodes point to the root
											// directly
			// path compression
		}

		boolean sameSet(int i, int j) {
			return findSet(i) == findSet(j);
		}

		void union(int i, int j) {
			if (sameSet(i, j))
				return;
			numSets--;
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
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		Scanner(FileReader r) {
			br = new BufferedReader(r);
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}
	}
}
