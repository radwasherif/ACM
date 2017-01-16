package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PlaceTheGuards_UVa11080 {
	static int V;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		while (T-- > 0) {
			V = sc.nextInt();
			graph = new ArrayList[V];
			for (int i = 0; i < graph.length; i++) {
				graph[i] = new ArrayList<Integer>();
			}
			int E = sc.nextInt();
			int p[] = new int[V];
			color = new int[V];
			Arrays.fill(color, -1);
			while (E-- > 0) {
				int i = sc.nextInt();
				int j = sc.nextInt();
				graph[i].add(j);
				graph[j].add(i);
				++p[j];
			}
			ArrayList<Integer> roots = new ArrayList<Integer>();
			for (int i = 0; i < V; i++) {
				if (p[i] == 0) {
					roots.add(i);

				}

			}
			// System.out.print("roots: ");
			// for (int i : roots) {
			// System.out.print(i + " ");
			//
			// }
			// System.out.println();
			int ans = 0;
			for (int u : roots) {
				// System.out.println(u);
				if (color[u] != -1) {
					continue;
				}

				// System.out.println(u);
				int ans1 = bipartite_bfs(u);
				int ans2 = 100000000;
				if (!graph[u].isEmpty()) {
					Arrays.fill(color, -1);
					ans2 = bipartite_bfs(graph[u].get(0));
				}
				if (ans1 == -1 || ans2 == -1) {
					ans = -1;
					break;
				}
				ans += Math.min(ans1, ans2);
				// System.out.println(Arrays.toString(color));
			}
			sb.append(ans);
			sb.append('\n');
		}
		System.out.print(sb);
	}

	static int color[]; // to be prefilled with -1

	static int bipartite_bfs(int s) {
		color[s] = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		int ans = 1;
		while (!q.isEmpty()) {
			int parent = q.poll();
			for (int child : graph[parent]) {
				if (color[child] == -1) {
					color[child] = 1 ^ color[parent];
					q.add(child);
					if (color[child] == 0)
						ans++;
				} else if (color[child] == color[parent]) {
					return -1;
				}
			}
		}
		return ans;
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
