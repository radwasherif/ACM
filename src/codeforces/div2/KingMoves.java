package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KingMoves {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int j = s.charAt(0) - 'a';
		int i = -1 * (s.charAt(1) - '8');
//		System.out.println(i + " " + j);
		int dx[] = { 0, 0, 1, 1, 1, -1, -1, -1 };
		int dy[] = { 1, -1, 0, 1, -1, 0, 1, -1 };
		int ans = 0;
		for (int k = 0; k < dy.length; k++) {
			if (valid(i + dx[k], j + dy[k])) {
				ans++;
			}
		}
		System.out.println(ans);
	}

	static boolean valid(int i, int j) {
		return i >= 0 && i < 8 && j >= 0 && j < 8;
	}
}
