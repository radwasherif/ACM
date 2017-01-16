package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class GalacticTaxes_UVa13010 {
	static int V, m;
	static ArrayList<Edge> adjList[];
	static double eps = 1e-11;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int TC = 5;
		while (true) {
			if(TC-- == 0)
				break; 
//		while (sc.ready()) {
			V = sc.nextInt();
			m = sc.nextInt();
			adjList = new ArrayList[V + 1];
			for (int i = 0; i < adjList.length; i++)
				adjList[i] = new ArrayList<Edge>();
			while (m-- > 0) {
				int i = sc.nextInt();
				int j = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				adjList[i].add(new Edge(j, a, b));
				adjList[j].add(new Edge(i, a, b));
			}
			double left = 0;
			double right = 24 * 60;
			double m1 = 0.0, m2 = 0.0;
			int c = 300;
			while (Math.abs(left - right) > eps) {
				m1 = left + (right - left) / (3.0);
				m2 = left + (2.0) * (right - left) / (3.0);
				// System.out.println(m1 + " " + m2);
				// System.out.println("vol: " + vol(m1) + " " + vol(m2));
				if(Math.abs(dijkstra(m2) - dijkstra(m1)) < eps) {
					left = m1; 
					right = m2; 
				}
				if (dijkstra(m1) < dijkstra(m2))
					left = m1;
				else if (dijkstra(m1) > dijkstra(m2))
					right = m2;
			}
			out.println(roundDecimal(dijkstra(m1)));
		}

		out.flush();
		out.close();
	}

	static String roundDecimal(double x) {
		return new DecimalFormat("0.00000").format(Math.round(x * 100000) / 100000.0);
	}

	static int INF = 1000000000;

	static double dijkstra(double t) {
		double dist[] = new double[V + 1];
		Arrays.fill(dist, INF);
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		pq.add(new Pair(1, 0));
		while (!pq.isEmpty()) {
			Pair cur = pq.remove();
			if (cur.node == V)
				return dist[cur.node];
			if (cur.wt > dist[cur.node])
				continue;
			for (Edge nxt : adjList[cur.node]) {
				double cost = cur.wt + nxt.a * t + nxt.b;
//				if (cost < 0)
//					return -INF;
				if (cost  + eps < dist[nxt.to])
					pq.add(new Pair(nxt.to, dist[nxt.to] = cost));
			}
		}
		return -1;

	}

	static class Edge {
		int a, b, to;

		Edge(int to, int aa, int bb) {
			a = aa;
			b = bb;
			this.to = to;
		}
	}

	static class Pair implements Comparable<Pair> {
		int node;
		double wt;

		Pair(int n, double w) {
			node = n;
			wt = w;
		}

		@Override
		public int compareTo(Pair o) {
			if (wt != o.wt)
				if (wt > o.wt)
					return 1;
				else
					return -1;
			return node - o.node;
		}
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		boolean ready() throws IOException {
			return br.ready();
		}

	}
}
