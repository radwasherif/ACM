package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * 355 - b
 *
 */

public class VanyaAndFood {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken()), h = Integer.parseInt(st
				.nextToken()), k = Integer.parseInt(st.nextToken());
		int a[] = new int[n];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		int currH = 0;
		int i = 0;
		int time = 0;
		while (n > 0) {
			while (i < a.length && currH + a[i] <= h) {
					
			}
			time++;
			currH -= k;
			if (currH < 0)
				currH = 0;
			while (i < a.length && currH + a[i] > h) {
				currH -= k;
				if (currH < 0)
					currH = 0;
				time++;
			}

		}
		while (currH > 0) {
			currH -= k;
			time++;
		}

		System.out.println(time);

	}
}