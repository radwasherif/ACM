package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF43B {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();

		int up[] = new int[26];
		int lo[] = new int[26];

//		System.out.println(s1);
//		System.out.println(s2);
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			if(c == ' ')
				continue; 
			if (Character.isUpperCase(c)) {
				up[c - 'A']++;
			} else {
				lo[c - 'a']++;
			}
		}
		boolean possible = true;
		for (int i = 0; i < s2.length(); i++) {
			char c = s2.charAt(i);
			if(c == ' ')
				continue; 
			if (Character.isUpperCase(c)) {
				if (up[c - 'A'] <= 0) {
//					System.out.println(c);
					possible = false;
				} else {
					up[c - 'A']--;
				}
			} else {
				if (lo[c - 'a'] <= 0) {
//					System.out.println(c);
					possible = false;
				} else {
					lo[c - 'a']--;
				}
			}
		}

		System.out.println(possible ? "YES" : "NO");
	}
}
