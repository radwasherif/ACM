package graph;

public class Floyd {
	static int adjMat[][];
	static int dist[][];
	static int P[][]; // predecessors
	static int N;

	static int[][] floyd(int[][] adjMat) {
		int N = adjMat.length;
		int dist[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) {
					dist[i][j] = 0;
					P[i][j] = -1;
				} else {
					dist[i][j] = adjMat[i][j];
					P[i][j] = i;
				}
			}
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int oldD = dist[i][j];
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
					if (oldD != dist[i][j])
						P[i][j] = P[k][j];
				}
			}
		}

		return dist;
	}
}
