package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Ordering {
	static int N;
	static ArrayList<Integer>[] adjList;
	static TreeMap<String, Integer> map;
	static String deMap[];
	static int[] inDegree, result;
	static boolean[] taken;
	static StringBuilder sb = new StringBuilder();

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			br.readLine();
			st = new StringTokenizer(br.readLine());
			N = st.countTokens();
			// System.out.println(N);
			map = new TreeMap<String, Integer>();
			deMap = new String[N];
			inDegree = new int[N];
			result = new int[N];
			taken = new boolean[N];
			int idx = 0;
			while (st.hasMoreTokens()) {
				String node = st.nextToken();
				map.put(node, idx);
				deMap[idx++] = node;
			}
			// System.out.println("HERE");
			adjList = new ArrayList[N];
			for (int i = 0; i < adjList.length; i++) {
				adjList[i] = new ArrayList<Integer>();
			}
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				StringTokenizer s = new StringTokenizer(st.nextToken(), "<");
				int i = map.get(s.nextToken());
				int j = map.get(s.nextToken());
				if (!adjList[i].contains(j)) {
					adjList[i].add(j);
					// inDegree[j]++;
				}
			}
			for (int u = 0; u < N; u++) {
				for (int v : adjList[u])
					++inDegree[v];
			}
			// System.out.println(N);
			// System.out.println(Arrays.toString(inDegree));
			backtrack(0);
			if(T > 0)
			sb.append("\n");
		}
		System.out.print(sb);
	}

	static void backtrack(int idx) {
		if (idx == N) {
			sb.append(deMap[result[0]]);
			for (int i = 1; i < N; i++)
				sb.append(" " + deMap[result[i]]);
			sb.append("\n");
		} else {
			boolean f = true;
			for (int i = 0; i < inDegree.length; i++) {
				if (!taken[i] && inDegree[i] == 0)
					f = false;
			}
			if (f)
				sb.append("NO\n");
		}
		for (int u = 0; u < N; u++) {
			if (inDegree[u] == 0 && !taken[u]) {
				taken[u] = true;
				for (int v : adjList[u])
					--inDegree[v];
				result[idx] = u;
				backtrack(idx + 1);

				taken[u] = false;
				for (int v : adjList[u])
					++inDegree[v];
			}
		}
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		String nextLine() throws IOException {
			return br.readLine();
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
