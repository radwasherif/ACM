package codeforces.gym;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class HorrorList {
	static ArrayList<Integer> adjList[];
	static final int INF = 1000000000;
	static int[] count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int h = sc.nextInt();
		int l = sc.nextInt();

		count = new int[n];
		Arrays.fill(count, INF);

		while (h-- > 0)
			count[sc.nextInt()] = 0;

		adjList = new ArrayList[n];
		for (int i = 0; i < adjList.length; i++)
			adjList[i] = new ArrayList<>();
		while (l-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adjList[a].add(b);
			adjList[b].add(a);
		}
//		System.out.println(Arrays.toString(count));
		for (int i = 0; i < n; i++) {
			if (count[i] == 0) {
				vis = new boolean[n];
				bfs(i);
			}
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int[] mirror = count.clone();
		Arrays.sort(mirror);
//		System.out.println(Arrays.toString(count));
//		System.out.println(Arrays.toString(mirror));
		int min = mirror[mirror.length-1];
		for (int i = 0; i < count.length; i++) {
			if (count[i] == min) {
				System.out.println(i);
				return;
			}
		}
	}

	static boolean vis[];

	static void bfs(int u) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(u);
		vis[u] = true;
		while (!q.isEmpty()) {
			u = q.poll();
			for (int v : adjList[u]) {
				if (!vis[v]) {
					vis[v] = true; 
					count[v] = Math.min(count[v], count[u] + 1);
					q.add(v);
				}
			}
		}
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		boolean ready() throws IOException {
			return br.ready();
		}

	}
}
