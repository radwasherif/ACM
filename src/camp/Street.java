package camp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Street {
	static ArrayList<Pair> adjList[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(new FileReader("street.in"));
		PrintWriter out = new PrintWriter(System.out);
		int T = sc.nextInt();
		while (T-- > 0) {
			V = sc.nextInt() + 2;
			int H = sc.nextInt();
			int W = sc.nextInt();
			adjList = new ArrayList[V];
			for (int i = 0; i < adjList.length; i++) {
				adjList[i] = new ArrayList<>();
			}
			ArrayList<Q> blocks = new ArrayList<>();
			blocks.add(new Q(0, W, 0, 0));

			for (int i = 0; i < V - 2; i++) {
				int h = sc.nextInt();
				int w = sc.nextInt();
				int dist = sc.nextInt();
				int s = sc.nextInt();
				int x1, x2;
				if (s == 0) {
					x1 = 0;
					x2 = w;
				} else {
					x1 = W - w;
					x2 = W;
				}
				blocks.add(new Q(x1, x2, dist, dist + h));
			}

			blocks.add(new Q(0, W, H, H));
			for (int i = 0; i < V; i++) {
				for (int j = i + 1; j < V; j++) {
					Q block1 = blocks.get(i);
					Q block2 = blocks.get(j);
					double dist;
					if (intersect(block1.x1, block1.x2, block2.x1, block2.x2)) {
						dist = Math.min(Math.abs(block1.y1 - block2.y2), Math.abs(block1.y2 - block2.y1));

					} else if (intersect(block1.y1, block1.y2, block2.y1, block2.y2)) {
						dist = Math.min(Math.abs(block1.x1 - block2.x2), Math.abs(block1.x2 - block2.x1));
					} else {
						// System.out.println("YO" + " " + i + " " + j);
						int x1[] = { block1.x1, block1.x2, block1.x1, block1.x2 };
						int y1[] = { block1.y1, block1.y1, block1.y2, block1.y2 };

						int x2[] = { block2.x1, block2.x2, block2.x1, block2.x2 };
						int y2[] = { block2.y1, block2.y1, block2.y2, block2.y2 };
						dist = Math.sqrt(minDist(x1, y1, x2, y2));
					}
					adjList[i].add(new Pair(j, dist));
					adjList[j].add(new Pair(j, dist));
				}
			}
			// for (int i = 0; i < adjList.length; i++) {
			// System.out.println(i + " " + adjList[i].toString());
			// }
			double d = dijkstra(0, V - 1);
			out.printf("%.6f\n", d);
		}
		out.flush();
		out.close();

	}

	static int INF = (int) 1e9;
	static int V;

	static double dijkstra(int S, int T) {
		double dist[] = new double[V];
		Arrays.fill(dist, INF);
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		pq.add(new Pair(S, 0));
		while (!pq.isEmpty()) {
			Pair cur = pq.remove();
			if (cur.node == T)
				return dist[cur.node];
			if (cur.wt > dist[cur.node])
				continue;
			for (Pair nxt : adjList[cur.node])
				if (cur.wt + nxt.wt < dist[nxt.node])
					pq.add(new Pair(nxt.node, dist[nxt.node] = cur.wt + nxt.wt));
		}
		return -1;

	}

	static int minDist(int x1[], int y1[], int x2[], int y2[]) {
		int min = (int) 1e9;
		for (int i = 0; i < x1.length; i++) {
			for (int j = 0; j < x2.length; j++) {
				int dx = Math.abs(x1[i] - x2[j]);
				int dy = Math.abs(y1[i] - y2[j]);
				min = Math.min(min, dx * dx + dy * dy);
			}
		}
		return min;
	}

	static boolean intersect(int i1, int j1, int i2, int j2) {
		if (i1 >= i2 && i1 <= j2)
			return true;
		if (j1 >= i2 && j1 <= j2)
			return true;
		return false;
	}

	static class Q {
		int x1, x2, y1, y2; // 1 top left 2--> bottom right

		Q(int x1, int x2, int y1, int y2) {
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			// this.x2 = x2;
			this.y2 = y2;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "(" + x1 + ", " + y1 + ") (" + x2 + ", " + y2 + ")";
		}
	}

	static class Pair implements Comparable<Pair> {
		int node;
		double wt;

		Pair(int n, double d) {
			node = n;
			wt = d;
		}

		@Override
		public int compareTo(Pair o) {
			if (wt - o.wt < 0)
				return -1;
			else if (wt - wt > 0)
				return 1;

			return node - o.node;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "(" + node + ", " + wt + ")";
		}
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

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

		String nextLine() throws IOException {
			return br.readLine();
		}

	}
}
