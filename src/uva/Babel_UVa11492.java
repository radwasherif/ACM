package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Babel_UVa11492 {
	static int N;
	static TreeMap<String, Integer> lang, word;
	static int[][] langOfWord;
	static ArrayList<Integer> wordOfLang[];
	static char[] deMapWord;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (true) {
			N = sc.nextInt();
			if (N == 0)
				break;
			int cL = 0, cW = 0;
			deMapWord = new char[N];
			langOfWord = new int[N][3]; // 0: length of word, 1 and 2 languages
			wordOfLang = new ArrayList[N * 2 + 2];
			for (int i = 0; i < wordOfLang.length; i++)
				wordOfLang[i] = new ArrayList<Integer>();

			lang = new TreeMap<String, Integer>();
			word = new TreeMap<String, Integer>();
			lang.put(sc.next(), cL++);
			lang.put(sc.next(), cL++);
			for (int i = 0; i < N; i++) {
				String l1 = sc.next();
				String l2 = sc.next();
				String w = sc.next();
				deMapWord[cW] = w.charAt(0);
				word.put(w, cW);
				int idx1;
				int idx2;
				if (!lang.containsKey(l1))
					lang.put(l1, idx1 = cL++);
				else
					idx1 = lang.get(l1);
				if (!lang.containsKey(l2))
					lang.put(l2, idx2 = cL++);
				else
					idx2 = lang.get(l2);
				langOfWord[i][0] = w.length();
				langOfWord[i][1] = idx1;
				langOfWord[i][2] = idx2;
				// System.out.println("N " + N);
				// System.out.println(lang.size());
				// System.out.println(wordOfLang.length);
				wordOfLang[idx1].add(cW);
				wordOfLang[idx2].add(cW);
				cW++;
			}
			int d = dijkstra(0, 1);
			sb.append(((d == -1) ? "impossivel" : d) + "\n");
		}
		System.out.print(sb);
	}

	static final int INF = 1000000000;

	static int dijkstra(int S, int T) {
		int dist[] = new int[N];
		Arrays.fill(dist, INF);
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		for (int w : wordOfLang[0]) {
			pq.add(new Pair(w, langOfWord[w][0]));
			dist[w] = langOfWord[w][0];
		}
		while (!pq.isEmpty()) {
			Pair cur = pq.remove();
			if (langOfWord[cur.node][1] == T || langOfWord[cur.node][2] == T)
				return dist[cur.node];
			if (cur.wt > dist[cur.node])
				continue;
			for (int i = 1; i < langOfWord[cur.node].length; i++) {
				int l = langOfWord[cur.node][i];
				for (int nxt : wordOfLang[l]) {
					if (deMapWord[cur.node] == deMapWord[nxt])
						continue;
					int cost = langOfWord[nxt][0] + cur.wt;
					if (cost < dist[nxt]) {
						pq.add((new Pair(nxt, dist[nxt] = cost)));
						// System.out.println(nxt + " " + cost);
					}
				}
			}
		}

		return -1;
	}

	static class Pair implements Comparable<Pair> {
		int node, wt;

		Pair(int n, int w) {
			node = n;
			wt = w;
		}

		@Override
		public int compareTo(Pair o) {
			if (wt != o.wt)
				return wt - o.wt;
			return node - o.node;
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

	}
}
