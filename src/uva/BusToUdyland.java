package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BusToUdyland {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		String ans = "NO\n";
		char[][] b = new char[n][5];
		for (int i = 0; i < n; i++)
			b[i] = br.readLine().toCharArray();
		for (int i = 0; i < n; i++)
			if (b[i][0] == 'O' && b[i][1] == 'O') {
				b[i][0] = '+';
				b[i][1] = '+';
				ans = "YES\n";
				break;
			} else {
				if (b[i][3] == 'O' && b[i][4] == 'O') {
					b[i][3] = '+';
					b[i][4] = '+';
					ans = "YES\n";
					break;
				}
			}
		sb.append(ans);
		for (int i = 0; ans.equals("YES\n") && i < n; i++) {
			for (int j = 0; j < 5; j++) {
				sb.append(b[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
