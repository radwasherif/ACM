package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchTheKhoj {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			String a[] = new String[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = br.readLine();
			}
			String s = br.readLine();
			sb.append("Case " + t + ":\n");
			for (int i = 0; i < a.length; i++) {
				int c = 0;
				for (int j = 0; j < a[i].length(); j++) {
					if (s.charAt(j) != a[i].charAt(j))
						c++;
				}
				if (c <= 1)
					sb.append(a[i] + "\n");
			}
		}
		System.out.print(sb);
	}

}
