package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GATTACA_UVa11512 {
	static int maxLen;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		Trie t = new Trie(s);
		t.dfs(t.root, 0);
	}

	static class Trie {

		static class Node {
			Node[] next = new Node[26];
			int count;
		}

		Trie(String s) {
			for (int i = 0; i < s.length(); i++)
				put(s, i);
		}

		Node root = new Node();

		void put(String s, int idx) {
			Node cur = root;
			while (idx < s.length()) {
				cur.count++;
				Node nxt = cur.next[s.charAt(idx) - 'a'];
				if (nxt == null)
					nxt = cur.next[s.charAt(idx) - 'a'] = new Node();
				cur = nxt;
				idx++;
			}
		}

		void dfs(Node cur, int dep) {
			if (cur.count >= 2) {
				if (dep > maxLen) {
					maxLen = dep; 
				}
			}
			for (Node nxt : cur.next) {
				if(nxt != null)
					dfs(nxt, dep + 1); 
			}
		}
		String findString(Node cur, int dep, String s) {
			if(dep == 0) //TODO
				return s; 
			for(int i = 0; i < cur.next.length; i++) {
				Node nxt = cur.next[i]; 
				if(nxt != null)
					findString(nxt, dep - 1, s + (i + 'a'));
			}
			return null; 
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

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

		boolean ready() throws IOException {
			return br.ready();
		}
	}
}
