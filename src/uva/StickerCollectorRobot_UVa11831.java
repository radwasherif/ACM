package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StickerCollectorRobot_UVa11831 {
	static int n, m, s, row, col;
	static char[][] graph;
	static char dir;
	static int count;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (true) {
			n = sc.nextInt();
			m = sc.nextInt();
			s = sc.nextInt();
			if (n == 0 && m == 0 && s == 0)
				break;
			graph = new char[n][m];
			count = 0;
			for (int i = 0; i < n; i++) {
				String s = sc.next();
				for (int j = 0; j < m; j++) {
					graph[i][j] = s.charAt(j);
					if (graph[i][j] == 'N' || graph[i][j] == 'S'
							|| graph[i][j] == 'L' || graph[i][j] == 'O') {
						row = i;
						col = j;
						dir = graph[i][j];
					}
				}
			}

			String com = sc.next();
			//System.out.println(Arrays.deepToString(graph));
			for (int i = 0; i < s; i++) {

				move(com.charAt(i));
			}
			//System.out.println(Arrays.deepToString(graph));
			sb.append(count + "\n");
		}
		System.out.print(sb);
	}

	static boolean valid(int row, int col) {
		return row >= 0 && row < graph.length && col >= 0 && col < graph[row].length
				&& graph[row][col] != '#';
	}

	static void move(char c) {
		if (c == 'F') {
			
			int newR, newC;
			switch (dir) {
			case 'N':
				newR = row - 1;
				newC = col;
				break; // up
			case 'S':
				newR = row + 1;
				newC = col;
				break; // down
			case 'L':
				newR = row;
				newC = col + 1;
				break; // right
			default:
				newR = row;
				newC = col - 1;
			}
			//System.out.println(newR + " " + newC);
			if (valid(newR, newC)) {
				row = newR;
				col = newC;
				//System.out.println(row + " " + col);
				if (graph[row][col] == '*') {
					count++;
					graph[row][col] = '.';
				}
				
			}
			return;
		}

		if (c == 'D') {

			if (dir == 'N')
				dir = 'L';
			else if (dir == 'S')
				dir = 'O';
			else if (dir == 'L')
				dir = 'S';
			else if (dir == 'O')
				dir = 'N';
			//System.out.println("after: " + dir);
			return;
		}
		if (c == 'E') {
			if (dir == 'N')
				dir = 'O';
			else if (dir == 'S')
				dir = 'L';
			else if (dir == 'L')
				dir = 'N';
			else if (dir == 'O')
				dir = 'S';
			//System.out.println("after: " + dir);
			return;
		}
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {

			br = new BufferedReader(new InputStreamReader(s));

		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}

}
