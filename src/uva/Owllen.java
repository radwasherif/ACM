package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Owllen {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for (int x = 1; x <= T; x++) {
			String s = bf.readLine(); 
			int letters [] = new int[26]; 
			for (int i = 0; i < s.length(); i++) {
				letters[s.charAt(i) - 'a']++; 
			}
			int min = 1000000; 
			for (int i = 0; i < letters.length; i++) {
				min = Math.min(min, letters[i]); 
			}
			sb.append("Case "  + x + ": " + min + "\n"); 
		}
		System.out.print(sb);
	}
}
