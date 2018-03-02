package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * 
 * @author radwa
 *	Create union-find disjoint set with all strings. (hint:Map)  
 *	For every two strings s1 and s2 that differ in only one character, 
 *	join their sets together.
 *	For each query, if the two strings are in the same set, then one is reachable from the other. 
 *	Otherwise, neither is reachable from the other.  
 */
public class CarefulTeacher_UVa12460 {
	static TreeMap<String, Integer> tm;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		tm = new TreeMap<>();
		String dict[] = new String[20000];
		int val = 0;
		while (true) {
			String s = sc.nextLine();
			if (s.equals("--"))
				break;
			if (!tm.containsKey(s)) {
				tm.put(s, val);
				dict[val++] = s;
			}

		}
		DisjointSet ds = new DisjointSet(val);
		for (int i = 0; i < val && dict[i] != null; i++)
			for (int j = i + 1; j < val && dict[j] != null; j++)
				if (dict[i].length() != dict[j].length())
					continue;
				else if (countDiff(dict[i], dict[j]))
					ds.union(i, j);

		// int c = 6;
		while (sc.ready()) {
			// while (c-- > 0) {
			String s1 = sc.next();
			if (s1 == null || s1.equals(""))
				break;
			String s2 = sc.next();

			if (ds.sameSet(tm.get(s1), tm.get(s2)))
				out.println("Yes");
			else
				out.println("No");
		}
		out.flush();
		out.close();

	}

	static boolean countDiff(String string, String string2) {
		int count = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) != string2.charAt(i))
				count++;
			if (count > 1)
				return false;
		}
		return true;
	}

	static class DisjointSet {
		int[] p, rank;

		public DisjointSet(int n) {
			p = new int[n];
			for (int i = 0; i < n; i++)
				p[i] = i;
			rank = new int[n];
		}

		int find(int i) {
			if (p[i] == i)
				return i;
			return p[i] = find(p[i]);
		}

		boolean sameSet(int i, int j) {
			return find(i) == find(j);
		}

		void union(int i, int j) {
			if (sameSet(i, j))
				return;

			int x = find(i);
			int y = find(j);
			if (rank[x] > rank[y]) {
				p[y] = x;
			} else {
				p[x] = y;
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

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		boolean ready() throws IOException {
			return br.ready();
		}
	}
}
